package demo;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import org.junit.*;
import support.Money;
import support.Account;
import support.Teller;
import support.CashSlot;
import helper.KnowsMyAccount;
import transforms.MoneyConverter;

public class CashSlotSteps {
	
	KnowsMyAccount helper;
	
	public CashSlotSteps(KnowsMyAccount helper) {
		this.helper = helper;
	}
	
	@Then("^\\$(\\d+) should be dispensed from Teller Machine$")
	public void $_should_be_dispensed_from_Teller_Machine(int dollars) throws Throwable {
		Assert.assertEquals("Incorrect amount dispensed -",dollars, helper.getCashSlot().getContents());
	}
}
