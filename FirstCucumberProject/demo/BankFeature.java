package demo;
import cucumber.api.java.en.*;
import cucumber.api.PendingException;

public class BankFeature {
    
    @Given("^I have deposited \\$(\\d+) in my account$")
    public void i_have_deposited_$_in_my_account(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I request \\$(\\d+)$")
    public void i_request_$(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}