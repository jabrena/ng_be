package com.for_comprehension.function.E05;

import com.for_comprehension.function.misc.NotImplementedException;
import io.vavr.collection.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class ParallelStreams {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        List<Integer> list =  IntStream.iterate(0, i -> i + 1).boxed()
                .limit(10)
                .collect(toList());

        //parallelSync(list, x -> httpClientCall(), executor);

        parallelAsync(list, x-> httpClientCall(), executor);

    }

    static <T, R> List<R> parallelSync(Collection<T> input, Function<T, R> task, ExecutorService executor) {

        return input.stream()
                .map(task)
                .collect(toList());
    }

    static <T, R> List<R> parallelAsync(Collection<T> input, Function<T, R> task, ExecutorService executor) {

        /*
        List<CompletableFuture> futures = input.stream()
                .map(inputElement -> {
                    CompletableFuture<Function<T, R>> functionCompletableFuture = CompletableFuture
                            .supplyAsync(() -> task.apply(inputElement), executor));

                    //.exceptionally()
                            //.completeOnTimeout(98, 5, TimeUnit.SECONDS);

                    functionCompletableFuture.get();
                })
                .map(CompletableFuture::join)
                .collect(toList());

        futures.stream()
                .map(CompletableFuture::join)
                //.peek(print)
                .collect(toList());
        */
        return null;
    }

    private static int httpClientCall() {
        System.out.println(Thread.currentThread().getName() + " computing...");
        try {
            Thread.sleep(1000 + (ThreadLocalRandom.current().nextInt(10) * 100));
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }

        return 42;
    }
}
