package com.for_comprehension.stream.E05;

import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Supplier;

class RandomStream<T, LIST extends RandomAccess & List<T>> // intersection types
  implements Spliterator<T> {

    private final Random random;
    private final List<T> source;

    RandomStream(
      LIST source, Supplier<? extends Random> random) {
        Objects.requireNonNull(source, "source can't be null");
        Objects.requireNonNull(random, "random can't be null");

        this.source = new ArrayList<>(source);
        this.random = random.get();
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
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
        throw new NotImplementedException("");

    }
}