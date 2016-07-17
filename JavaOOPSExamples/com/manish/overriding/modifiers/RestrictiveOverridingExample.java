package com.manish.overriding.modifiers;

public class RestrictiveOverridingExample extends Test {
	// attempting to assign weaker access privileges; was protected
	/*
	void display() {
		System.out.println("Inside Child Class  ---> Default Modifier");
	}
	*/

	// attempting to assign weaker access privileges; was protected
        /*
	private void display() {
                System.out.println("Inside Child Class  ---> Default Modifier");
        }
	*/

	protected void display() { // This method will work only with public and protected modifiers
                System.out.println("Inside Child Class  ---> Default Modifier");
        }

	public static void main(String args[]) {
		RestrictiveOverridingExample roe = new RestrictiveOverridingExample();

		roe.display();
	}
}

class Test {
	protected void display() {
		System.out.println("From Parent Class");
	}
}
