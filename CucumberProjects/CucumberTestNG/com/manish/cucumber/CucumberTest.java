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
        features = "resources/cucumber-test/first.feature"
)
public class CucumberTest extends AbstractTestNGCucumberTests {
    
}
