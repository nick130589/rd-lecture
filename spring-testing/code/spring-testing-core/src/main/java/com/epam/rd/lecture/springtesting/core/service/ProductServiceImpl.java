package com.epam.rd.lecture.springtesting.core.service;

import com.epam.rd.lecture.springtesting.core.dao.ProductDao;
import com.epam.rd.lecture.springtesting.core.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
    @Transactional
	public void add(Product product) {
		productDao.persist(product);
	}
	
	@Override
    @Transactional
	public void addAll(Collection<Product> products) {
		for (Product product : products) {
			productDao.persist(product);
		}
	}

	@Override
    @Transactional
	public List<Product> listAll() {
		return productDao.findAll();
	}

}
