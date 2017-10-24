package com.tek.demo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tek.demo.model.Product;

@Repository
public class ProductDao {
	@Autowired
	JdbcTemplate template;

	public void setTempalte(JdbcTemplate tempalte) {
		this.template = tempalte;
	}

	public int save(Product p) {
		String sql = "insert into product(id,price,name) values('" + p.getId() + "','" + p.getPrice() + "','"
				+ p.getName() + "')";
		return template.update(sql);
	}

	public int update(Product p) {
		String sql = "UPDATE product SET name=?,price=? WHERE id=?";
		template.update(sql, new Object[] { p.getPrice(), p.getName(), p.getId() });
		return template.update(sql, new Object[] { p.getName(), p.getPrice(), p.getId() });

	}

	public int delete(int id) {
		String sql = "delete from product where id=" + id + "";
		return template.update(sql);
	}

	public Product getProductById(int id1) {

		String sql = "select * from product where id=?";
		Product product = template.queryForObject(sql, new Object[] { id1 },
				new BeanPropertyRowMapper<Product>(Product.class));
		System.out.println(product);
		return product;
	}

	public List<Product> getProducts() {
		System.out.println("list of products are displayed");
		return template.query("select * from product", new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product pp = new Product();
				pp.setId(rs.getInt(1));
				pp.setPrice(rs.getString(2));
				pp.setName(rs.getString(3));
				return pp;
			}
		});
	}
}
