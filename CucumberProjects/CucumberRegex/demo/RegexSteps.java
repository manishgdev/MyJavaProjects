package demo;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import org.junit.*;

public class RegexSteps {
	@Given("^(\\w+)?active update message is received for (\\D+)(?: (\\d))? (\\D+) (\\d+)$")
	public void matchAllStepsInFeature(String optionalInactive, String someWord, Integer optionalInt, String someOtherWord, int id) {
		System.out.println("Optional Inactive = '"+optionalInactive+"'\nSome Word = '"+someWord+"'\nOptional Int = '"+optionalInt+"'\nSome Other Word = '"+someOtherWord+"'\n Id = '"+id+"'");
	}
}
