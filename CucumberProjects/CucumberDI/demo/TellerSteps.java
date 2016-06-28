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

public class TellerSteps {
	
	KnowsMyAccount helper;
	
	public TellerSteps(KnowsMyAccount helper) {
		this.helper = helper;
	}
	
	@When("^I withdraw \\$(\\d+) from the Teller Machine$")
	public void i_withdraw_$_from_the_Teller_Machine(int dollars) throws Throwable {
		helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
		System.out.println("Amount Left in the Bank :- "+helper.getMyAccount().getBalance().toString());
	}
}
