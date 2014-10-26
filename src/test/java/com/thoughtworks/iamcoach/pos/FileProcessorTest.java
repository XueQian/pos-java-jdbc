package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class FileProcessorTest {

    @Test
    public void should_get_a_list() {

        FileProcessor fileProcessor = mock(FileProcessor.class);

        String fileName = "items.txt";
        assertThat(fileProcessor.readFile(fileName).get(0)).isEqualTo("ITEM000001,可乐,11,瓶");
    }

    @Test(expected = NullPointerException.class)
    public void should_throws_exception()throws NullPointerException{
        FileProcessor.readFile("i");
    }

}
