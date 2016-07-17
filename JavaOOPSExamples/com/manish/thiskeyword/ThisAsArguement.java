package com.manish.thiskeyword;

public class ThisAsArguement {

	int rollNo = 5;
	String name = "Rahul";

	public void method1(ThisAsArguement obj) {
		System.out.println("\nInside Method1");
		System.out.println("obj.rollNo = "+obj.rollNo+", obj.name = "+obj.name);
	}

	public void method2() {
		System.out.println("\nInside Method2");
		System.out.println("rollNo = "+rollNo+", name = "+name);
		method1(this);
	}

	public static void main(String args[]) {
		ThisAsArguement testObj = new ThisAsArguement();
		System.out.println("----Executing Method1");
		testObj.method1(testObj);
		// testObj.method1(this); =>  non-static variable this cannot be referenced from a static context
		System.out.println("----Executing Method2");
		testObj.method2();
	}
}
