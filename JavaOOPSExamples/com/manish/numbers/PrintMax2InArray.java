package com.manish.numbers;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintMax2InArray {
	public void printTwoMaxNumbers(Integer[] nums){
        	Integer maxOne = 0;
	        Integer maxTwo = 0;
        	for(Integer n:nums){
	            if(maxOne < n){
        	        maxTwo = maxOne;
                	maxOne =n;
	            } else if(maxTwo < n){
        	        maxTwo = n;
            	}
        	}
	        System.out.println("First Max Number: "+maxOne);
        	System.out.println("Second Max Number: "+maxTwo);
	}

	public static void main(String a[]){
        	Integer num[] = {5,34,78,2,45,1,99,23};
        	PrintMax2InArray tmn = new PrintMax2InArray();
	        System.out.println("Two Maximum Numbers in Array of :- "+(new ArrayList<Integer>(Arrays.asList(num))));
		tmn.printTwoMaxNumbers(num);
    	}

}

