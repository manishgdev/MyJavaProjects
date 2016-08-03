package com.manish.ertest;

import org.testng.annotations.*;
import com.manish.base.Student;
import org.testng.Assert;

public class StudentMarksTest {
	
	@Test
	public void studentTrueMarks() {
		Student st = new Student();
		st.setMarks(60);
		System.out.println("Run Student Test for True Marks");
		Assert.assertEquals(st.getMarks(), 60, "Marks not equal :-");
	}
	
	@Test
	public void studentGraceTrueMarks() {
		Student st = new Student();
		st.setMarks(60);
		System.out.println("Run Student Test for True Marks with Grace");
		Assert.assertEquals(st.getMarks() + 10, 70, "Marks not equal :-");
	}
	
	@Test
	public void studentFalseMarks() {
		Student st = new Student();
		st.setMarks(60);
		System.out.println("Run Student Test for False Marks");
		Assert.assertEquals(st.getMarks(), st.fixMarks(), "Marks not equal :-");
	}
}
