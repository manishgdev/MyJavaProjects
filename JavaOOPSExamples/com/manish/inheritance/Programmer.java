package com.manish.inheritance;

public class Programmer extends Employee{
	int bonus = 5000;

	public int getTotal() {
		return salary + bonus; // Salary Variable in parent can be accessed via super keyword and directly also
	}

	public static void main(String args[]) {
		Programmer p = new Programmer();
		System.out.println("Salary Of Programmer is : Rs. "+ p.salary);
		System.out.println("Bonus given to the Programmer is : Rs. "+ p.bonus);
		System.out.println("Total in-hand amount of Programmer is : Rs. "+ p.getTotal());
	}

}

class Employee {
	int salary = 40000; 
}
