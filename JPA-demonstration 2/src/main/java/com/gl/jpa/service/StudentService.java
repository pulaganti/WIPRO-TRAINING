package com.gl.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Course;
import com.gl.jpa.model.Student;
import com.gl.jpa.repo.CourseRepo;
import com.gl.jpa.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	CourseRepo courseRepo;
	//insert
	public Student add(String name, int age) {
		Student student = new Student(name,age);
		return studentRepo.save(student);
	}
	//updating the course
	public Student assignCourse(int studentId, int courseId) {
		Optional<Student> studentOpt = studentRepo.findById(studentId);
		if(studentOpt.isEmpty()) {
			return null;
		}
		Optional<Course> courseOpt = courseRepo.findById(courseId);
		if(courseOpt.isEmpty()) {
			return null;
		}
		//actual mapping work - mapping the course for the student
		Student student = studentOpt.get();
		student.getCourse().add(courseOpt.get());
		//update the student
		studentRepo.save(student);
		return student;
	}
	public Student updateStudentName(int studentId, String newName) {
	    return studentRepo.findById(studentId)
	            .map(student -> {
	                student.setName(newName);   // overwrite, not append
	                return studentRepo.save(student);
	            })
	            .orElse(null);
	}

}
