package com.tek.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tek.demo.model.Product;

public interface ProductRepository  extends JpaRepository<Product,Integer>{

}
