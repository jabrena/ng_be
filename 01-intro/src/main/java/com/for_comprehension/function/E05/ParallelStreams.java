package com.for_comprehension.function.E05;

import java.util.concurrent.ThreadLocalRandom;

class ParallelStreams {

    public static void main(String[] args) {
    }

    private static int httpClientCall() {
//        System.out.println(Thread.currentThread().getName() + " computing...");
        try {
            Thread.sleep(1000 + (ThreadLocalRandom.current().nextInt(10) * 100));
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }

        return 42;
    }
}
