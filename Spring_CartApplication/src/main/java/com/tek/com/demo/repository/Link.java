
package com.tek.com.demo.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.tek.com.demo.model.finalorder;

//import com.tek.com.demo.model.finalorder;

@Component
public class Link {
	@Autowired
	private DataSource datasource;
	@Autowired
	private JdbcTemplate jdbctemplate;
	private int idCount = 0;

	public DataSource getDs() {
		return datasource;
	}

	public void setDs(DataSource datasource) {
		this.datasource = datasource;
		System.out.println("this set");
	}

	public int save(finalorder r) {
		String sql = "INSERT INTO mobile " + "(Id,userName) VALUES (?, ?)";
		r.setOrderId(idCount + 1);
		jdbctemplate.update(sql, new Object[] { r.getOrderId(), r.getUserOredred() });
		idCount++;
		return idCount;
	}
}
