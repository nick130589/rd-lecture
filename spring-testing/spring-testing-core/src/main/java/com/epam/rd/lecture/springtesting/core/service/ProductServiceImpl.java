package com.epam.rd.lecture.springtesting.core.service;

import com.epam.rd.lecture.springtesting.core.dao.ProductDao;
import com.epam.rd.lecture.springtesting.core.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Transactional
@Component
public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void add(Product product) {
		productDao.persist(product);
	}
	
	@Override
	public void addAll(Collection<Product> products) {
		for (Product product : products) {
			productDao.persist(product);
		}
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}
}
