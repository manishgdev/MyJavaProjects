package com.manish.datastructures;

import java.util.Properties;
import java.util.Enumeration;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;

public class PropertiesDemo {
	public static void main(String args[]) throws IOException{
		Properties prop = new Properties();
		prop.put("Watch", "Fastrack");
		prop.put("Pen", "Sheaffer");
		prop.put("Bag", "Lee Cooper");
		prop.put("Shoes", "Red Chief");
		System.out.println("Test the list(PrintStream / Printwriter method) ");
		PrintStream ps = new PrintStream(System.out);

		prop.list(ps);
		ps.flush();

		System.out.println("\nprop.put(key,value) is inherited from parent Hashtable");
		System.out.println("prop.setProperty(key,value) the call will go to the put method of Hashtable");

		System.out.println("\nSet object returned by prop.stringPropertyName() = "+prop.stringPropertyNames());
		Enumeration propEnum = prop.propertyNames();
		System.out.println("Property names from Enumeration prop.propertyNames()");
		while(propEnum.hasMoreElements())
			System.out.println("Printing Enumeration of Properties :- "+propEnum.nextElement());

		System.out.println("\ngetProperty(property) for existing property 'Watch' :- "+prop.getProperty("Watch"));
		System.out.println("getProperty(property) for non-existing property 'ABC' :- "+prop.getProperty("ABC"));
		System.out.println("getProperty(property,default) for existing property 'Bag' :- "+prop.getProperty("Bag", "is not found"));
		System.out.println("getProperty(property,default) for non-exising property 'Tie' :- "+prop.getProperty("Tie", "is not found"));

		System.out.println("\nGoing to test load(inputstream) method");
		//InputStreamReader is = new InputStreamReader(System.in);
		InputStream fis = (new PropertiesDemo()).getClass().getResourceAsStream("/com/manish/datastructures/prop.properties");
		prop.load(fis);
		fis.close();
		System.out.println("Properties after loading property from console :- "+prop.stringPropertyNames());
	}
}
