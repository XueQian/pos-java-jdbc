package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ItemProcessorTest {

    @Test
    public void should_return_an_item_list() {

        ItemProcessor itemProcessor = new ItemProcessor();
        assertThat(itemProcessor.process().get(0).getName()).isEqualTo("可乐");
    }
}


