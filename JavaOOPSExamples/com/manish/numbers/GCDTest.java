package com.manish.numbers;

import java.util.Scanner;
import java.io.IOException;

public class GCDTest {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Numbers to find the GCD :-");
		System.out.println("\nEnter First Number");
		int num1 = sc.nextInt();
		System.out.println("\nEnter Second Number");
		int num2 = sc.nextInt();
		System.out.println("GCD of Numbers "+num1+" & "+ num2 +" = "+getGCD(num1,num2));
	}

	public static int getGCD(int num1, int num2) {
		int min = Math.min(num1, num2);

		for(int i = min; i > 0; i--) {
			if((num1 % i ==0) && (num2 % i == 0))
				return i;
		}
		return 1;
	}
}
