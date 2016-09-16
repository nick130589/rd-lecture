package com.epam.rd.lecture.springtesting.core.service;

import com.epam.rd.lecture.springtesting.core.model.Product;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    @Transactional
    void add(Product product);

    @Transactional
    void addAll(Collection<Product> products);

    @Transactional
    List<Product> listAll();
}
