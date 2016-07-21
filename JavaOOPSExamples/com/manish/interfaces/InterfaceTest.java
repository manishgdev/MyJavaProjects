package com.manish.interfaces;

interface ClassA {

	int num1 = 20;
	// private int num2 = 50;
	public void methodA();
	public void methodB();

	/*
	private static void methodD() {
		System.out.println("Inside private method of Interface -> This can be invoked only from static method of interface");
		System.out.println();
	}
	*/
	public static void methodC() {
		System.out.println("Static method in Interface");
		System.out.println("Define private variable in interface :- private int num2 = 50; will give below error");
		System.out.println("modifier private not allowed here ");
		System.out.println("Define private method in Interface :-  private void methodD(){method body} -> will give below error");
		System.out.println("modifier private not allowed here\nnon-static method methodD() cannot be referenced from a static context ");
		System.out.println("Define private method in Interface with static :- private static void methodD() -> will give below error");
		System.out.println("modifier private not allowed here");
		System.out.println("Defining default methods in Interface :- void methodE() -> will give below Error :-\ninterface abstract methods cannot have body");
		System.out.println();
		// methodD();
	}
	/*
	void methodE() {
		System.out.println("Default method in Interface");
	}*/
}

public class InterfaceTest implements ClassA {

	public void methodA() {
		System.out.println("MethodA in child class");
		System.out.println("Access value of variable defined in interface in methodA :- num1 = "+num1);
		// num1 = num1 + 10;
		System.out.println("num1 = num1 + 10; will give below error :- \ncannot assign a value to final variable num1");
		System.out.println();
		// methodE();
	}

	public void methodB() {
		System.out.println("MethodB in child class");
		System.out.println("Access value of variable defined in interface in methodB :- num1 = "+num1);
		System.out.println();
	}

	public static void methodC() {
		System.out.println("static methodC in Child Class");
	}

	public static void main(String args[]) {
		ClassA cl = new InterfaceTest();

		cl.methodA();
		cl.methodB();
		//cl.methodC();
		ClassA.methodC();
		InterfaceTest.methodC();
	}
}
