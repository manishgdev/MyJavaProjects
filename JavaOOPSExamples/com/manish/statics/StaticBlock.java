package com.manish.statics;

public class StaticBlock {
	static {
		System.out.println("Getting Executed from Static Block");
	}

	public static void main(String args[]) {
		System.out.println("Getting Executed from Main Method");
		System.out.println("Observe for Static Block after new object creation of class");
		new StaticBlock(); // Static Block is executed only once before classloading
		// when new object of Class is created then the static block will not be called upon
		System.out.println("Check for presence of Static block output in previous statement before at time of Object creation");

	}
}
