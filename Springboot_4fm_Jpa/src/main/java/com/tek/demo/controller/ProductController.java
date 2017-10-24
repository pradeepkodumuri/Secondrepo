package com.tek.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tek.demo.model.Product;
import com.tek.demo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productservice;

	// Display list

	@RequestMapping(value = "/product/", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts() {
		List<Product> products = productservice.findAllProducts();
		if (products.isEmpty()) {

			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	// Single record retrieval

		@RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Product> getUser(@PathVariable("id") int id) {
			System.out.println("Fetching User with id " + id);
			Product product = productservice.findById(id);
			if (product == null) {
				System.out.println("User with id " + id + " not found");
				return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}

		// new record creation

		@RequestMapping(value = "/product", method = RequestMethod.POST)
		public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
			System.out.println("Creating User " + product.getName());
			productservice.saveProduct(product);
		
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(product.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}

		// Updating existed record

		@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Product> updateUser(@PathVariable("id") int id, @RequestBody Product product) {
			System.out.println("Updating User " + id);

			Product currentProduct = productservice.findById(id);
			currentProduct.setName(product.getName());
			currentProduct.setId(product.getId());
			currentProduct.setPrice(product.getPrice());

			productservice.saveProduct(currentProduct);
			return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
		}

		// Deleting a record

		@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Product> deleteUser(@PathVariable("id") int id) {
			System.out.println("Fetching & Deleting User with id " + id);

			Product product = productservice.findById(id);
			if (product == null) {
				System.out.println("Unable to delete. User with id " + id + " not found");
				return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			}
			int id1 = (int) id;
			productservice.deleteProductById(id1);
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}

	}
