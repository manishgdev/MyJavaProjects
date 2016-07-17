package com.manish.superexample;

public class SuperMethodCall extends ParentClass3 {
	public void message() {
		System.out.println("Printing message from Child Class");
	}

	public void display() {
		System.out.println("Call message() in child");
		message();
		System.out.println("Call message() in parent using super");
		super.message();
	}

	public static void main(String args[]) {
		SuperMethodCall smp = new SuperMethodCall();

		smp.display();
	}
}

class ParentClass3 {
	public void message() {
		System.out.println("Printing message from Parent Class");
	}
}
