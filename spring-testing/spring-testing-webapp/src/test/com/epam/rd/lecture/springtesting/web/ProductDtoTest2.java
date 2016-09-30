package com.epam.rd.lecture.springtesting.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(DataProviderRunner.class)
public class ProductDtoTest2 {

    @Spy private ObjectMapper oj;

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                { 1,    1,  2},
                { 1,    -1,     0},
                { 2,    2,      4},
                { 1,    1,      5},
        };
    }


    @UseDataProvider("data")
    @Test
    public void testName(int i1, int i2, int expectedResult) throws Exception {
        //given

        //when
        int actual = i1 + i2;
        //then
        assertThat(actual, is(expectedResult));

    }
}