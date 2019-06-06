package com.for_comprehension.function.E03;

import com.for_comprehension.function.misc.NotImplementedException;

import io.vavr.Tuple2;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

class Streams {

    private static void L0_cubeComposer() {
        // https://david-peter.de/cube-composer/
    }

    /**
     * Uppercase all strings in a list
     * {@link Stream#map(Function)}
     */
    static Function<List<String>, List<String>> L1_upperCaseAll() {
        return input -> {
            return input.stream()
                    .map(String::toUpperCase)
                    .collect(toList());
        };
    }

    /**
     * Uppercase all list elements and discard names containing less than 6 characters
     * {@link Stream#filter(Predicate)}
     */
    static Function<List<String>, List<String>> L2_upperCaseAllAndFilter() {
        return input -> {
            return input.stream()
                    .filter(name -> name.length() > 6)
                    .map(String::toUpperCase)
                    .collect(toList());
        };
    }

    /**
     * Find the longest name
     * {@link Stream#max(Comparator)}
     * {@link Stream#sorted()} {@link Stream#findAny()}
     */
    static Function<List<String>, String> L3_findTheLongestName() {
        return input -> {
            return input.stream()
                    .sorted()
                    .findFirst().get();
        };
    }


    /**
     * Flatten a nested list structure
     * {@link Stream#flatMap(Function)}
     */
    static Function<List<List<Integer>>, List<Integer>> L4_flatten() {
        return input -> {
            return input.stream()
                    .flatMap(x -> x.stream())
                    .collect(toList());
        };
    }


    /**
     * Eliminate duplicates
     * {@link Stream#distinct()}
     */
    static Function<List<Integer>, List<Integer>> L5_distinctElements() {
        return input -> {
            return input.stream()
                    .distinct()
                    .collect(toList());
        };
    }

    /**
     * Duplicate the elements of a list
     */
    static Function<List<Integer>, List<Integer>> L6_duplicateElements() {
        return input -> {
            return input.stream()
                    .flatMap(u -> Stream.of(u,u))
                    .collect(toList());
        };
    }



    /**
     * Duplicate the elements of a list a given number of times
     * {@link Stream#generate(Supplier)}
     */
    static Function<List<Integer>, List<Integer>> L7_duplicateElementsNTimes(int givenNumberOfTimes) {
        return input -> {
            return input.stream()
                    .flatMap(integer -> Stream.generate((Supplier<Integer>) () -> integer)
                            .limit(givenNumberOfTimes))
                            .collect(toList());

        };
    }

    /**
     * Create a stream only with multiples of 3, starting from 0, size of 10
     * {@link Stream#iterate}
     */
    static Supplier<List<Integer>> L8_generate3s() {
        return () -> {
            return IntStream.iterate(0, i -> i + 1).boxed()
                    .filter(x -> x % 3 == 0)
                    .limit(10)
                    .collect(toList());

        };
    }

    /**
     * Find five consecutive leap years since 2000
     * {@link Stream#iterate(Object, UnaryOperator)}
     * {@link LocalDate#isLeapYear()}
     */
    static Supplier<List<Integer>> L9_leapYears() {
        return () -> {
            return IntStream.iterate(2000, i -> i + 1).boxed()
                    .filter(x -> {
                        LocalDate d = LocalDate.of(x, 1, 1);
                        return d.isLeapYear();
                    })
                    .limit(5)
                    .collect(toList());
        };
    }


    /**
     * Rotate a list N places to the left
     * {@link Stream#concat(Stream, Stream)}
     * {@link Stream#skip(long)}
     * {@link Stream#limit(long)}
     */
    static UnaryOperator<List<Integer>> L10_rotate(int n) {

        return input -> {
            return Stream.generate(() -> input)
                    .flatMap(i -> i.stream())
                    .skip(n % input.size())
                    .limit(input.size())
                    .collect(toList());
        };

        /*
        return input -> {

            return Stream.concat(input.stream(), input.stream())
                    .skip(n % input.size())
                    .limit(4)
                    .collect(toList());

        };
        */
    }


    /**
     * Check if all elements sum up to 100, if no throw an exception
     */
    static Predicate<List<Double>> L11_sum() throws IllegalStateException {
        return input -> {
            return input.stream()
                    .mapToDouble(f -> f.doubleValue())
                    .sum() == 100;
        };
    }

    /**
     * Convert a {@link List} of {@link Optional} to a {@link List} of only not-empty values
     *
     * Advanced challenge: use {@link Stream#flatMap(Function)}
     */
    static Function<List<Optional<Integer>>, List<Integer>> L12_filterPresent() {
        return list -> {
            return list.stream()
                    .filter(item -> item.isPresent())
                    .map(x -> x.get())
                    .collect(toList());
        };
    }
}
