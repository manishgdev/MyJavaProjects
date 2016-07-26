package com.manish.mainpack;

import org.testng.TestNG;
import com.manish.tngfactory.TestNGFactory;

public class MainEntry {
	public static void main(String args[]) {
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { TestNGFactory.class });
		testng.run();
	}
}


