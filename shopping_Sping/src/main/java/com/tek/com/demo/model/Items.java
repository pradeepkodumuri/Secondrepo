package com.tek.com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Items {
	
	@Id	
private String name;

private String itemNo;
private String quantity;

public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getItemNo() {
	return itemNo;
}
public void setItemNo(String itemNo) {
	this.itemNo = itemNo;
}
public Items(String s,String string, int i, String string2) {
	this.itemNo=s;
	this.name=string;
	this.Description=string2;
	this.price=i;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
	this.price = price;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
private int price;
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
private String Description;


}
