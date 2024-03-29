package com.for_comprehension.function.E06;

import com.for_comprehension.function.misc.User;
import com.for_comprehension.function.misc.UsersClient;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

class CompletableFutures {

    private static final ExecutorService executor = Executors.newFixedThreadPool(20);

    private static final UsersClient usersClient = new UsersClient();

    /**
     * Complete incoming {@link CompletableFuture} manually with value 42
     */
    static Consumer<CompletableFuture<Integer>> L1_manualCompletion() {
        return f -> {
            throw new NotImplementedException();
        };
    }

    /**
     * Complete incoming {@link CompletableFuture} exceptionally with a {@link NullPointerException}
     */
    static Consumer<CompletableFuture<Integer>> L2_manualExceptionCompletion() {
        return f -> {
            throw new NotImplementedException();

        };
    }

    /**
     * Run {@link com.for_comprehension.function.misc.UsersClient#getUserById(Integer)} asynchronously
     * Use the provided id to look up the user
     *
     *
     */
    static Function<Integer, CompletableFuture<User>> L3_runAsync() {
        return id -> {
            throw new NotImplementedException();
        };
    }

    /**
     * Run {@link com.for_comprehension.function.misc.UsersClient#getUserById(Integer)} asynchronously on a given thread pool
     * Use the provided id to look up the user
     *
     * Essentially, the same as above + execution on a provided thread pool
     */
    static BiFunction<Integer, ExecutorService, CompletableFuture<User>> L4_runAsyncOnACustomPool() {
        return (id, executor) -> {
            throw new NotImplementedException();
        };
    }

    /**
     * Run {@link com.for_comprehension.function.misc.UsersClient#getUserById(Integer)}
     * on two different ids and return both users in a List
     *
     * {@link CompletableFuture#thenCombine(CompletionStage, BiFunction)}
     *
     */
    static BiFunction<Integer, Integer, CompletableFuture<List<User>>> L5_runAsyncAndCombine() {
        return (id, id2) -> {
            throw new NotImplementedException();
        };
    }

    /**
     * Run {@link com.for_comprehension.function.misc.UsersClient#getUserById(Integer)}
     * on two different ids and return the one that returns first!
     *
     * {@link CompletableFuture#thenCombine(CompletionStage, BiFunction)}
     *
     */
    static Function<Integer, CompletableFuture<String>> L6_composeFutures() {
        return (id) -> {
            throw new NotImplementedException();
        };
    }

    /**
     * Given two futures, return the result of whichever completes first
     *
     * {@link CompletableFuture#anyOf(CompletableFuture[])}
     *
     */
    static <T> BiFunction<CompletableFuture<T>, CompletableFuture<T>, T> L7_returnValueOfTheFirstCompleted() {
        return (f1, f2) -> {
            throw new NotImplementedException();
        };
    }

}
