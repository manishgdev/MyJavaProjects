package com.manish.recursion;

public class ReverseNumber {

	Integer modular = 0;

	public Integer getReverseNumber(Integer number){
		modular = (modular*10) + number % 10;
		number = number / 10;
		if(number == 0)
			return modular;
		else {
			getReverseNumber(number);
		}
		return modular;
	}

	public static void main(String args[]) {
		Integer number;

		if(args.length !=0)
			number = Integer.parseInt(args[0]);
		else
			number = 786923;
		System.out.println("\nOriginal Number is :- "+number);
		System.out.println("Reverse of Number is :- "+ new ReverseNumber().getReverseNumber(number)+"\n");
	}
}
