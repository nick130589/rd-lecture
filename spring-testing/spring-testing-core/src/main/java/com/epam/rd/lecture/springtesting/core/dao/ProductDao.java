package com.epam.rd.lecture.springtesting.core.dao;

import com.epam.rd.lecture.springtesting.core.model.Product;

import java.util.List;

/**
 * Created by yarik on 9/15/16.
 */
public interface ProductDao {
    void persist(Product product);

    List<Product> findAll();
}
