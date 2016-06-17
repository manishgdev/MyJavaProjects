package demo;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import org.junit.*;
import transforms.MoneyConverter;
import support.Money;
import support.Account;

public class BankFeature {
    Account myAccount; 
    
    @Given("^The opening balance of my account is (\\$\\d+\\.\\d+)$")
    public void the_opening_balance_of_my_account_is_$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        myAccount = new Account(amount);
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void i_have_deposited_$_in_my_account(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        if(myAccount == null)
            myAccount = new Account();
        myAccount.deposit(amount);
    }

    @When("^I withdraw (\\$\\d+\\.\\d+) from my account$")
    public void i_withdraw_$_from_my_account(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        myAccount.withdraw(amount);
    }

    @Then("^The balance should be (\\$\\d+\\.\\d+)$")
    public void the_balance_should_be_$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        System.out.println("Balance in Balance Function = "+myAccount.getBalance().toString());
        Assert.assertEquals("Incorrect account balance -", amount, myAccount.getBalance());
    }
}
