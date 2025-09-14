package com.gl.jpa.model;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double fee;
	private int duration;
	@ManyToMany
	@JoinTable(name ="student_course",joinColumns = @JoinColumn(name = "course_id"),
	inverseJoinColumns = @JoinColumn(name="student_id"))
	@JsonIgnoreProperties("course")
	private Set<Student> student;
	
	public Course() {
		
	}
	public Course(String name, double fee, int duration) {
		this.name =name;
		this.fee = fee;
		this.duration = duration;
		
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
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}

}
