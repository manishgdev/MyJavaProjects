package com.manish.numbers;

import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class PerfectNumber {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);

		System.out.println("\nEnter a number to perform Prime Number test");
		int num = sc.nextInt();
		int sum = 0;
		for(int i = 1; i <= num/2; i++) {
			if(num % i == 0) {
				sum += i;
			}
		}
		if(sum == num)
			System.out.println("Number = "+num+" is a perfect number");
		else
			System.out.println("Number = "+num+" is not a perfect number");
		sc.close();
	}
}
