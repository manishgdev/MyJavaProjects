package com.manish.thiskeyword;

public class ThisInstaceVariable {
	int id;
	String name;

	public ThisInstaceVariable(int id, String name) {
		this.id = id; // Use This to avoid ambiguity between instance variable and method parameter
		this.name = name;
	}

	public void showData() {
		System.out.println("ID = "+id+", Name = "+name);
	}

	public static void main(String args[]) {
		ThisInstaceVariable test = new ThisInstaceVariable(54, "Raju");
		test.showData();
	}
}

