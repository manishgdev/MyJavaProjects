package com.manish.strings;

public class StringReversal {
	String reverse = "";
	public static void main(String args[]) {
		String a = "cucumber";
		StringReversal sr = new StringReversal();
		System.out.println("Original String is :"+a);
		sr.reverseByCharArray(a);
		sr.reverByStringConcat(a);
		sr.reverseByStringBuffer(a);
		sr.reverseByStringBuilder(a);
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

	public void reverByStringConcat(String a) {
		int length = a.length();
                String revString="";
                for(int i=(length-1); i>=0; i--) {
                        revString = revString.concat(a.charAt(i)+"");
                }
		System.out.println("\nReverse String by add character to String : "+revString);
	}

	public void reverseByCharArray(String a) {
		int length = a.length();
		char revChar[] = new char[length];
		int j=0;
		for(int i=(length-1); i>=0; i--) {
			revChar[j] = a.charAt(i);
			j++;
		}
		String revString = new String(revChar);
		System.out.println("\nReversed String obtained from Character Array is : "+revString);
	}

	public void reverseByStringBuffer(String a) {
		int length = a.length();
		StringBuffer sBuff = new StringBuffer();
		for(int i=(length-1); i>=0; i--) {
                        sBuff.append(a.charAt(i));
                }
		System.out.println("\nReversed String by String Buffer Method : "+sBuff.toString());
	}

	public void reverseByStringBuilder(String a) {
                int length = a.length();
                StringBuilder sBuild = new StringBuilder();
                for(int i=(length-1); i>=0; i--) {
                        sBuild.append(a.charAt(i));
                }
                System.out.println("\nReversed String by String Builder Method : "+sBuild.toString());
        }
}
