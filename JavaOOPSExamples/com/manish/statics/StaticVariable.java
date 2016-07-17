package com.manish.statics;
public class StaticVariable {
	int count = 0; // will get memory when instance is created
	static int staticCount = 0; //will get memory only once and retain its value

	public StaticVariable() {
		count++;
		staticCount++;
		System.out.println("Count Variable = "+count+" & Static Count Variable = "+staticCount);
	}

	public static void main(String args[]) {
		System.out.println("First Invocation");
		StaticVariable s1 = new StaticVariable();
		System.out.println("Second Invocation");
                StaticVariable s2 = new StaticVariable();
		System.out.println("Third Invocation");
                StaticVariable s3 = new StaticVariable();
		System.out.println("Anonymous Invocation");
                new StaticVariable();
	}
}
