package com.manish.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;

public class InsertionSort {
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
		insertionSort(Arr, Arr.length);
	}
	
	public static void insertionSort(int[] Arr, int N) {
		for(int i = 0; i < N; i++){
			printConsole("====>Running for Arr["+i+"] = "+Arr[i]);
			// Assume ith position to be minimum and shift it to respective position while comparing it with further elements
			
			int temp = Arr[i];
			printConsole("Store Arr["+i+"] = "+temp+" in temp");
			int j = i;
			while(j > 0 && temp < Arr[j - 1]){
				printConsole("Arr["+j+"] = "+Arr[j] + " < Arr["+(j-1)+"] =  "+Arr[j-1] +" -> insert Arr["+(j-1)+"] into Arr["+i+"]");
				Arr[j] = Arr[j-1];
				printConsole("After insertion :- Arr["+j+"] = "+Arr[j]+" & Arr["+(j-1)+"] = "+Arr[j-1]);
				j = j-1;
			}
			Arr[j] = temp;
			printConsole("After Comparision Arr["+j+"] = "+temp);
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
