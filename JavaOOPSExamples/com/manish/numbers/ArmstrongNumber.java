package com.manish.numbers;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ArmstrongNumber {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Number to check for Armstrong Number");
		int num = Integer.parseInt(br.readLine());

		int numLength = String.valueOf(num).length();

		int sum = 0;
		// int modulus;
		int tempNum = num;
		while(num > 0) {
			int modulus = num % 10;
			int temp = 1;
			for(int i = 0; i < numLength; i++) {
				temp = temp * modulus;
			}
			sum = sum + temp;
			num = num / 10;
		}
		System.out.println("Sum obtained is :- "+sum);
		if(sum == tempNum)
			System.out.println("Entered number is Armstrong Number");
		else
			System.out.println("Entered number is not an Armstrong Number");
	}

}
