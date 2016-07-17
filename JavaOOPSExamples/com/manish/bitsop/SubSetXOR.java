package com.manish.bitsop;

/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

// This is giving wrong result and for Sets in HackerEarth it is giving NEZC for {1,2,3} xorian operation is giving 2 it should give 0
class SubSetXOR {
    public static void main(String args[] ) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Read the Number");
	String line = br.readLine();
	System.out.println("Number Read");
        int N = Integer.parseInt(line);
        List<List<int[]>> subSetList = new ArrayList<List<int[]>>();
        List<Integer> outputList = new ArrayList<Integer>();
        System.out.println("Execute Test for "+ N +" Times");
	for (int i = 0; i < N; i++) {
		System.out.println("Read Numbers in Array :- "+N);
		line = br.readLine();
            int T = Integer.parseInt(line);
            
            int intArr[] = new int[T];
	    System.out.println("Read Input Array :- Provide "+T+" number separated by space :- ");
            String intString = br.readLine();
            System.out.println("Read Complete ");
            String arrString[] = intString.split(" ");
	    System.out.println("String array Complete ");
            for(int s=0; s<T; s++)
            	intArr[s] = Integer.parseInt(arrString[i]);

	    System.out.println("Integer Array Read");
            /*
            List<Integer> intList = new ArrayList<Integer>();
            for(int j = 0; j < T; j++) {
            	intList.add(Integer.parseInt(br.readLine()));
            }
            */
            
            subSetList.add(getSubsetList(intArr));
        }
        
        for(List<int[]> intArrList: subSetList) {
        	outputList.add(xorianOp(intArrList));
        }
        
        for(Integer output: outputList)
        	System.out.println(output);
    }
    
    // public static List<int[]> getSubsetList(List<Integer> intList) {
    public static List<int[]> getSubsetList(int[] intArr) {
    	int numSubSets = (1 << intArr.length) - 1;
    	List<int[]> intArrList = new ArrayList<int[]>();
    	for(int i=1; i<=numSubSets; i++) {
    		int arrSize = getSetBits(numSubSets);
    		int arr[] = new int[arrSize];
    		for(int j=0; j<arrSize; j++) {
    			arr[j] = intArr[j];
    		}
    		intArrList.add(arr);
    	}
    	
    	return intArrList;
    }
    
    public static int getSetBits(int numSubSets) {
    	int count = 0;
    	while(numSubSets != 0) {
    		numSubSets = numSubSets & (numSubSets -1);
    		count++;
    	}
    	return count;
    }
    
    public static int xorianOp(List<int[]> intArrList){
    	int tmpVar = 0;
    	for(int[] arr: intArrList)
    		tmpVar = tmpVar ^ xorOfArr(arr);
    		
    	return tmpVar;
    }
    
    public static int xorOfArr(int intArr[]) {
    	int tmpVar = 0;
    	for(int num: intArr)
    		tmpVar = tmpVar ^ num;
    	
    	return tmpVar;
    }
}

