package com.epam.rd.lecture.springtesting.web;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private BigDecimal cost;
}
