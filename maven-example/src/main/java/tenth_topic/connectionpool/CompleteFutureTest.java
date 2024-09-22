package tenth_topic.connectionpool;

public class CompleteFutureTest {
    public static void main(String[] args) {
        System.out.println("Test01 of ConnectionPoolCompletableFuture.java:");
        ConnectionPoolCompletableFuture.getInstance();
        ConnectionPoolCompletableFuture completableFuture01 = new ConnectionPoolCompletableFuture();
        completableFuture01.getConnectionCompletionStage(1);
        completableFuture01.createNewConnection("jdbc:h2:mem:test00", "user00", "pwd00");
        completableFuture01.getConnectionCompletionStage(1);



    }
}
