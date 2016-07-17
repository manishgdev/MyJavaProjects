package com.manish.numbers;

public class ReverseNumber {
	Integer reverseNum = 0;
	public Integer getReverseNumber(Integer number){
		while(number != 0){
			reverseNum = (reverseNum * 10) + (number%10);
			number = number / 10;
		}
		return reverseNum;
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
