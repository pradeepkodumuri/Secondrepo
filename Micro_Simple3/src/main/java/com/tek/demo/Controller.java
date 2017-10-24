package com.tek.demo;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class Controller {

	@RequestMapping(value = "/pro/")
	public List<Product> listAllProducts() {
		
	return (List<Product>) (new RestTemplate().getForObject("http://product-web-microservice/product/", Product.class));
		
	}

}
