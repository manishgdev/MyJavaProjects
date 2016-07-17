package com.manish.recursion;

public class StringReversal {
	String reverse = "";
	public static void main(String args[]) {
		String a = "cucumber";
		StringReversal sr = new StringReversal();
		System.out.println("Original String is :- "+a);
		System.out.println("\nString Reversal by Recursion :- " + sr.reverseStringByRecusrsion(a));
	}

	public String reverseStringByRecusrsion(String str){
		//System.out.println("String recieved is : "+str);
        	if(str.length() == 1){
         	   return str;
       	 	} else {
            		reverse += str.charAt(str.length()-1) + reverseStringByRecusrsion(str.substring(0,str.length()-1));
           		return reverse;
        	}
    	}
}
