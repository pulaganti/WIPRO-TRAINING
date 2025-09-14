package com.gl.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Category;
import com.gl.jpa.model.Item;
import com.gl.jpa.repo.ItemRepo;

@Service
public class ItemService {
	@Autowired
	ItemRepo itemRepo;
	@Autowired
	CategoryService categoryService;
	
	
	
	public Item add(String name, double price,int categoryId) {
		Category category = categoryService.findById(categoryId);
		if(category == null) {
			return null;
		}
	Item item = new Item(name,price,category);
		return itemRepo.save(item);
	}
	//get the list of items by the category id
	//List<Item> findByCategoryId(int categoryId);
	public List<Item> findByCategoryId(int categoryId){
		Category category = categoryService.findById(categoryId);
		if(category == null) {
			return null;
		}
		return itemRepo.findByCategoryId(categoryId);
	}
		

}
