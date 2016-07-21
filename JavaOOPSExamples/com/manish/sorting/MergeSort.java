package com.manish.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;

public class MergeSort {
	static boolean printConsole = false;
	Integer[] actArr;
	Integer[] tempArr;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 1 to show debugging text or 0 for not showing");
		if(Integer.parseInt(br.readLine()) == 1)
			printConsole = true;
		System.out.println("Enter the array separated by space");
		String lineArr[] = br.readLine().split(" ");
		Integer Arr[] = new Integer[lineArr.length];
		for(int i=0; i<lineArr.length; i++){
			Arr[i] = Integer.parseInt(lineArr[i]);
		}

		MergeSort ms = new MergeSort();
		ms.sort(Arr);		
	}
	
	public void sort(Integer Arr[]){
		actArr = Arr;
                tempArr = new Integer[Arr.length];
		doMergeSort(0, Arr.length-1);
	}
	
	public void doMergeSort(int lower, int upper) {
		printConsole("->Do Merge Sort Lower = "+lower+" & Upper = "+upper);
		if(lower < upper) {
			int middle = (lower + upper ) / 2;
			printConsole("---Lower = "+lower+", middle = "+middle+", upper = "+upper);
			doMergeSort(lower, middle);
			doMergeSort(middle+1, upper);
			mergeArr(lower, middle, upper);
		}
	}

	public void mergeArr(int lower, int middle, int upper) {
		printConsole("=====>Merge Array for Lower = "+lower+", middle = "+middle+", upper = "+upper);
		int p = lower;
		int q = middle + 1;

		Integer tmpArr[] = new Integer[upper - lower + 1];
		int k = 0;
		for(int i = lower; i <= upper; i++) {
			if(p > middle)
				tmpArr[k++] = actArr[q++];
			else if(q > upper)
				tmpArr[k++] = actArr[p++];

			else if( actArr[p] < actArr[q]) 
				tmpArr[k++] = actArr[p++];
			else
				tmpArr[k++] = actArr[q++];
		}

		for (int r=0 ; r< k ; r++) {
       			actArr[ lower++ ] = tmpArr[ r ] ; 
		}

		printConsole("Sorted Temp Array :-  "+(new ArrayList<Integer>(Arrays.asList(tmpArr))));
		printConsole("Actual Array :- "+(new ArrayList<Integer>(Arrays.asList(actArr))));
	}

	public void printOutput(Object obj) {
		System.out.println(obj);
	}
	
	public void printConsole(Object obj) {
		if(printConsole)
			printOutput(obj);
	}
}
