package com.manish.datastructures;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Enumeration;

public class DictionaryTest {
	public static void main(String args[]) {
		Dictionary<String, Integer> dict = new Hashtable<String, Integer>();

		System.out.println("Use isEmpty() method to check if Dictionary is empty :- "+dict.isEmpty());
		dict.put("Manish", 25);
		dict.put("Rahul", 26);
		dict.put("Satish", 8);
		dict.put("Pratish", 22);

		System.out.println("After putting values into the dictionary check if it is empty :- "+dict.isEmpty());
		System.out.println("Age of Pratish = "+dict.get("Pratish"));

		System.out.println("Number of Elements in the Dictionary :- "+dict.size());
		Enumeration<String> dictKeys = dict.keys();
		System.out.println("dict.keys() will return Enumeration for all the Keys in the Dictionary");
		while(dictKeys.hasMoreElements()) {
			String key = dictKeys.nextElement();
			System.out.println("Inside Enumeration loop :- Age for "+key+" = "+dict.get(key));
		}

		System.out.println("Order in which values are added in the Dictionary are :- Manish, Rahul, Satish, Pratish");
		dict.remove("Rahul");
		System.out.println("Size of dictionary after executing dict.remove(\"Rahul\") = "+ dict.size());

		Enumeration<Integer> elemEnum = dict.elements();
		System.out.println("dict.elements() will return the Enumeration for all the values in the Dictionary");
		while(elemEnum.hasMoreElements()) {
			System.out.println("Inside Enumeration for the Values of Dictionary :- "+elemEnum.nextElement());
		}
	}
}
