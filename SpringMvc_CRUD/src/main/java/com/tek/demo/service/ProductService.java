package com.tek.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.tek.demo.pojo.Product;

public class ProductService {
	 private static final AtomicLong counter = new AtomicLong();
     
	    private static List<Product> products;
	     
	    static{
	        products= populateDummyUsers();
	    }
	 
	    public List<Product> findAllProducts() {
	        return  products;
	    }
	     
	    public Product findById(long id) {
	        for(Product product : products){
	            if(((Product) products).getId() == id){
	                return product;
	            }
	        }
	        return null;
	    }
	     
	    public Product findByName(String name) {
	        for(Product product :  products){
	            if(product.getName().equalsIgnoreCase(name)){
	                return product;
	            }
	        }
	        return null;
	    }
	     
	    public void saveProduct(Product product) {
	    	product.setId(counter.incrementAndGet());
	    	product.add(product);
	    }
	 
	    public void updateProduct(Product product) {
	        int index = products.indexOf(product);
	        products.set(index, product);
	    }
	 
	    public void deleteUserById(long id) {
	         
	        for (Iterator<Product> iterator = products.iterator(); iterator.hasNext(); ) {
	        	Product product = iterator.next();
	            if (product.getId() == id) {
	                iterator.remove();
	            }
	        }
	    }
	 
	    public boolean isProductExist(Product product) {
	        return findByName(product.getName())!=null;
	    }
	 
	    private static List<Product> populateDummyUsers(){
	        List<Product> product = new ArrayList<Product>();
	        product.add(new Product("Dell",30, "70000"));
	        product.add(new Product("Lenovo",40, "50000"));
	        product.add(new Product("Hp",45, "30000"));
	        product.add(new Product("Apple",50, "40000"));
	        return products;
	    }
	 
	    public void deleteAllUsers() {
	        products.clear();
	    }

}
