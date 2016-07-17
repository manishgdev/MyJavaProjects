package com.manish.aggregation;

public class Employee {
	int empCode;
	String name ;
	Address address;

	public Employee(int empCode, String name, Address address) {
		this.empCode = empCode;
		this.name = name;
		this.address = address;
	}

	public void printInformation() {
		System.out.println("\nEmp Code = "+empCode+", Name = "+name);
		System.out.println("Address :- "+address.city+" ("+address.state+")");
	}

	public static void main(String args[]) {
		Address addr1 = new Address("Varanasi", "UP");
		Address addr2 = new Address("Nashik", "MH");

		Employee emp1 = new Employee(5, "Rahul", addr1);
		Employee emp2 = new Employee(6, "Sanjay", addr2);

		emp1.printInformation();
		emp2.printInformation();
	}
}
