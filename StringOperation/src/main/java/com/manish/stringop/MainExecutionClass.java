package com.manish.stringop;

public class MainExecutionClass {

	public static void main(String args[]) throws CloneNotSupportedException {
		characterCountTest();
		constructorTest();
	}

	public static void constructorTest() throws CloneNotSupportedException{
		System.out.println("\n==========Execute Clone method of Object===================");
		System.out.println("Work with Parameterized Constructor");
		ConstructorTest c1 = new ConstructorTest(5,"Rahul");
                System.out.println("Printing Record for c1");
		c1.printRecord();
		ConstructorTest c2 = new ConstructorTest(c1); // Object Copy Using Constructor 
		System.out.println("Printing Record for c2");
		c2.printRecord();
		ConstructorTest c3 = new ConstructorTest(); // Object Copy without using Constructor
		c3.rollNo = c1.rollNo;
		c3.name = c1.name;
		System.out.println("Printing Record for c3");
		c3.printRecord();
		ConstructorTest c4 = (ConstructorTest)c1.clone(); // the calling method should throw CloneNotSupportedException Exception
		System.out.println("Printing Record for c4");
                c3.printRecord();
                System.out.println("===================================================");
	}

	public static void characterCountTest() {
		System.out.println("\n==========Execute Character Count In String Class ===============");
                new CharCountInStringApp();  //Anonymous Object
                System.out.println("==========================================\n");
	}
}

