package com.gl.mango.webflux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo  extends ReactiveMongoRepository<Product,Integer>{

}
