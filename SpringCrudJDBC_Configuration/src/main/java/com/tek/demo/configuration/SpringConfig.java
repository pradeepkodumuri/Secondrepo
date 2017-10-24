package com.tek.demo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.tek.demo.Dao.ProductDao;

@EnableWebMvc
@Configuration
@ComponentScan("com.tek.demo")
public class SpringConfig extends WebMvcConfigurerAdapter {

	/*
	 * @Bean public InternalResourceViewResolver viewResolver() {
	 * InternalResourceViewResolver viewResolver = new
	 * InternalResourceViewResolver(); viewResolver.setViewClass(JstlView.class);
	 * viewResolver.setPrefix("/WEB-INF/"); viewResolver.setSuffix(".jsp"); return
	 * viewResolver; }
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/config");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer c) {
		c.enable();
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	/*
	 * @Bean public ProductDao employeeDAO(){ EmployeeDAOImpl empDao = new
	 * EmployeeDAOImpl(); empDao.setJdbcTemplate(jdbcTemplate()); return empDao; }
	 */
}