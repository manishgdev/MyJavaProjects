package com.manish.ertest;

import org.testng.annotations.*;
import com.manish.base.Animal;
import org.testng.Assert;

public class AnimalLegsTest {
	
	@Test(groups = {"G1", "G2"})
	public void animalTrueLegs() {
		Animal an = new Animal();
		an.setNumLegs(4);
		System.out.println("Run Animal Test for Equal Legs");
		Assert.assertEquals(an.getNumLegs(), 4, "Legs are not equal :-");
	}
	
	@Test(groups = {"G2"})
	public void animalLegsModify() {
		Animal an = new Animal();
		an.setNumLegs(4);
		System.out.println("Run Animal Test for Equal Legs with addition");
		Assert.assertEquals(an.getNumLegs() + 5, 4+5, "Legs are not equal :-");
	}
	
	@Test(groups = {"G2", "G3"})
	public void animalFalseLegs() {
		Animal an = new Animal();
		an.setNumLegs(4);
		System.out.println("Run Animal Test for un-equal Legs");
		Assert.assertEquals(an.getNumLegs() + 5, an.fixLegs(), "Legs are not equal :-");
	}
	
}
