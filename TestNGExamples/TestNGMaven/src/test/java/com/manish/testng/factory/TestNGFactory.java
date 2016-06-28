package com.manish.testng.factory;

import org.testng.annotations.Factory;
import java.util.List;
import java.util.ArrayList;

public class TestNGFactory {
	
	@Factory
	public Object[] createTestInstance() {
		Object[] result;
		List<String> instanceList = new ArrayList<String>();
		instanceList.add("Test 1");
		instanceList.add("Test 2");
		instanceList.add("Test 3");
		instanceList.add("Test 4");
		instanceList.add("Test 5");
		instanceList.add("Test 6");
		
		result = new Object[instanceList.size()];
		for(int i=0; i<instanceList.size(); i++) {
			result[i] = new TestFactoryExec(instanceList.get(i));	
		}
		
		return result;
	}
}


