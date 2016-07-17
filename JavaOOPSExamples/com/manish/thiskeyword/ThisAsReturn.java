package com.manish.thiskeyword;

public class ThisAsReturn {
	public ThisAsReturn getClassObj() {
		System.out.println("-->Returning Class Object using this keyword");
		return this;
	}

	public void printMessage() {
		System.out.println("This is accessible from object of ThisAsReturn class");
	}

	public static void main(String args[]) {
		System.out.println("Print Message without calling getClassObj");
		new ThisAsReturn().printMessage();

		System.out.println("\nPrint Message by calling getClassObj method");
		new ThisAsReturn().getClassObj().printMessage();
	}
}
