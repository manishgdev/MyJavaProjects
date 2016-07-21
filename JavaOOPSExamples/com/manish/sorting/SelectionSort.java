package com.manish.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;

public class SelectionSort {
	static boolean printConsole = false;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 1 to show debugging text or 0 for not showing");
		if(Integer.parseInt(br.readLine()) == 1)
			printConsole = true;
		printOutput("Enter the array separated by space");
		String lineArr[] = br.readLine().split(" ");
		int Arr[] = new int[lineArr.length];
		for(int i=0; i<lineArr.length; i++){
			Arr[i] = Integer.parseInt(lineArr[i]);
		}
		selectionSort(Arr, Arr.length);
	}
	
	// the idea behind bubble sort is to put largest number to end
	// and outer loop goes till N-1 because in last loop there will be comparision of second last and last only
	public static void selectionSort(int[] Arr, int N) {
		for(int i=0; i< N-1; i++){
			printConsole("====>Running for Arr["+i+"] = "+Arr[i]);
			// Assume ith position to be minimum and shift it to respective position while comparing it with further elements
			int minimum = i;
			for(int j=i+1; j < N; j++)
			{
				printConsole("Comparing Arr["+i+"] = "+Arr[i] + " and Arr["+j+"] = "+Arr[j]);
				if(Arr[i] > Arr[j]) // Find the minimum and swap it with ith position
				{
					printConsole("Store j = "+j+" to perform swapping");
					minimum = j;
				}
			}
			printConsole("Final value of minimum = "+minimum );
			int temp = Arr[i];
			printConsole("Arr["+i+"]= "+Arr[i]+ " & Arr["+minimum+"] = "+Arr[minimum]);
			Arr[i] = Arr[minimum];
			Arr[minimum] = temp;
			printConsole("After Swapping :- Arr["+i+"] = "+Arr[i]+" & Arr["+minimum+"] = "+Arr[minimum]);
		}
		printOutput("Sorted Array is :- ");
		for(int i=0; i<N; i++){
			System.out.print(Arr[i]+" ");
		}
		System.out.println();	
	}	
	
	public static void printOutput(Object obj) {
		System.out.println(obj);
	}
	
	public static void printConsole(Object obj) {
		if(printConsole)
			printOutput(obj);
	}
}
