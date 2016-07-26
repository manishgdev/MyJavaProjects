package com.manish.recursion;

import java.util.Scanner;
import java.io.IOException;

public class SumDigits {
	int sum = 0;

	public int getNumberSum(int number){
        	if(number == 0){
	            return 0; // return sum; will also work because at 0 sum will be zero
        	} else {
            		sum += (number%10);
	         	getNumberSum(number/10);
        	}
	        return sum;
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to find sum of digits :-");
		int num = sc.nextInt();

		System.out.println("Sum of Digits for "+num+" = "+(new SumDigits()).getNumberSum(num));
	}
}
