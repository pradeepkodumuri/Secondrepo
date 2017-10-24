package com.tek.com.demo.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.tek.com.demo.model.finalorder;

@Component
public class LinkedClass {
	@Autowired
	private DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private int idCount = 0;

	public DataSource getDs() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
		System.out.println("this set");
	}

	public int save(finalorder r) {
		String sql = "INSERT INTO shop " + "(OrderId,UserName) VALUES (?, ?)";
		r.setOrderId(idCount + 1);
		jdbcTemplate.update(sql, new Object[] { r.getOrderId(), r.getUserOredred() });
		idCount++;
		return idCount;
	}
}
