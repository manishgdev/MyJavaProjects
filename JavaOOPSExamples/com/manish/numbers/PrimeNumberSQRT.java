package com.manish.numbers;

import java.util.Scanner;
import java.io.IOException;

public class PrimeNumberSQRT {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);

		System.out.println("\nEnter a number to perform Prime Number test");
		int num = sc.nextInt();
		int count = 0;
		for(int i = 1; i*i <= num; i++) {
			if(num % i == 0) {
				if(i*i == num)
					count++;
				else
					count += 2;
			}
		}
		System.out.println("Number of Divisors for "+num+" are "+count);
		if(count > 2)
			System.out.println("Number = "+num+" is not a prime number");
		else
			System.out.println("Number = "+num+" is a prime number");

		sc.close();
	}
}
