package com.manish.datastructures;

import java.util.Hashtable;
import java.util.Enumeration;

public class HashTableDemo {
	public static void main(String args[]) {
		Hashtable<String,String> ht = new Hashtable<String,String>();
		ht.put("Watch","Fastrack");
		ht.put("Bag", "Lee Cooper");

		Enumeration<String> enumHt = ht.keys();

		while(enumHt.hasMoreElements()) {
			System.out.println("Inside Enumeration over the keys of Hashtable :- "+enumHt.nextElement());
		}
		System.out.println("Size of Hashtable :- "+ht.size());
		System.out.println("ht.rehash() cannot be called as the access for rehash() method is protected");
	}
}
