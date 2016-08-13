package com.manish.generics;

import java.util.List;
import java.util.ArrayList;

public class GenericMethod {

	public <T> List<T> getList(T... t) {
		List<T> resultList = new ArrayList<T>();

		for(T tObj : t)
			resultList.add(tObj);

		return resultList;
	}

	public static void main(String[] args) {
		GenericMethod gm = new GenericMethod();
		List<String> strList = gm.getList("ABC", "DEF", "GHI", "JKL");
		System.out.println("String List :- "+strList);
	}
}
