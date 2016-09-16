package com.epam.rd.lecture.springtesting.core.service;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JustTest {

    @Test
    public void WTF() throws Exception {
        assertTrue(false);
    }

    @Test
    public void returnTrueIfElementSuccefullyAdded() throws Exception {
        List<String> list = mock(List.class);
        when(list.add("x")).thenReturn(true);
        boolean actual = list.add("x");
        assertThat(actual, is(true));
    }
}