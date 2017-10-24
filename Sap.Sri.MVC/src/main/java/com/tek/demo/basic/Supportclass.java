package com.tek.demo.basic;

public class Supportclass {

	int id;
	String name;
	
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Supportclass [id=" + id + ", name=" + name + "]";
	}
	

}


