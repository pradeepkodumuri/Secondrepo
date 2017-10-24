package com.tek.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tek.demo.basic.Supportclass;

public class DaoClass {
	@Autowired
	JdbcTemplate jdbctemplate;

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public List<Supportclass> getSupportclass() {
		System.out.println("Items in the table are diplayed");
		return jdbctemplate.query("select * from table", new RowMapper<Supportclass>() {

			public Supportclass mapRow(ResultSet rs, int row) throws SQLException {
				Supportclass supportclass = new Supportclass();
				supportclass.setId(rs.getInt(1));
				supportclass.setName(rs.getString(2));
				return supportclass;
			}

		});
	}

}
