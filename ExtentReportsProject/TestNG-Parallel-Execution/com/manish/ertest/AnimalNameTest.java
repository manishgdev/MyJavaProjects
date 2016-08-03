package com.manish.ertest;

import org.testng.annotations.*;
import com.manish.base.Animal;
import org.testng.Assert;

public class AnimalNameTest {
	
	@Test
	public void animalTrueName() {
		Animal an = new Animal();
		an.setNumLegs(4);
		System.out.println("Run Animal Test for true Animal Name");
		Assert.assertEquals(an.getName(), "Lion", "Names are not equal :-");
	}
	
	@Test
	public void animalNameModify() {
		Animal an = new Animal();
		an.setName("Lion");
		System.out.println("Run Animal Test for true Animal Name with addition");
		Assert.assertEquals(an.getName() + " ", "Lion ", "Names are not equal :-");
	}
}
