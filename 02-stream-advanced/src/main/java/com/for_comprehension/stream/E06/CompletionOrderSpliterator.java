package com.for_comprehension.stream.E06;

import org.apache.commons.lang3.NotImplementedException;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static java.util.concurrent.CompletableFuture.anyOf;

final class CompletionOrderSpliterator<T> implements Spliterator<T> {

    CompletionOrderSpliterator(Collection<CompletableFuture<T>> futures) {
        throw new NotImplementedException("");
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        throw new NotImplementedException("");
    }

    private T nextCompleted() {
        throw new NotImplementedException("");

    }

    @Override
    public Spliterator<T> trySplit() {
        throw new NotImplementedException("");

    }

    @Override
    public long estimateSize() {
        throw new NotImplementedException("");

    }

    @Override
    public int characteristics() {
        return SIZED | IMMUTABLE | NONNULL;
    }
}
