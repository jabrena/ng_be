package com.for_comprehension.function.E02;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalRefactorTest {

    @Test
    public void findPersonTest() {

        OptionalsRefactor obj = new OptionalsRefactor();
        assertThat(obj.findPersonWrapper(1)).isInstanceOf(OptionalsRefactor.Person.class);
        assertThat(obj.findPersonWrapper(100)).isInstanceOf(OptionalsRefactor.Person.class);

    }

    @Test
    public void findAddressTest() {

        OptionalsRefactor obj = new OptionalsRefactor();
        assertThat(obj.findAddressWrapper(obj.getDefault())).isInstanceOf(String.class);

    }

    @Test
    public void findAddressByIdTest() {

        OptionalsRefactor obj = new OptionalsRefactor();
        assertThat(obj.findAddressByIdWrapper(1)).isInstanceOf(String.class);
        assertThat(obj.findAddressByIdWrapper(100)).isInstanceOf(String.class);

    }

}
