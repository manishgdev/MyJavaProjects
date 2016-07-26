package com.manish.numbers;

import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Decimal2Binary {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to get the Binary Representation");

		int num = sc.nextInt();
		List<Integer> binList = getBinaryRep(num);
		System.out.print("Binary Representation for "+num +" is :- ");
		for(int i = binList.size()-1; i >= 0; i--)
			System.out.print(binList.get(i)+" ");
		System.out.println();
	}

	public static List<Integer> getBinaryRep(int num) {
		List<Integer> tmpList = new ArrayList<Integer>();

		while(num > 0) {
			int modRes = num % 2;
			tmpList.add((Integer)modRes);
			num = num / 2;
		}

		return tmpList;
	}
}
