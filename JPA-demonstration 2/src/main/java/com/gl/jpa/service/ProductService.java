package com.gl.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.jpa.model.Product;
import com.gl.jpa.repo.ProductRepo;

@Service
public class ProductService {
   @Autowired
   ProductRepo productRepo;
   
   public Product add(Product product) {
       return productRepo.save(product);
   }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getById(int id) {
    	Optional<Product> productOpt = productRepo.findById(id);
    		if(productOpt.isEmpty()) {
    			
    			return null;
    		}
    		return productOpt.get();
    		
    	}
    public List<Product> getByPriceAbove(int price){
    	return productRepo.findByPriceGreaterThan(price);
    }
     
    

    
}
