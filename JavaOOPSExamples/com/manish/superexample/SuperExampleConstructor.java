package com.manish.superexample;

public class SuperExampleConstructor extends ParentClass2 {

	int speed = 100;

	SuperExampleConstructor(int speed) {
		super(speed);
	}

	public void display(){
		System.out.println("Print Speed of Parent : "+super.speed);
		System.out.println("Print Speed of Child : "+speed);
	}

	public static void main(String args[]) {
		SuperExampleConstructor se = new SuperExampleConstructor(90);
		se.display();
	}
}

class ParentClass2 {
	int speed = 50;

	ParentClass2(int speed) {
		System.out.println("Setting Speed in Parent Class");
		this.speed = speed;
	}
}
