package com.gl.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Category;
import com.gl.jpa.repo.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	CategoryRepo categoryRepo;

	public Category findById(int Id) {
		Optional<Category> categoryOpt = categoryRepo.findById(Id);
		if(categoryOpt.isEmpty()) {
			return null;
		}
		
		return categoryOpt.get();
	}
	


}
