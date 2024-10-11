package java_basics.tenth_topic.tenth_topic.completablefuture;
import org.testng.Assert;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // CompletionStage<T> is an interface of CompletableFuture<T>
        System.out.println("Tests of CompletableFuture:");
        // Test supplyAsync() and thenApply()
        CompletableFuture<String> future01 = CompletableFuture.supplyAsync(() -> "A Computer");
        CompletableFuture<String> future02 = future01.thenApply(res -> res + " Course");
        Assert.assertEquals("A Computer Course", future02.get());
        System.out.println("Test of future02: " + future02.get().toString());

        // Test thenAccept()
        CompletableFuture<Void> future03 = future02
                .thenAccept(s -> System.out.println("Test of future03: print future02: " + s));
        future03.get();

        // Test thenRun()
        CompletableFuture<Void> future04 = future02
                .thenRun(() -> System.out.println("Test of future04: just print this line."));
        future04.get();

        // Using CompletableFuture as a Simple Future
        CompletableFutureTest test05 = new CompletableFutureTest();
        Future<String> future05 = test05.calculateAsync();
        Assert.assertEquals("Hello", future05.get());
        System.out.println("Test of future05: " + future05.get().toString());

        // Test thenCompose()
        CompletableFuture future06 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World!"));
        Assert.assertEquals("Hello World!", future06.get());
        System.out.println("Test of future06: " + future06.get().toString());

        // Test thenAcceptBoth()
        CompletableFuture future07 = CompletableFuture.supplyAsync(() -> "ABCD")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> "EFGH"),
                        (s1, s2) -> System.out.println("Test of future07: " +s1+s2));
        future07.get();

        // Test multiple futures
        CompletableFuture<String> future08 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future09 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future10 = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture<Void> future11 = CompletableFuture.allOf(future08, future09, future10);
        future11.get();
        Assert.assertTrue(future08.isDone());
        Assert.assertTrue(future09.isDone());
        Assert.assertTrue(future10.isDone());

        // Test CompletableFuture.join()
        String future12 = Stream.of(future08, future09, future10)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        Assert.assertEquals("Hello Beautiful World", future12);
        System.out.println("Test of future12: " + future12);

        // Test handling Errors
        String name = null;
        CompletableFuture<String> future13 = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
        Assert.assertEquals("Hello, Stranger!", future13.get());
        System.out.println("Test of future13: " + future13.get().toString());
    }

    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });
        return completableFuture;
    }
}
