package com.gl.security;

public class Course {
	private int id;
	private String name;
	private double fee;
	private Category category;
    public Course() {
    	
    }
    public Course(String name,double fee,Category category) {
    	this.name = name;
    	this.fee = fee;
    	this.category= category;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	 

}
