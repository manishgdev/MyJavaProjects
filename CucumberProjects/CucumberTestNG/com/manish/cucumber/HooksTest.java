package com.manish.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.SnippetType;
/**
 * Unit test for simple App.
 */

@CucumberOptions(
        
        format = { "pretty", "html:output/" },
        snippets = SnippetType.CAMELCASE,
        features = "resources/cucumber-test/hooks.feature"
)
public class HooksTest extends AbstractTestNGCucumberTests {
    
}
