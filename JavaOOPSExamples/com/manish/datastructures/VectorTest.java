package com.manish.datastructures;

import java.util.Vector;

public class VectorTest {
	public static void main(String args[]) {
		Vector<Integer> v = new Vector<Integer>(3,2);
		System.out.println("Initially size of Vecor :- "+v.size()+" & capacity of vector :- "+v.capacity());
		v.addElement(5);
		v.addElement(6);
		v.addElement(8);
		System.out.println("\nAfter 3 additions, Size = "+v.size()+" & capacity = "+v.capacity());
		System.out.println("Vector values :- "+v.subList(0,v.size()));
		v.addElement(1);
		System.out.println("\nAfter 4 additions, Size = "+v.size()+" & capacity = "+v.capacity());
		System.out.println("Vector values :- "+v.subList(0,v.size()));
		v.addElement(9);
		System.out.println("\nAfter 5 additions, Size = "+v.size()+" & capacity = "+v.capacity());
		System.out.println("Vector values :- "+v.subList(0,v.size()));
		v.addElement(0);
		System.out.println("\nAfter 6 additions, Size = "+v.size()+" & capacity = "+v.capacity());
		System.out.println("Vector values :- "+v.subList(0,v.size()));
		v.addElement(12);
		System.out.println("\nAfter 7 additions, Size = "+v.size()+" & capacity = "+v.capacity());
		System.out.println("Vector values :- "+v.subList(0,v.size()));
		v.addElement(45);
                System.out.println("\nAfter 8 additions, Size = "+v.size()+" & capacity = "+v.capacity());
		System.out.println("Vector values :- "+v.subList(0,v.size()));
		v.addElement(56);
                System.out.println("\nAfter 9 additions, Size = "+v.size()+" & capacity = "+v.capacity());
		System.out.println("Vector values :- "+v.subList(0,v.size()));
		System.out.println("\nDo Removals");
		v.removeElementAt(v.size() - 1);
		System.out.println("\nAfter 1 removal, Size = "+v.size()+" & capacity = "+v.capacity());
		System.out.println("Vector values :- "+v.subList(0,v.size()));
		v.removeElementAt(v.size() - 1);
                System.out.println("\nAfter 2 removal, Size = "+v.size()+" & capacity = "+v.capacity());
		System.out.println("Vector values :- "+v.subList(0,v.size()));
		v.removeElementAt(v.size() - 1);
                System.out.println("\nAfter 3 removal, Size = "+v.size()+" & capacity = "+v.capacity());
                System.out.println("Vector values :- "+v.subList(0,v.size()));

		System.out.println("\nTrimming to vector to its size trimToSize()");
		v.trimToSize();
		System.out.println("\nAfter Trimming, Size = "+v.size()+" & capacity = "+v.capacity());
                System.out.println("Vector values :- "+v.subList(0,v.size()));

		v.addElement(58);
                System.out.println("\nAfter 10 additions, Size = "+v.size()+" & capacity = "+v.capacity());
                System.out.println("Vector values :- "+v.subList(0,v.size()));

		System.out.println("\nFirst Element firstElement() :- "+v.firstElement());
		System.out.println("\nLast Element lastElement() :- "+v.lastElement());
		System.out.println("\n4th elements get(int index) :- "+v.get(3));

		System.out.println("\nSet size() and trimToSize()");
		v.setSize(5);
		v.trimToSize();
		System.out.println("Size = "+v.size()+" & capacity = "+v.capacity());
		System.out.println("Vector values :- "+v.subList(0,v.size()));

		System.out.println("\nClear clear() operation");
		v.clear();
		System.out.println("Size = "+v.size()+" & capacity = "+v.capacity());
		System.out.println("Vector values :- "+v.subList(0,v.size()));

		System.out.println("\nRemove All  removeAllElements() operation");
                v.removeAllElements();
                System.out.println("Size = "+v.size()+" & capacity = "+v.capacity());
                System.out.println("Vector values :- "+v.subList(0,v.size()));

	}
}
