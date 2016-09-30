package com.epam.rd.lecture.springtesting.core.dao;

import com.epam.rd.lecture.springtesting.core.model.Product;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Transactional
@ContextConfiguration(value = "classpath:core-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDaoImplTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ProductDao productDao;

    @Test
    public void shouldReturnAllProductsInDb() throws Exception {
        //given

        List<Product> pre = productDao.findAll();
        assertTrue(pre.isEmpty());
        Product prod1 = new Product(1, "Some prod", BigDecimal.ONE);
        em.persist(prod1);

        //when

        List<Product> actualProducts = productDao.findAll();

        //then

        assertThat(actualProducts, hasSize(1));
        assertThat(actualProducts, contains(prod1));
    }

    @After
    public void after() {
        em.flush();
    }

    @Test
    public void validatesProductLengthOnSave() {
        Product prod = new Product(1, "_______ longer than column length constraint _______", BigDecimal.ONE);
        em.persist(prod);
//
    }
}