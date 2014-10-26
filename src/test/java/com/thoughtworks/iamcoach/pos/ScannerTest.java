package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


public class ScannerTest {

    @Test
    public void should_return_a_cart_list() {

        Scanner cartItemProcessor = new Scanner();
        assertThat(cartItemProcessor.process().get(0).getCount()).isEqualTo(2);
        assertThat(cartItemProcessor.process().get(1).getCount()).isEqualTo(3);
    }
}
