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

public class AccountSteps {
	
	KnowsMyAccount helper;
	
	public AccountSteps(KnowsMyAccount helper) {
		this.helper = helper;
	}
	
	@Given("^There is (\\$\\d+\\.\\d+) in my account$")
	public void there_is_$_in_my_account(@Transform(MoneyConverter.class) Money amount) throws Throwable {
		helper.getMyAccount().deposit(amount);
	}
}
