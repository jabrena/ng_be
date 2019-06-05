package com.for_comprehension.stream.E02;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

class DynamicStreamFiltering {

    /**
     * Implement a function that takes a stream and filters it with a provided list of predicates
     */
    @SafeVarargs
    public static <T> UnaryOperator<Stream<T>> filterWith(Predicate<T>... predicates) {
        throw new NotImplementedException("");
    }
}