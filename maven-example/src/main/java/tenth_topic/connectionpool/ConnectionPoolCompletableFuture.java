package tenth_topic.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ConnectionPoolCompletableFuture {
    private static int INITIAL_POOL_SIZE = 5;
    private static volatile ConnectionPoolCompletableFuture INSTANCE;
    private static int THREAD_POOL_SIZE = 7;
    private ConcurrentLinkedQueue<MockConnection> availableConnections = new ConcurrentLinkedQueue<>();
    private ThreadLocal<ConcurrentLinkedQueue<MockConnection>> threadConnectionPool = ThreadLocal.withInitial(ConcurrentLinkedQueue::new);
    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    private static final Logger log = LogManager.getLogger(ConnectionPool.class.getName());

    // Lazy initialized
    public static ConnectionPoolCompletableFuture getInstance() {
        if (INSTANCE == null) {
            synchronized (ConnectionPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPoolCompletableFuture();
                }
            }
        }
        return INSTANCE;
    }

    public ConnectionPoolCompletableFuture() {
        log.info("Connection pool initialization...");
        initConnectionPool();
    }

    private void initConnectionPool() {
        availableConnections = new ConcurrentLinkedQueue<>();
    }

    public synchronized MockConnection createNewConnection(String url, String name, String password) {
        MockConnection newMockConnection = new MockConnection(url, name, password);
        if (threadConnectionPool.get().size() < THREAD_POOL_SIZE) {
            threadConnectionPool.get().add(newMockConnection);
            System.out.println("New connection "+ newMockConnection.getUrl() + " is added to the thread pool.");
        } else {
            System.out.println("Thread Connection Pool is full, new connection "
                    + newMockConnection.getUrl() + " is not added.");
        }
        return newMockConnection;
    }

    public CompletionStage<MockConnection> getConnectionCompletionStage(long timeout) {
        long timestamp = System.currentTimeMillis() + timeout;
        CompletableFuture<MockConnection> completableFuture = new CompletableFuture<>();
        if (threadConnectionPool.get().size() > 0) {
            if (availableConnections.size() < INITIAL_POOL_SIZE) {
                MockConnection connection = threadConnectionPool.get().poll();
                availableConnections.add(connection);
                completableFuture.complete(connection);
                try {
                    System.out.println(completableFuture.get().toString());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    this.wait(Math.max(timestamp - System.currentTimeMillis(), 1));
                    if (timestamp <= System.currentTimeMillis()) {
                        System.out.println("The current connection pool contains:" + "\n"
                                + availableConnectionsToString());
                        throw new InterruptedException("Connection not available");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (threadConnectionPool.get().size() == 0) {
            System.out.println("Please create a new connection");
        }
        return completableFuture;
    }

    public synchronized void releaseConnection(MockConnection mockConnection) {
        synchronized (this) {
            Iterator iterator = availableConnections.iterator();
            boolean isBreak = false;
            while (iterator.hasNext()) {
                MockConnection current = (MockConnection) iterator.next();
                if (current.getUrl().equals(mockConnection.getUrl())
                        && current.getUserName().equals(mockConnection.getUserName())
                        && current.getPassword().equals(mockConnection.getPassword())) {
                    availableConnections.remove(current);
                    if (threadConnectionPool.get().size() < THREAD_POOL_SIZE) {
                        threadConnectionPool.get().add(current);
                        System.out.println(current.getUrl()
                                + " was released from the connection pool to the thread pool.");
                    } else {
                        System.out.println(current.getUrl() + " was released from the connection pool.");
                    }
                    isBreak = true;
                    break;
                }
            }
            if (isBreak == false) {
                System.out.println("Connection not available.");
            }
        }
    }

    public String availableConnectionsToString() {
        String res = "";
        Iterator iterator = availableConnections.iterator();
        while (iterator.hasNext()) {
            res += iterator.next().toString() + '\n';
        }
        return res;
    }
}
