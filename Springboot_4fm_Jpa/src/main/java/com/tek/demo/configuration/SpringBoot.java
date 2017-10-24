package com.tek.demo.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.tek.demo")
@EnableJpaRepositories(basePackages="com.tek.demo")
public class SpringBoot {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot.class, args);

	}

}
