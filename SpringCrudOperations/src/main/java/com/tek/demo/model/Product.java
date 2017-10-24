package com.tek.demo.model;

public class Product {
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	private Long id;
	private String price;
	public Product(Long id,String name, String price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}
     public Product()
     {
    	 
     }
}
