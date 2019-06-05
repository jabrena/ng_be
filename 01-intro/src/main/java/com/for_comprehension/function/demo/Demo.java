package com.for_comprehension.function.demo;

class Demo {
    public static void main(String[] args) {
        Runnable action = () -> System.out.println("Hello from another thread");

        Thread thread = new Thread(action);
        thread.start();



    }
}
