package com.manish.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;

public class BubleSort {
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
		bubbleSort(Arr, Arr.length);
	}
	
	// the idea behind bubble sort is to put largest number to end
	// and outer loop goes till N-1 because in last loop there will be comparision of second last and last only
	public static void bubbleSort(int[] Arr, int N) {
		for(int i=0; i< N-1; i++){
			printConsole("====>Running for Arr["+i+"] = "+Arr[i]);
			for(int j=0; j < N-i-1; j++)
			{
				printConsole("Comparing Arr["+j+"] = "+Arr[j] + " and Arr["+(j+1)+"] = "+Arr[j+1]);
				if(Arr[j] > Arr[j+1])
				{
					printConsole("Perform Swapping");
					int temp = Arr[j];
					Arr[j] = Arr[j+1];
					Arr[j+1] = temp;
				}
			}
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
