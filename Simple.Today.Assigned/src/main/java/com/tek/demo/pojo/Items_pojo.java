package com.tek.demo.pojo;

public class Items_pojo {
	int id;
	String name;

	public void setId(int id) {
		this.id = id;
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
		return "Items_pojo [id=" + id + ", name=" + name + "]";
	}

}
