package com.tek.demo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	private static final AtomicInteger counter = new AtomicInteger();
	@Autowired
	ProductRepository productrepository;
	
	private static List<Product> products;

	public List<Product> findAllProducts() {
		return productrepository.findAll();
	}

	/*public Product findById(int id) {

		return productrepository.findOne(id);

	}

	public void saveProduct(Product product) {
	
		productrepository.save(product);
	}

	public void updateProduct(Product product) {
		
		productrepository.save(product);
	}

	
	public void deleteProductById(int id) {

		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if (product.getId() == id) {
				iterator.remove();
			}
		}
	}
*/
}
