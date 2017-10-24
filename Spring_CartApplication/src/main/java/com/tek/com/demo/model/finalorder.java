package com.tek.com.demo.model;

import java.util.List;

public class finalorder {

	private List<Items> item;

	public finalorder() {
	}

	public finalorder(List<Items> map, String user) {

		this.item = map;
		this.UserOredred = user;
	}

	public List<Items> getItem() {
		return item;
	}

	public void setItem(List<Items> item) {
		this.item = item;
	}

	private int orderId;
	private String UserOredred;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserOredred() {
		return UserOredred;
	}

	public void setUserOredred(String userOredred) {
		UserOredred = userOredred;
	}

}
