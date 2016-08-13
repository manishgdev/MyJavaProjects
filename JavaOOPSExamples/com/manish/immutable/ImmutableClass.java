package com.manish.immutable;

import java.util.Date;

public final class ImmutableClass {

	private final String name;
	private final Integer age;
	private final Date dob;

	public ImmutableClass(String name, Integer age, Date dob) {
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
