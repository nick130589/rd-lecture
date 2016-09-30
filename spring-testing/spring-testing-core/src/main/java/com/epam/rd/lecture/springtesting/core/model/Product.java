package com.epam.rd.lecture.springtesting.core.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private Integer id;
	@Column(length = 20)
	private String name;
	private BigDecimal cost;

	public Product() {
	}

	public Product(Integer id, String name, BigDecimal cost) {
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(id, product.id) &&
				Objects.equals(name, product.name) &&
				Objects.equals(cost, product.cost);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, cost);
	}
}
