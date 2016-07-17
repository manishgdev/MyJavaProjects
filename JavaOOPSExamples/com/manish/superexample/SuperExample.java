package com.manish.superexample;

public class SuperExample extends ParentClass {

	int speed = 100;

	/*
	SuperExample(int speed) {
		super(speed);
	}
	*/
	public void display(){
		System.out.println("Print Speed of Parent : "+	super.speed);
		System.out.println("Print Speed of Child : "+speed);
	}

	public static void main(String args[]) {
		SuperExample se = new SuperExample();
		se.display();
	}
}

class ParentClass {
	int speed = 50;

	ParentClass() { // call to this is added automatically by the compiler
		System.out.println("Default constructor of Parent Called");
	}

	ParentClass(int speed) {
		System.out.println("Setting Speed in Parent Class");
		this.speed = speed;
	}
}
