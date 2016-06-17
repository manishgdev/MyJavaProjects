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

/** 
 * This class is to perform test on amount present in the Bank 
 * Perform check on the Amount dispensed from the Teller Machine
 * Finally Perform check on the Amount left in the Bank
 */ 
public class BankTeller {
	
	KnowsMyAccount helper;
	
	public BankTeller() {
		helper = new KnowsMyAccount();
	}
	
	// @Given("^There is (\\$\\d+\\.\\d+) in my account$")
	public void there_is_$_in_my_account(@Transform(MoneyConverter.class) Money amount) throws Throwable {
		helper.getMyAccount().deposit(amount);
	}

	// @When("^I withdraw \\$(\\d+) from the Teller Machine$")
	public void i_withdraw_$_from_the_Teller_Machine(int dollars) throws Throwable {
		helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
		System.out.println("Amount Left in the Bank :- "+helper.getMyAccount().getBalance().toString());
	}

	// @Then("^\\$(\\d+) should be dispensed from Teller Machine$")
	public void $_should_be_dispensed_from_Teller_Machine(int dollars) throws Throwable {
		Assert.assertEquals("Incorrect amount dispensed -",dollars, helper.getCashSlot().getContents());
	}
	
	// @Then("^Amount left in the bank should be (\\$\\d+\\.\\d+)$")
	public void amount_left_in_the_bank_should_be_$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
		Assert.assertEquals("Incorrect balance in the Bank -", amount, helper.getMyAccount().getBalance());
	}
}
