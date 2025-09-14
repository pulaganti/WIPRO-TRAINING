package com.gl.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.jpa.model.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
