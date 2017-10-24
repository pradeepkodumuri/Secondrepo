package com.tek.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable{

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "price")
	private String price;

	@Column(name = "name")
	private String name;

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(Integer id, String price, String name) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", name=" + name + "]";
	}
	
}
