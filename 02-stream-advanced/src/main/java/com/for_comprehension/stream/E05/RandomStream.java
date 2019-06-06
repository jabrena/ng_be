package com.for_comprehension.stream.E05;

import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Implement a custom spliterator that iterates through elements of the source collection... randomly
 */
class RandomStream<T, LIST extends RandomAccess & List<T>> // intersection types
  implements Spliterator<T> {

    private final Random random;
    private final LIST source;

    public static <T> Stream<T> randomStream(Collection<T> input) {
        return StreamSupport.stream(new RandomStream<>(new ArrayList<>(input), Random::new), false);
    }

    RandomStream(
      LIST source, Supplier<? extends Random> random) {
        Objects.requireNonNull(source, "source can't be null");
        Objects.requireNonNull(random, "random can't be null");

        this.source = source;
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