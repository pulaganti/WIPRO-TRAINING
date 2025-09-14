package com.gl.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.jpa.model.Animal;

public interface AnimalRepo extends JpaRepository<Animal,Integer> {

}
