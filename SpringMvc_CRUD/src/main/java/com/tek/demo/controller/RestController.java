package com.tek.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.tek.demo.pojo.Product;
import com.tek.demo.service.ProductService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	    @Autowired
	    ProductService productService;  //Service which will do all data retrieval/manipulation work
	 
	     
	    //------------------s-Retrieve All Users--------------------------------------------------------
	     
	    @RequestMapping(value = "/user/", method = RequestMethod.GET)
	    public ResponseEntity<List<Product>> listAllProducts() {
	        List<Product> products = productService.findAllProducts();
	        if(products.isEmpty()){
	            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	    }
	 
	 
	    //-------------------Retrieve Single User--------------------------------------------------------
	     
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Product> getUser(@PathVariable("id") long id) {
	        System.out.println("Fetching User with id " + id);
	        Product user = productService.findById(id);
	        if (user == null) {
	            System.out.println("Product with id " + id + " not found");
	            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Product>(user, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create a User--------------------------------------------------------
	     
	    @RequestMapping(value = "/user/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody Product product,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + product.getName());
	 
	        if (product.isProductExist(product)) {
	            System.out.println("A Product with name " + product.getName() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        product.saveProduct(product);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(product.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	     
	    //------------------- Update a User --------------------------------------------------------
	     
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Product> updateUser(@PathVariable("id") long id, @RequestBody Product product) {
	        System.out.println("Updating Product " + id);
	         
	        Product currentProduct = product.findById(id);
	         
	        if (currentProduct==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentProduct.setName(product.getName());
	        currentProduct.setId(product.getId());
	        currentProduct.setPrice(product.getPrice());
	         
	        product.updateProduct(currentProduct);
	        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
	    }
	 
	    //------------------- Delete a User --------------------------------------------------------
	     
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Product> deleteUser(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting User with id " + id);
	 
	        Product product = productService.findById(id);
	        if (product == null) {
	            System.out.println("Unable to delete. User with id " + id + " not found");
	            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	        }
	 
	        Product.deleteProductById(id);
	        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    //------------------- Delete All Users --------------------------------------------------------
	     
	    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	    public ResponseEntity<Product> deleteAllUsers() {
	        System.out.println("Deleting All Users");
	 
	        productService.findAllProducts();
	        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	    }
	 

}
