##Hooks & Dependency Injection in Cucumber

####Dependency Injection
1. Create Constructor of StepDefinition class with the Object of Helper class which is to be used for Dependency Injection
	```
	public class StepDefn {
		private HelperClass helper;
		public StepDefn(HelperClass helperObj) {
			helper = helperObj;
		}
	}
	```

2. Dependency Injection works with the PicoContainer
	- **picocontainer** and **cucumber-picocontainer** are to be made available in classpath

####Hooks in Cucumber
1. The After and Before tag in Cucumber will get executed by default for every Scenarios in the Feature File
2. For the Tagged Scenarios the tagged After and Before methods will be executed
3. For **OR** tags Before('@cucumis, @sativus') - Run for Scenarios with @cucumis or @sativus
4. For **AND** tags Before('@cucumis', '@sativus') - Run for Scenario with @cucumis and @sativus
5. For Excluding a tag **~** can be used 
6. Complex **OR** and **AND** tagging : Before('@cucumis, @sativus', '@aqua')
7. Object of Scenario can be used as parameter to the After Method to get information of the Scenario :-<br/>
	```
	@After
	public void afterAnnotation(Scenario scenario) {
		// Method body here
	}
	```
