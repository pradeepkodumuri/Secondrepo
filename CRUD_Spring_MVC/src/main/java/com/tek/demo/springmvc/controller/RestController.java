package com.tek.demo.springmvc.controller;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.tek.demo.springmvc.pojo.Product;
import com.tek.demo.springmvc.service.ProductService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	ProductService productService; // Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All
	// Users--------------------------------------------------------

	@RequestMapping(value = "/product/", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllUsers() {
		List<Product> products = productService.findAllUsers();
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);// You many decide to return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// User--------------------------------------------------------

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getUser(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		Product product = productService.findById(id);
		if (product == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	// -------------------Create a
	// User--------------------------------------------------------

	@RequestMapping(value = "/product/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + product.getName());

		if (productService.isUserExist(product)) {
			System.out.println("A User with name " + product.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		productService.saveUser(product);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(product.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User
	// --------------------------------------------------------

	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateUser(@PathVariable("id") long id, @RequestBody Product product) {
		System.out.println("Updating User " + id);

		Product currentProduct = productService.findById(id);

		if (currentProduct == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		currentProduct.setName(product.getName());
		currentProduct.setId(product.getId());
		currentProduct.setPrice(product.getPrice());

		productService.updateProduct(currentProduct);
		return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
	}

	// ------------------- Delete a User
	// --------------------------------------------------------

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteUser(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting User with id " + id);

		Product product = productService.findById(id);
		if (product == null) {
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		productService.deleteProductById(id);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users
	// --------------------------------------------------------

	@RequestMapping(value = "/product/", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteAllUsers() {
		System.out.println("Deleting All Users");

		productService.deleteAllUsers();
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}

}
