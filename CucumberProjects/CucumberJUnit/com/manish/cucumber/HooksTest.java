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
        
        format = { "pretty", "html:output/" },
        snippets = SnippetType.CAMELCASE,
        features = "resources/cucumber-test/hooks.feature"
)
public class HooksTest {
    
}
