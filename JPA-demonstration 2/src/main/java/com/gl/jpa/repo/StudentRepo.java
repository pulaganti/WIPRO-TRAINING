package com.gl.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.jpa.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{

}
