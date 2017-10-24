package com.tek.com.demo.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tek.com.demo.model.Endproduct;

public class Connection {
	@Autowired 
	private DataSource datasource;
	private JdbcTemplate jdbctemplate;
	List<Endproduct> fo = new ArrayList();

	public void save(Endproduct r) {
		fo.add(r);
	}

}
