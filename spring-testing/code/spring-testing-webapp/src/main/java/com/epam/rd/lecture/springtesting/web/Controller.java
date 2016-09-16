package com.epam.rd.lecture.springtesting.web;

import com.epam.rd.lecture.springtesting.core.model.Product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "product")
public class Controller {
    public static String getHello() {
        return "Hello";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return Collections.singletonList(new Product(1, "prod", BigDecimal.ONE));
    }

}
