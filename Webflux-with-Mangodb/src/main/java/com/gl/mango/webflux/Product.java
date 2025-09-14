package com.gl.mango.webflux;

public class Product {
	private int id;
	private String name;
	private double fee;
	public Product() {
		
	}
	public Product(String name,double fee) {
		this.name = name;
		this.fee = fee;
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
}
