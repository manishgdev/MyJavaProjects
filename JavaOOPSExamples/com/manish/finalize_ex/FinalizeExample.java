package com.manish.finalize_ex;

public class FinalizeExample {
	public static void main(String args[]) {
		System.out.println("Inside normal execution of the program");
		FinalizeExample fe = new FinalizeExample();
		fe.display();

		Test t = new Test();
		t.display();

		t = null;
		fe = null;

		System.out.println("\nGoing to start Garbage Collection");
		Runtime.getRuntime().gc();
		System.gc();
	}

	public void display() {
		System.out.println("Displaying Message from object of Class");
	}

	protected void finalize() throws Throwable {
		System.out.println("Inside Finalize method .. called by System.gc()");
		super.finalize();
	}
}

class Test {

	public void display() {
		System.out.println("Displaying Message from object of Test Class");
	}

	protected void finalize() throws Throwable {
		System.out.println("Inside Finalize method of Test Class .. called by System.gc()");
		super.finalize();
	}
}
