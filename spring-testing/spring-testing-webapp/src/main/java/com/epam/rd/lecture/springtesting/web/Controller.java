package com.epam.rd.lecture.springtesting.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "product")
public class Controller {
    public static String getHello() {
        return "Hello";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDto> getAllProducts() {
        List<ProductDto> products = new ArrayList<>();
        products.add(new ProductDto(1, "prod", BigDecimal.ONE));
        return products;
    }

}