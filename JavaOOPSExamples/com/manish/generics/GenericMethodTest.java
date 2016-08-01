package com.manish.generics;

import java.util.List;
import java.util.ArrayList;

public class GenericMethodTest {
	public static void main(String args[]) {
		String a = "abc";
		Integer i = 24;
		printObject(a);
		printObject(i);

		List<String> tmpList = new ArrayList<>();

		tmpList.add("A");
		tmpList.add("B");
		tmpList.add("C");
		tmpList.add("D");
		printObject(tmpList);

		String stringArr[] = {"A", "B", "C", "D", "E", "F"};
		printArray(stringArr);
		Integer intArr[] = {1,2,3,4,5,6,7};
		printArray(intArr);
	}

	public static <E> void printArray(E[] inputArray) {
		System.out.println("Printing array in generic print array method :- ");
		for(E element : inputArray)
			System.out.print(element+" ");
		System.out.println();
	}

	public static <E> void printObject(E object) {
		System.out.println("Printing Object in generic print object method :- "+object);
	}

}
