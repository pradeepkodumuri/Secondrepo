package com.tek.demo.model;

public class Product {
	private int id;
	private String price;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName(String name) {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", name=" + name + "]";
	}

	public Product(int id, String name, String price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}

	public Product() {

	}
}
