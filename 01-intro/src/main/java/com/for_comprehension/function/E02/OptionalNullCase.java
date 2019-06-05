package com.for_comprehension.function.E02;

import com.for_comprehension.function.misc.User;

import java.util.Optional;
import java.util.stream.Stream;

class OptionalNullCase {

    // Optional vs Rest of the World
    public static void main(String[] args) {
        String r = findById(42)
          .map(u -> (String) null) // converted implicitly to Optional.empty
          .orElse("default");

        System.out.println(r);
    }

    private static Optional<User> findById(int id) {
        if (id == 42) return Optional.of(new User(42, "Felix"));
        return Optional.empty();
    }
}
