package com.manish.numbers;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class FibonaciSeries {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Size for the Fibonacci Array");
		int size = sc.nextInt();

		Integer fArr[] = new Integer[size];
		fArr[0] = 0;
		fArr[1] = 1;
		for(int i = 2; i < size; i++) {
			fArr[i] = fArr[i-1] + fArr[i-2];
		}
		System.out.println((new ArrayList<Integer>(Arrays.asList(fArr))));
	}
}
