package com.manish.stringop;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class CharCountInStringApp 
{
    public CharCountInStringApp() {
        String myString = "Cucumber Execution Test";
        myString = myString.toUpperCase();
        System.out.println("String to test is : '"+myString+"'");
        LinkedHashMap<String, Integer> charCountMap = new LinkedHashMap<String, Integer>();
        
        for(int i=0; i<myString.length(); i++) {
		char c = myString.charAt(i);
		char chArr[] = new char[]{c};
		String tmpString = new String(chArr);
		
			// System.out.println("The Character at ("+i+") position is '"+tmpString+"'");
		if(charCountMap.get(tmpString) != null) {
			Integer strCount = charCountMap.get(tmpString);
			// strCount++;
			charCountMap.put(tmpString, ++strCount);
		}
		else {
			charCountMap.put(tmpString, new Integer(1));
		}
	}
	System.out.println("Character Count Map : "+charCountMap);
    }
}
