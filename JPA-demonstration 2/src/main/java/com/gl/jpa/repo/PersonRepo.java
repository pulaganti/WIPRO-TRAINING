package com.gl.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.jpa.model.Person;

public interface PersonRepo extends JpaRepository<Person,Integer> {

}
