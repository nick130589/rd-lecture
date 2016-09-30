package com.epam.rd.lecture.springtesting.core.service;

import com.epam.rd.lecture.springtesting.core.dao.ProductDao;
import com.epam.rd.lecture.springtesting.core.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductServiceImpl SUT;


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldListAllProducts() throws Exception {
        //given
        List<Product> products = Arrays.asList(
                new Product(5, "Prod1", BigDecimal.ONE),
                new Product(5, "Prod1", BigDecimal.ONE));
        when(productDao.findAll()).thenReturn(products);

        //when
        List<Product> actual = SUT.findAll();

        //then
        assertThat(actual, is(products));
        verify(productDao).findAll();
    }
}