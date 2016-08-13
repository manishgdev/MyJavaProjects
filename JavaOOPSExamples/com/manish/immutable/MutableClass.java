package com.manish.immutable;

import java.util.Date;

public class MutableClass {

	private String name;
	private Integer age;
	private Date dob;

	public MutableClass(String name, Integer age, Date dob) {
		this.name = name;
		this.age = age;
		this.dob = new Date(dob.getTime());
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Date getDob() {
		return dob;
	}

}
