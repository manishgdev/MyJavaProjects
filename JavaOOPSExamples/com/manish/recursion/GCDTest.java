package com.manish.recursion;

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
		int gcd ;
		if(Math.min(num1, num2) == num1)
			gcd = getGCD(num2, num1);
		else
			gcd = getGCD(num1, num2);
		System.out.println("GCD of Numbers "+num1+" & "+ num2 +" = "+ gcd);
	}

	public static int getGCD(int num1, int num2) {
		System.out.println("GCD of "+ num1 + " & "+num2);
		if(num2 == 0)
			return num1;
		return getGCD(num2, num1 % num2);
	}
}
