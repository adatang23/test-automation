package tenth_topic.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.concurrent.*;


public class ConnectionPool {

    private static int INITIAL_POOL_SIZE = 5;
    private static volatile ConnectionPool INSTANCE;
    private static int THREAD_POOL_SIZE = 7;
    private ConcurrentLinkedQueue<MockConnection> availableConnections = new ConcurrentLinkedQueue<>();
    private ThreadLocal<ConcurrentLinkedQueue<MockConnection>> threadConnectionPool = ThreadLocal.withInitial(ConcurrentLinkedQueue::new);
    private static final Logger log = LogManager.getLogger(ConnectionPool.class.getName());


    // Lazy initialized
    public static ConnectionPool getInstance() {
        if (INSTANCE == null) {
            synchronized (ConnectionPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPool();
                }
            }
        }
        return INSTANCE;
    }

    public ConnectionPool() {
        log.info("Connection pool initialization...");
        initConnectionPool();
    }

    private void initConnectionPool() {
        availableConnections = new ConcurrentLinkedQueue<>();
    }


    /**
     * Create a new connection and check the thread connection pool size
     * if the thread connection pool size < 7,
     * add the new connection to the end of the thread connection pool
     */
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


    /**
     * if the thread connection pool size > 0, if the available connection pool size < 5,
     * get the first connection from the thread connection pool with threadConnectionPool.get().poll()
     * add this connection to the end of the available connection pool;
     * else if the available connection pool size == 5, the current thread wait for some time;
     * if it is timeout, throw a new exception "Connection not available"
     * The 2 threads waiting for the next available connection will be moved
     * to the front of the concurrentLinkedQueue
     */
    public synchronized void getConnection(long timeout) throws InterruptedException {
        long timestamp = System.currentTimeMillis() + timeout;
        synchronized (this) {
            if (threadConnectionPool.get().size() > 0) {
                if (availableConnections.size() < INITIAL_POOL_SIZE) {
                    MockConnection connection = threadConnectionPool.get().poll();
                    availableConnections.add(connection);
                    System.out.println("Successfully get new connection "+ connection.getUrl() + " from the thread pool");
                } else {
                    this.wait(Math.max(timestamp - System.currentTimeMillis(), 1));
                    if (timestamp <= System.currentTimeMillis()) {
                        System.out.println("The current connection pool contains:" + "\n"
                                + this.availableConnectionsToString());
                        throw new InterruptedException("Connection not available");
                    }
                }
            }
        }
        if (threadConnectionPool.get().size() == 0) {
            System.out.println("Please create a new connection");
        }
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
