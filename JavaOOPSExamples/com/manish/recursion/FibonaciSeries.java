package com.manish.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class FibonaciSeries {
	static int fibArr[];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array to store the fibonacci series :- ");
		int size = sc.nextInt();
		fibArr = new int[size];
		FibonaciSeries fs = new FibonaciSeries();

		fs.buildFibonacci(size);
		for(int i = 0; i < size; i++) {
			if((i+1) == size)
				System.out.print(fibArr[i]);
			else
				System.out.print(fibArr[i]+", ");
		}
		System.out.println();
		sc.close();
	}
	
	public void buildFibonacci(int size) {
		fibArr[0] = 0;
		fibArr[1] = 1;
		for(int i=2; i < size; i++)
		{
			fibArr[i] = getFibNum(i);
			//System.out.println("Fib["+i+"] = "+fibArr[i]);
		}	

	}
	
	public int getFibNum(int num) {
		if(num == 0)
			return 0;
		if(num == 1)
			return 1;
		return getFibNum(num-1) + getFibNum(num-2);
	}
}
