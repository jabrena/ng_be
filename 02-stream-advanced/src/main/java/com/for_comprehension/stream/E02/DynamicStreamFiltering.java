package com.for_comprehension.stream.E02;

import java.util.stream.Collector;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class DynamicStreamFiltering {

    /**
     * Implement a function that takes a stream and filters it with a provided list of predicates
     * So, if a source stream contains elements like [1,2,3,4,5]
     * and we filter it with predicates [i -> i < 3, i -> i > 4], we should end up with a stream containing only [3,4]
     */
    @SafeVarargs
    public static <T> UnaryOperator<Stream<T>> filterWith(Predicate<T>... predicates) {
        return data -> {
            Predicate<T> reduce = Stream.of(predicates).reduce(w -> true, Predicate::and);
            return data.filter(reduce);
        };
    }
}