package com.gl.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.jpa.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
