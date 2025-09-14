package com.gl.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.jpa.model.Course;
import com.gl.jpa.service.CourseService;

@RestController
public class CourseController {
	@Autowired 
	CourseService courseService;
	
	@PostMapping("/course/add")
	public ResponseEntity add(@RequestParam String name,@RequestParam double fee,@RequestParam int duration) {
		Course course =  courseService.add(name,fee,duration);
		if(course != null) {
			return ResponseEntity.status(HttpStatus.OK).body(course);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add the course");
	}

}
