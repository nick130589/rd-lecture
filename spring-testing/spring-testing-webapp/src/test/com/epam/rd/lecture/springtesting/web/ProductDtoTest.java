package com.epam.rd.lecture.springtesting.web;

import org.assertj.core.api.Assertions;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class ProductDtoTest {

    private static class ProductMatcher extends TypeSafeMatcher<ProductDto> {
        private final ProductDto expected;

        private ProductMatcher(ProductDto expected) {
            this.expected = expected;
        }

        @Override
        protected boolean matchesSafely(ProductDto actual) {
            return expected.getName().equals(actual.getName());
        }

        @Override
        public void describeTo(Description description) {
        }
    }

    @Test
    public void test() {
        ProductDto expected = new ProductDto(1, "1", BigDecimal.ONE);
        ProductDto actual = new ProductDto(1, "2", BigDecimal.ONE);

        //hamcrest custom
        Assert.assertThat(actual, isSameProduct(expected));
        //AssertJ built-in
        Assertions.assertThat(actual).isEqualToComparingFieldByField(expected);
    }


    private static ProductMatcher isSameProduct(ProductDto given) {
        return new ProductMatcher(given);
    }
}