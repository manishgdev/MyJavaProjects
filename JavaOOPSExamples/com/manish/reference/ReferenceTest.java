package com.manish.reference;

public class ReferenceTest {
	public static void main(String args[]) {
		System.out.println("Relation - Cat extends Animal\n");
		System.out.println("Create Cat Object :- Cat c = new Cat()");
		Cat c = new Cat();
		System.out.println("Call c.showType()");
		c.showType();
		System.out.println("Call c.printName()");
		c.printName();
		System.out.println("Call c.showLegs()");
		c.showLegs();

		System.out.println("\nCat Object with Animal Reference :- Animal a = new Cat()");
		Animal a = new Cat();
		System.out.println("Call a.showType()");
		a.showType();
		System.out.println("Calling a.printName() will give error as :- error: cannot find symbol");
		//a.printName();
		System.out.println("Call a.showLegs()");
		a.showLegs();
	}
}

class Animal {
	public void showType() {
		System.out.println("I am Animal");
	}

	public void showLegs() {
		System.out.println("I have 4 legs");
	}

}

class Cat extends Animal{
	public void showType() {
		System.out.println("I am cat");
	}

	public void printName() {
		System.out.println("My Name is 'Meow Meow'");
	}
}
