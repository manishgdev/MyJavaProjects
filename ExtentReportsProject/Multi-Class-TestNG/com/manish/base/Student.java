package com.manish.base;

public class Student {
	private String name;
	private int marks;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;	
	}
	
	public String getName() {
		return name;
	}
	
	public int getMarks() {
		return marks;
	}
	
	public String falseName() {
		return "Arjun";
	}
	
	public int fixMarks() {
		return 54;
	}
}
