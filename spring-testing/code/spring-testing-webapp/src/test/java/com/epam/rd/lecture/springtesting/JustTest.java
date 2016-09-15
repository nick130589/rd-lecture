package com.epam.rd.lecture.springtesting;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class JustTest {

    @Test
    public void WTF() throws Exception {
        assertTrue(false);
    }

    @Test
    public void testMe() throws Exception {
        List<String> l = mock(List.class);
        when(l.add("x")).thenReturn(true);
        boolean actual = l.add("x");
        assertThat(actual, is(true));
    }
}