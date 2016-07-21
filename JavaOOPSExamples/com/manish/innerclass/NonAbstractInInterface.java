package com.manish.innerclass;

interface Printable {
	void print();

	class Printer {
		public void getName() {
			System.out.println("Printer Name is :- Epson");
		}
	}
}

public class NonAbstractInInterface implements Printable {

	public void print() {
		System.out.println("Printing in Test Class");
	}

	public static void main(String args[]) {
		NonAbstractInInterface naip = new NonAbstractInInterface();
		naip.print();

		NonAbstractInInterface.Printer printer = new NonAbstractInInterface.Printer();

		printer.getName();
	}
}
