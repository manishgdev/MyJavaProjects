package com.manish.constructors;

class PrivateCons2 {
	static PrivateCons2 privateObj;
	private PrivateCons2() {
	}

	public void printTest() {
		System.out.println("Printing inside the Class whose constructor is private and instance is returned from public method");
	}

	public static PrivateCons2 getPrivateObj() {
		if(privateObj == null)
			privateObj = new PrivateCons2();
		return privateObj;
	}
}

public class PrivateConstructors {

	private PrivateConstructors() {
		System.out.println("Private constructor called from within the class");
	}
	public static void main(String args[]) {
		PrivateConstructors pc = new PrivateConstructors();
		// PrivateCons2 pc2 = new PrivateCons2();
		System.out.println("\nPrivateCons2 pc2 = new PrivateCons2(); will give below error\nPrivateCons2() has private access in PrivateCons2\n");
		PrivateCons2 pc2 = PrivateCons2.getPrivateObj();
		pc2.printTest();
	}
}
