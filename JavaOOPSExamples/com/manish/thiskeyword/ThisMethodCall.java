package com.manish.thiskeyword;

public class ThisMethodCall {

	public void method1() {
		System.out.println("Inside Method 1");
	}

	public void method2() {
		System.out.println("\nInside Method 2");
		System.out.println("\nCall method1");
		method1();
		System.out.println("\nCall method1 using this keyword");
		this.method1();
	}

	public static void main(String args[]) {
		ThisMethodCall testObj = new ThisMethodCall();
		testObj.method1();
		testObj.method2();
	}
}
