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

public class BalanceSteps {
	
	KnowsMyAccount helper;
	
	public BalanceSteps(KnowsMyAccount helper) {
		this.helper = helper;
	}
	
	@Then("^Amount left in the bank should be (\\$\\d+\\.\\d+)$")
	public void amount_left_in_the_bank_should_be_$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
		Assert.assertEquals("Incorrect balance in the Bank -", amount, helper.getMyAccount().getBalance());
	}
}
