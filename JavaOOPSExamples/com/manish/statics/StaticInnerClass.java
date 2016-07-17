package com.manish.statics;

public class StaticInnerClass {
	static int data = 45;

	static class Inner {
		public void addData() {
			data+=15;
		}

		public void showData() {
			System.out.println("Value of Data inside Inner Class : "+data);
		}

		public static void showDataFromStatic() {
			System.out.println("Value of Data in static method of Inner Class : "+data);
		}
	}

	public static void showData() {
		System.out.println("Value of Data in Outer Class : "+data);
	}

	public static void main(String args[]) {
		showData();

		StaticInnerClass.Inner innerObj = new StaticInnerClass.Inner();
		System.out.println("Add 15 to the data variable in Inner Class");
		innerObj.addData();
		innerObj.showData();
		StaticInnerClass.Inner.showDataFromStatic();
		System.out.println("Value of data after adding 15 from Inner Classs in the Outer Class");
		showData();
	}
}
