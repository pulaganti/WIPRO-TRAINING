package com.gl.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.jpa.model.Gender;

public interface GenderRepo extends JpaRepository<Gender,Integer>{

}
