package com.manish.recursion;

import java.util.Scanner;
import java.io.IOException;

public class ExtendedEuclid {

	static int gcd, A, B;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Numbers to find the GCD :-");
		System.out.println("\nEnter First Number");
		int num1 = sc.nextInt();
		System.out.println("\nEnter Second Number");
		int num2 = sc.nextInt();

		if(Math.min(num1, num2) == num1)
			extendedEuclid(num2, num1);
		else
			extendedEuclid(num1, num2);

		System.out.println("\nGCD of "+num1+" & "+num2+" = "+gcd);
		System.out.println("Coefficents of Ax+By = GCD(A,B) for multiplicative inverse : A = "+A+ ", B = "+B);
	}

	public static void extendedEuclid(int num1, int num2) {
		// System.out.println("GCD of "+num1+" & "+num2+ ", GCD = "+gcd+", A = "+A+", B = "+B);
		if(num2 == 0) {
			gcd = num1;
			A = 1;
			B = 0;
		}
		else {
			extendedEuclid(num2, num1 % num2);
			int temp = A;
			A = B;
			B = temp - (num1 / num2)*B;
		}
		// return gcd;
	}
}
