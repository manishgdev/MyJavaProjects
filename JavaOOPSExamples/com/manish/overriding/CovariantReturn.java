package com.manish.overriding;

public class CovariantReturn extends SampleClass{

	// Allowed after JAVA 5
	CovariantReturn get() { // covariant return type specifies that the return type may vary in the same direction as the subclass
		return this;
	}

	public void showMessage() {
		System.out.println("Showing Message from Child Class");
	}

	public static void main(String args[]) {
		new CovariantReturn().get().showMessage();
	}
}

class SampleClass {
	SampleClass get() {
		return this;
	}

	public void showMessage() {
		System.out.println("Showing Message from Parent Class");
	}
}
