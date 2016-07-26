package com.manish.numbers;

import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class PrimeNumbers {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);

		System.out.println("\nEnter a number to perform Prime Number test");
		int num = sc.nextInt();
		int count = 0;
		List<Integer> divList = new ArrayList<Integer>();
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				divList.add((Integer)i);
				count++;
			}
		}
		System.out.println("Number of Divisors for "+num+" are "+count +" & divisors are :- "+divList);
		if(count > 2)
			System.out.println("Number = "+num+" is not a prime number");
		else
			System.out.println("Number = "+num+" is a prime number");
		sc.close();
	}
}
