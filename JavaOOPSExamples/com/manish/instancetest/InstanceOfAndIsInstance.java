package com.manish.instancetest;

import java.util.Scanner;
import java.io.IOException;

public class InstanceOfAndIsInstance {
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Thread t = new Thread();

		System.out.println("Created Object of Thread as :- Thread t = new Thread();");
		System.out.println("\nUse instanceof operator");

		System.out.println("t instanceof Runnable :- " + (t instanceof Runnable));

		Scanner sc = new Scanner(System.in);
		System.out.println("\nUsing isInstance() method");
		boolean runLoop = true;
		System.out.println("Enter 0 - to end test\nEnter class name to check with isInstance() method");
		while(runLoop) {
			String className = sc.nextLine();

			if(className.equals("0")) {
				System.out.println("Exiting from program");
				runLoop = false;
			}
			else {
				System.out.println("Class.forName(\""+className+"\").isInstance(t) :- "+ Class.forName(className).isInstance(t));
				System.out.println("\nEnter 0 - to end test\nEnter class name to check with isInstance() method");
			}
		}
	}
}
