package com.manish.superexample;

public class SuperExampleExplicit extends Vehicle {
	int speed;

	SuperExampleExplicit(int speed) {
		this.speed = speed;
		System.out.println("Printing speed in Child class : " + speed);
	}

	public static void main(String args[]) {
		SuperExampleExplicit see = new SuperExampleExplicit(80);
	}
}

class Vehicle {
	Vehicle (){
		System.out.println("Default Constructor invoked explicitly");
	}
}
