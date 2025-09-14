package com.gl.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.jpa.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
	
	List<Product>findByPriceGreaterThan(int price);

}
