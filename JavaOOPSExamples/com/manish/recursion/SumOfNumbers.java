package com.manish.recursion;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class SumOfNumbers {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a Number to calculate sum of digits :-");
		int num = Integer.parseInt(br.readLine());

		System.out.println("Sum of digits for "+num+" = "+getSum(num));
	}

	public static int getSum(int num) {
		if(num == 0)
			return num;
		int modulus = num % 10;
		num = num / 10;

		int sum = modulus + getSum(num);

		return sum;
	}
}
