package demo;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.Delimiter;
import org.junit.*;
import java.util.List;
import java.util.ArrayList;
import transforms.NumberTransformer;

public class DelimiterSteps {
	@Given("^the following animals: (.*)$")
	public void theFollowingAnimals(List<String> animals) {
		System.out.println(animals);
	}
	
	@Given("^the following animals seperated by Hash: (.*)$")
	public void theFollowingAnimalsSeperatedByHash(@Delimiter("# ") List<String> animals) {
		System.out.println(animals);
	}
	
	@Given("^I have these Numbers (\\d+(?:, \\d+)*)$")
	public void getListOfBD(@Delimiter(", ") List<Integer> values) throws Throwable {
		System.out.println("List of Numbers : "+values);
	}
	
	@Given("^I have these Numbers in List (\\d+(?:, \\d+)*)$")
	public void getListOfBDTransformer(@Transform(NumberTransformer.class) @Delimiter(", ") List<Integer> values) throws Throwable {
		System.out.println("List of Numbers : "+values);
	}
}
