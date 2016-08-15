package com.manish.instancetest;

class Animal {
	public void printType() {
		System.out.println("My Type is Animal");
	}
}

class Dog extends Animal {
	public void printType() {
		System.out.println("My Type is Dog");
	}
}

public class UpDown {
	public static void main(String args[]) {
		Animal a = new Dog();
		System.out.println("\nRelation :- \nDog :- Child Class\nAnimal :- Parent Class\n");
		System.out.println("Before Downcasting ");
		a.printType();
		if(a instanceof Dog) {
			System.out.println("Downcasting can be performed for Animal a = new Dog()");
			a = (Dog)a;
		}
		else {
			System.out.println("Downcasting cannot be performed");
		}

		System.out.println("\na instanceof animal = "+(a instanceof Animal)+"\n");

		System.out.println("After Downcasting");
		a.printType();

		System.out.println();
		Dog d = new Dog();
		System.out.println("\nDog d = new Dog(); d instance of Animal = "+(d instanceof Animal)+"\n");
		System.out.println("Before Upcasting");
		d.printType();
		System.out.println("Perform UpCasting for child to parent Dog d = new Dog()");
		Animal e = (Animal)d;
		System.out.println("After Upcasting  Animal e = (Animal)d");
		e.printType();

		Animal c = new Animal();
		
		System.out.println("Perform Downcasting from Parent to Child Animal c = new Animal()");
		System.out.println("Before Downcasting");
		c.printType();
		if(c instanceof Dog) {
			System.out.println("Downcasting can be performed");
			c = (Dog)c;
		}
		else {
			System.out.println("Downcasting cannot be performed");
		}
		System.out.println("After Downcasting");
		c.printType();
	}
}
