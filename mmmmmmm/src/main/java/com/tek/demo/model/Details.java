package com.tek.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Details {

	@Id
	@Column
	int detailNo;
	@Column
	String description;

	public int getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(int detailNo) {
		this.detailNo = detailNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Details(int detailNo, String description) {
		super();
		this.detailNo = detailNo;
		this.description = description;
	}

	public Details() {
	}

}
