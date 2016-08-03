package com.manish.beans;

public class Animal {
	private String name;
	private int legs;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumLegs(int legs) {
		this.legs = legs;	
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumLegs() {
		return legs;
	}
	
	public String falseName() {
		return "Hello";
	}
	
	public int fixLegs() {
		return 2;
	}
}
