package com.manish.stringop;

/*
* A class using clone Object of Method should implement Cloneable interface otherwise CloneNotSupportedException will thrown
*
*/
public class ConstructorTest implements Cloneable {

	int rollNo;
	String name;

	public ConstructorTest() {

	}

	public ConstructorTest(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	public ConstructorTest(ConstructorTest constrObj) {
		rollNo = constrObj.rollNo;
		name = constrObj.name;
	}

	public void printRecord() {
		System.out.println("Roll Number = "+rollNo+" & Name = "+name);
	}

	// If clone() method is not ooverridden then error will come as clone() has protected access in Object
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
}
