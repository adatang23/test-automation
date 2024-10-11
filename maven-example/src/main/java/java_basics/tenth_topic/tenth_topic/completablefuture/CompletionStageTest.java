package java_basics.tenth_topic.tenth_topic.completablefuture;

import org.testng.Assert;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletionStageTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Tests of CompletionStage:");
        // Test supplyAsync() and thenApply()
        CompletableFuture<String> stage01 = CompletableFuture.supplyAsync(() -> "A Computer");
        CompletionStage<String> stage02 = stage01.thenApply(res -> res + " Course");
        Assert.assertEquals("A Computer Course", ((CompletableFuture<String>) stage02).get());
        System.out.println("Test of stage02: " + ((CompletableFuture<String>) stage02).get().toString());

        // Test thenAccept()
        CompletionStage<Void> stage03 = stage02
                .thenAccept(s -> System.out.println("Test of stage03: print stage02: " + s));

        // Test thenRun()
        CompletionStage<Void> stage04 = stage02
                .thenRun(() -> System.out.println("Test of stage04: just print this line."));

        // Test thenCompose()
        CompletionStage stage05 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World!"));
        Assert.assertEquals("Hello World!", ((CompletableFuture<String>) stage05).get().toString());
        System.out.println("Test of stage05: " + ((CompletableFuture<String>) stage05).get().toString());

        // Test thenAcceptBoth()
        CompletionStage stage06 = CompletableFuture.supplyAsync(() -> "ABCD")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> "EFGH"),
                        (s1, s2) -> System.out.println("Test of stage06: " +s1+s2));

        // Test multiple futures
        CompletableFuture<String> stage07 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> stage08 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> stage09 = CompletableFuture.supplyAsync(() -> "World");
        CompletionStage<Void> stage10 = CompletableFuture.allOf(stage07, stage08, stage09);
        Assert.assertTrue(stage07.isDone());
        Assert.assertTrue(stage08.isDone());
        Assert.assertTrue(stage09.isDone());

        String stage11 = Stream.of(stage07, stage08, stage09)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        Assert.assertEquals("Hello Beautiful World", stage11);
        System.out.println("Test of stage11: " + stage11);

        // Test handling Errors
        String name = null;
        CompletionStage<String> stage12 = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
        Assert.assertEquals("Hello, Stranger!", ((CompletableFuture<String>) stage12).get().toString());
        System.out.println("Test of stage12: " + ((CompletableFuture<String>) stage12).get().toString());
    }
}
