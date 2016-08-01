package com.manish.generics;

import java.util.List;
import java.util.ArrayList;

public class GenericClass<T> {
	private T t;
	private List<T> tList;
	{
		tList = new ArrayList<T>();
	}

	public void setObj(T t) {
		this.t = t;
	}

	public void addList(T t) {
		tList.add(t);
	}

	public T getObj() {
		return t;
	}

	public List<T> getList() {
		return tList;
	}

	public static void main(String args[]) {
		GenericClass<Integer> gcInt = new GenericClass<Integer>();
		gcInt.setObj(33);
		System.out.println("Getting Integer from the Generic class : "+gcInt.getObj());
		gcInt.addList(5);
		gcInt.addList(6);
		gcInt.addList(7);
		gcInt.addList(8);
		System.out.println("Printing generic List of Class :- "+gcInt.getList());

		GenericClass<String> gcStr = new GenericClass<String>();
		gcStr.setObj("Hello");
		System.out.println("Getting String from the Generic Class : "+gcStr.getObj());
		gcStr.addList("Apple");
		gcStr.addList("Mango");
		gcStr.addList("Banana");
		gcStr.addList("Pineapple");
		gcStr.addList("Orange");
		System.out.println("Generic String list in the class :- "+gcStr.getList());

	}
}
