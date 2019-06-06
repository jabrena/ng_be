package com.for_comprehension.function;

public class Demo {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World Thread");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }

}
