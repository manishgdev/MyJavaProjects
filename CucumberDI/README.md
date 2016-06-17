### This project is created to understand basic Dependeny Injection in Cucumber

1. For Dependency Injection in Cucumber Projects the Library **cucumber-picocontainer-xxx.jar** needs to be used otherwise below exception will be raised by the application
	`cucumber.runtime.CucumberException: class demo.AccountSteps doesn't have an empty constructor. If you need DI, put cucumber-picocontainer on the classpath` 
2. After adding the **Cucumber Picocontainer** library also below error is raised :-
	`Exception in thread "main" java.lang.NoClassDefFoundError: org/picocontainer/PicoBuilder`
	- Which is resolved by Adding **picocontainer-xxx.jar**

