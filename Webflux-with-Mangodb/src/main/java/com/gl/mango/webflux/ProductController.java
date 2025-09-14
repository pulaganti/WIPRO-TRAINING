package com.gl.mango.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class ProductController {
	@Autowired
	ProductRepo productRepo;
	
	@PostMapping("/product/add")
	public Mono<Product> addProduct(@RequestParam String name,@RequestParam double fee) {
		Product product = new Product(name, fee);
		return productRepo.save(product);
		}

}
