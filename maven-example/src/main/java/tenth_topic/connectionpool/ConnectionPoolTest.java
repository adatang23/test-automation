package tenth_topic.connectionpool;

public class ConnectionPoolTest {
    public static void main(String[] args) throws Exception {
        /**
         * Test01 of ConnectionPool.java:
         * 7 connections can be added to the thread pool, and adding another one was not allowed.
         * 5 connections can be moved from the thread pool to the connection pool
         * from the beginning towards the end. (ConcurrentLinkedQueue FIFO)
         * A particular connection can be released from the connection pool.
         */
        System.out.println("Test01 of ConnectionPool.java:");
        ConnectionPool.getInstance();
        ConnectionPool connectionPool01 = new ConnectionPool();
        connectionPool01.getConnection(1);
        connectionPool01.createNewConnection("jdbc:h2:mem:test00", "user00", "pwd00");
        connectionPool01.getConnection(1);
        connectionPool01.createNewConnection("jdbc:h2:mem:test01", "user01", "pwd01");
        connectionPool01.createNewConnection("jdbc:h2:mem:test02", "user02", "pwd02");
        connectionPool01.createNewConnection("jdbc:h2:mem:test03", "user03", "pwd03");
        connectionPool01.createNewConnection("jdbc:h2:mem:test04", "user04", "pwd04");
        connectionPool01.createNewConnection("jdbc:h2:mem:test05", "user05", "pwd05");
        connectionPool01.createNewConnection("jdbc:h2:mem:test06", "user06", "pwd06");
        connectionPool01.createNewConnection("jdbc:h2:mem:test07", "user07", "pwd07");
        connectionPool01.createNewConnection("jdbc:h2:mem:test08", "user08", "pwd08");
        connectionPool01.getConnection(1);
        System.out.println("Current connection pool:" + "\n"
                + connectionPool01.availableConnectionsToString());
        connectionPool01.releaseConnection(new MockConnection("jdbc:h2:mem:test00",
                "user00", "pwd00"));
        connectionPool01.getConnection(1);
        connectionPool01.getConnection(1);
        connectionPool01.getConnection(1);
        connectionPool01.getConnection(1);
        System.out.println("Current connection pool:" + "\n"
                + connectionPool01.availableConnectionsToString());
        System.out.println("");


        /**
         * wait() method in Java: Syntax: public final void wait() throws InterruptedException
         * Test02 of ConnectionPool.java:
         * 7 connections can be added to the thread pool, and adding another one was not allowed.
         * 5 connections can be moved from the thread pool to the connection pool
         * from the beginning towards the end. (ConcurrentLinkedQueue FIFO)
         * the other connections should wait in the thread pool
         * when there are 5 connections in the connection pool. Otherwise, throw an exception.
         */
        System.out.println("Test02 of ConnectionPool.java:" + "\n"
                + "Throw exception when adding another connection to the connection pool" + "\n"
                + "when there are 5 connections in the connection pool.");
        ConnectionPool.getInstance();
        ConnectionPool connectionPool02 = new ConnectionPool();
        connectionPool02.getConnection(1);
        connectionPool02.createNewConnection("jdbc:h2:mem:test00", "user00", "pwd00");
        connectionPool02.getConnection(1);
        connectionPool02.createNewConnection("jdbc:h2:mem:test01", "user01", "pwd01");
        connectionPool02.createNewConnection("jdbc:h2:mem:test02", "user02", "pwd02");
        connectionPool02.createNewConnection("jdbc:h2:mem:test03", "user03", "pwd03");
        connectionPool02.createNewConnection("jdbc:h2:mem:test04", "user04", "pwd04");
        connectionPool02.createNewConnection("jdbc:h2:mem:test05", "user05", "pwd05");
        connectionPool02.createNewConnection("jdbc:h2:mem:test06", "user06", "pwd06");
        connectionPool02.createNewConnection("jdbc:h2:mem:test07", "user07", "pwd07");
        connectionPool02.createNewConnection("jdbc:h2:mem:test08", "user08", "pwd08");
        connectionPool02.getConnection(1);
        connectionPool02.getConnection(1);
        connectionPool02.getConnection(1);
        connectionPool02.getConnection(1);
        connectionPool02.getConnection(1);
        System.out.println("");
    }
}
