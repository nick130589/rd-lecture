package com.epam.rd.lecture.springtesting.core.main;

import com.epam.rd.lecture.springtesting.core.model.Product;
import com.epam.rd.lecture.springtesting.core.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);


	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/core-context.xml");
		
		ProductService productService = ctx.getBean(ProductService.class);
		

		productService.add(new Product(1, "Bulb", BigDecimal.ONE));
		productService.add(new Product(2, "Dijone mustard", BigDecimal.ONE));

		log.info("findAll before: {}", productService.findAll());


		try {
			productService.addAll(Arrays.asList(
					new Product(3, "Book", BigDecimal.ONE),
					new Product(4, "Soap", BigDecimal.ONE),
					new Product(1, "Computer", BigDecimal.ONE)));
		} catch (DataAccessException ex) {
			log.error("error: ", ex);
		}

		log.info("findAll after: {}", productService.findAll());
		
		ctx.close();
		
	}
}
