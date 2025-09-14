package com.gl.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.jpa.model.Product;
import com.gl.jpa.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/product/add")
    public ResponseEntity add(@RequestParam String name,int price) {
    	Product product = new Product(name,price);
		   productService.add(product); 
		return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    @GetMapping("/product/getbyid")
    public ResponseEntity getById(@RequestParam int id) {
    	try {
    		Product product = productService.getById(id);
    		if(product != null) {
    			return ResponseEntity.status(HttpStatus.OK).body(product);
    		}
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not  found");
    	}catch(Exception ex) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    	}
    }
    @GetMapping("/product/getbypriceabove")
    public List<Product> getByPriceAbove(@RequestParam int price){
    	return productService.getByPriceAbove(price);
    }
    
}

