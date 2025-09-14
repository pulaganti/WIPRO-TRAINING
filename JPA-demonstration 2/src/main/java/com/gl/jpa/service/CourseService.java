package com.gl.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Course;
import com.gl.jpa.repo.CourseRepo;

@Service
public class CourseService {
	@Autowired
	CourseRepo courseRepo;
	//add
	public Course add(String name, double fee, int duration) {
		Course course = new Course(name,fee,duration);
		return courseRepo.save(course);
	}

}
