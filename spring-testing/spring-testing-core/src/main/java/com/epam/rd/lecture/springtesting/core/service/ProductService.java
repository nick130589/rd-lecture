package com.epam.rd.lecture.springtesting.core.service;

import com.epam.rd.lecture.springtesting.core.model.Product;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Transactional
public interface ProductService {
    void add(Product product);
    void addAll(Collection<Product> products);
    List<Product> findAll();
}
