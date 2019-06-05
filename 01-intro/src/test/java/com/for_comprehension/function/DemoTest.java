package com.for_comprehension.function;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class DemoTest {

    @Test
    public void example_1() throws Exception {
        Function<Integer, Integer> timesTwo = integer -> integer * 2;

        System.out.println(timesTwo.apply(2));
        System.out.println(timesTwo.apply(10));
    }

    @Test
    public void example_2() throws Exception {
        Consumer<Integer> integerPrinter = integer -> System.out.println(integer); // Function<Integer, Void>
        Consumer<Integer> integerPrinterRef = System.out::println; // Function<Integer, Void>

        integerPrinter.accept(42);
    }

    @Test
    public void example_3() throws Exception {
        Supplier<Integer> intSupplier = () -> 42; // Function<Void, Integer>

        System.out.println(intSupplier.get());
    }

    @Test
    public void example_4() throws Exception {
        Predicate<Integer> div10 = integer -> integer % 10 == 0; // Function<Integer, Boolean>

        System.out.println(div10.test(10000));
    }

    @Test
    public void example_5() throws Exception {
        Runnable runnable = () -> {
            System.out.println(42);
        }; // Function<Void, Void>

        Callable<Integer> callable = () -> 42;
    }

    @Test
    public void example_6() throws Exception {
         BinaryOperator<Integer> adder = Integer::sum;
         BinaryOperator<Integer> biggerOne = (i1, i2) -> {
             if (i1 > i2) {
                 return i1;
             } else {
                 return i2;
             }
         };
    }

    @Test
    public void example_7() throws Exception {
        UnaryOperator<Integer> seq = i -> i + 1; // Function<Integer, Integer>
    }











}
