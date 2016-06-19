package com.manish.cucumber;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;
/**
 * Unit test for simple App.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        snippets = SnippetType.CAMELCASE,
        features = "classpath:cucumber-test/first.feature"
)
public class CucumberTest {
    
}
