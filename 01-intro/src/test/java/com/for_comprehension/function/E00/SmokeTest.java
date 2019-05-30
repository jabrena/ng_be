package com.for_comprehension.function.E00;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmokeTest {
    @Test
    public void smoke_test() {
        assertThat(Runtime.getRuntime()).isNotNull();
    }
}
