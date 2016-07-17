package com.manish.thiskeyword;

public class ThisConstructor {

	int rollNo;
	String name;
	String collegeName;

	public ThisConstructor() {
		System.out.println("\nDefault Contructor is invoked");
	}

	public ThisConstructor(int rollNo, String name) {
		this(); // Call to this() must be the first statement
		System.out.println("Constructor with two parameters invoked");
		this.rollNo = rollNo;
		this.name = name;
	}

	public ThisConstructor(int rollNo, String name, String collegeName) {
		this(rollNo, name);
		System.out.println("Inside Contructor with Three parameters");
		this.collegeName = collegeName;
	}

	public void showData() {
		System.out.println("Roll No = "+rollNo+", Name = "+name+", College = "+collegeName);
	}

	public static void main(String args[]) {
		ThisConstructor testObj = new ThisConstructor(5,"Sagar","ABC");
		System.out.println("Printing Data for Sagar");
		testObj.showData();
		testObj = new ThisConstructor(45,"Sharad");
		System.out.println("Printing Data for Sharad");
		testObj.showData();
	}
}
