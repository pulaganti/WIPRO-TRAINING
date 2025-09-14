package com.gl.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.jpa.model.Author;

public interface AuthorRepo extends JpaRepository<Author,Integer> {

}
