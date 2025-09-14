package com.gl.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.jpa.model.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {
	//get list of items by categoryid
	List<Item> findByCategoryId(int CategoryId);
	//get the list of items byt the category id and more than given price
    List<Item>findByCategoryIdAndPriceGreaterThan(int categoryId,double price);  
    //greater the an equals to given price
    List<Item> findByPriceGreaterThanEqual(double price);
    //filter by categoryid and arrenge by name[a-z]
     List<Item> findByCategoryIdOrderByName(int categoryId);
     //filterby category id and arrange by price id descending order
     List<Item> findByCategoryIdOrderByPriceDesc(int categoryId);
     //name must match and also case senstive
     List<Item> findByName(String name);
     //name must match and also case insenstive
     List<Item> findByNameIgnoreCase(String name);
     //select *from item where name like'%app%'
     List<Item> findByNameContaining(String name);
     List<Item> findByNameStartingWith(String name);
     List<Item> findByNameStartingWithIgnoreCase(String name);
     List<Item> findByNameEndingWith(String name);
}
