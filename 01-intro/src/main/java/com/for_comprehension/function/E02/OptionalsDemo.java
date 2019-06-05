package com.for_comprehension.function.E02;

import com.for_comprehension.function.misc.User;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;

class OptionalsDemo {

    public static void main(String[] args) {

        String result = findById(23)
          .map(User::getName)
          .map(String::toUpperCase)
          .orElse("default");

        String result2 = findById(43)
          .map(User::getName)
          .map(String::toUpperCase)
          .orElseGet(() -> getDefaultUserName());

        /*String addressLowercase = findById(42)
          .flatMap(user -> findAddress(user.getId()))
          .filter(adr -> adr.length() < 3)
          .map(address -> address.toLowerCase())
          .orElseThrow(() -> new IllegalStateException("something went wrong"));
*/
        System.out.println(result2);



        // AVOID THIS
        String adr;
        Optional<User> userById = findById(23);
        if (userById.isPresent()) {
            User user = userById.get();
            if (user != null) {
                String name = user.getName();
                if (name != null) {
                    adr = name.toLowerCase();
                }
                adr = "default";
            }
            adr = "default";
        }
        adr = "default";

        // IDIOMATIC
        findById(23)
          .map(User::getName)
          .map(s -> s.toUpperCase())
          .ifPresent(System.out::println);  // IDIOMATIC



        findById(23)
          .flatMap(u -> findAddress(u.getId()));
    }


    private static Optional<User> findById(int id) {
        if (id == 42) return Optional.of(new User(42, "Felix"));
        return Optional.empty();
    }

    private static Optional<String> findAddress(int id) {
        return Optional.of("foo");
    }

    private static String getDefaultUserName() {
        try {
            System.out.println("calculating...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        return "Vivek";
    }
}
