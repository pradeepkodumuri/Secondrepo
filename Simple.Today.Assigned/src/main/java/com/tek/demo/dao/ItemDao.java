package com.tek.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tek.demo.pojo.Items_pojo;

@Repository
public class ItemDao {
	@Autowired
	JdbcTemplate jdbctemplate;

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public List<Items_pojo> getitems() {
		System.out.println("list of products are displayed");
		return jdbctemplate.query("select * from itemtable", new RowMapper<Items_pojo>() {

			public Items_pojo mapRow(ResultSet rs, int row) throws SQLException {
				Items_pojo itemspp = new Items_pojo();
				itemspp.setId(rs.getInt(1));
				itemspp.setName(rs.getString(2));
				return itemspp;
			}
		});
	}

}
