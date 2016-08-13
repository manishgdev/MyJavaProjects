package com.manish.immutable;

import java.util.Date;

public class ImmutableTest {

	public static void main(String[] args) {
		String name = "Manish";
		Integer age = 25;
		Date dob = new Date();

		ImmutableClass ic = new ImmutableClass(name, age, dob);
		MutableClass mc = new MutableClass(name, age, dob);

		System.out.println("\nImmutable Class Name :- "+ic.getName());
		System.out.println("Mutable Class Name :- "+mc.getName());
		System.out.println("\nImmutable Class Modified Name :- "+ic.getName().concat(" Singh"));
		System.out.println("Mutable Class Modified Name :- "+mc.getName().concat(" Singh"));
		name = "Manish Singh";
		System.out.println("\nImmutable Class Name After Modification :- "+ic.getName());
		System.out.println("Mutable Class Name after modification :- "+mc.getName());
	}
}
