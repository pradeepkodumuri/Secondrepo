package com.tek.demo.springmvc.pojo;

public class Product {
	public String name;
	public long id;
	public String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Product(String name, long id, String price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}

	public Product() {
	}
}
