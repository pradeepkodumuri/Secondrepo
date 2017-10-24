package com.tek.demo.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.tek.demo.springmvc.pojo.Product;

@Service

public class ProductService {
	private static final AtomicLong counter = new AtomicLong();

	private static List<Product> products;

	static {
		products = populateDummyUsers();
	}

	public List<Product> findAllUsers() {
		return products;
	}

	public Product findById(long id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	public Product findByName(String name) {
		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		return null;
	}

	public void saveUser(Product product) {
		product.setId(counter.incrementAndGet());
		products.add(product);
	}

	public void updateProduct(Product product) {
		int index = products.indexOf(product);
		products.set(index, product);
	}

	public void deleteProductById(long id) {

		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if (product.getId() == id) {
				iterator.remove();
			}
		}
	}

	public boolean isUserExist(Product product) {
		return findByName(product.getName()) != null;
	}

	private static List<Product> populateDummyUsers() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Dell", 1, "70000"));
		products.add(new Product("Hp", 2, "50000"));
		products.add(new Product("Apple", 3, "30000"));
		products.add(new Product("Samsung", 4, "40000"));
		return products;
	}

	public void deleteAllUsers() {
	}
}