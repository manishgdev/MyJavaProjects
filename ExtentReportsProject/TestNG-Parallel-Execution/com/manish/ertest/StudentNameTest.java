package com.manish.ertest;

import org.testng.annotations.*;
import com.manish.base.Student;
import org.testng.Assert;

public class StudentNameTest {
	
	@Test
	public void studentTrueName() {
		Student st = new Student();
		st.setName("Manish");
		System.out.println("Run Student Test for true Student Name");
		Assert.assertEquals(st.getName(), "Manish", "Names are not equal :-");
	}
	
	@Test
	public void studentFalseName() {
		Student st = new Student();
		st.setName("Manish");
		System.out.println("Run Student Test for false Student Name");
		Assert.assertEquals(st.getName(), st.falseName(), "Names are not equal :-");
	}
	
	@Test
	public void studentHardFalse() {
		Student st = new Student();
		st.setName("Manish");
		System.out.println("Run Student Test for hard coded false Student Name");
		Assert.assertEquals(st.getName(), "Rahul", "Names are not equal :-");
	}
	
	@Test
	public void studentHardTrue() {
		Student st = new Student();
		st.setName("Manish");
		System.out.println("Run Student Test for Student Name with Modification");
		Assert.assertEquals(st.getName()+" ", "Manish ", "Names are not equal :-");
	}
}
