package com.manish.datastructures;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationTest {
	public static void main(String args[]) {
		Vector<Integer> v = new Vector<>(5);
		v.add(5);
		v.add(6);
		v.add(7);
		System.out.println("Enumerating over the elements of Vector :- "+v.subList(0,v.size()));
		Enumeration<Integer> e = v.elements();

		while(e.hasMoreElements())
			System.out.print(e.nextElement()+" ");

		System.out.println("\nAdd Elements to the Enumeration while looping");
		e = v.elements();
		int i = 0;
		while(e.hasMoreElements()) {
			if(i == 2)
				v.add(8);
			System.out.print(e.nextElement() + " ");
			i++;
		}

		System.out.println();
	}
}

