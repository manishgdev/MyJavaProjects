package com.manish.numbers;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryCheck {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a number to check for Binary");
		int num = Integer.parseInt(br.readLine());
		System.out.println("Entered Number = "+num+" is binary ? "+isBinary(num));
	}

	public static boolean isBinary(int num) {
		if(num == 0)
			return true;

		while(num > 0) {
			int modulus = num % 10;
			if(modulus > 1)
				return false;
			num = num / 10;
		}
		return true;
	}
}
