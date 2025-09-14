package com.gl.jpa.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	@ManyToMany
	@JoinTable(name ="student_course",joinColumns = @JoinColumn(name = "student_id"),
	inverseJoinColumns = @JoinColumn(name="course_id"))
	private Set<Course> course;
	@JsonIgnoreProperties("students")
	public Student() {
		
	}
	public Student(String name, int age ) {
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Set<Course> getCourse() {
		return course;
	}
	public void setCourse(Set<Course> course) {
		this.course = course;
	}

}
