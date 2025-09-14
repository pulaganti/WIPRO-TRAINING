package com.gl.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.jpa.model.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
