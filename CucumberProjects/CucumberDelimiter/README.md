### This project is created to understand how Delimiters can be used in Cucumber Step Definition


1. The simplest way to pass a List of String<br/>
	```Given the following animals: cow, horse, sheep```
<br/>
To access the above step as List<String> in Step definition class<br/>

	```
	
	@Given("the following animals: (.*)")
	public void the_following_animals(List<String> animals) {
		//Method body goes here
	}
	```

    	
2. Use Delimiter in Conjunction with Transform (this example was seen in second reference, which is not working and seems to be wrong implementation of Transpose)<br/>

	```
	
	public void getListOfBD(@Delimiter(", ") @Transform(LongTransformer.class) List<Long> values) throws Throwable {
		for(Long value : values) {
			System.out.println(value);
		}
	}
	
	```

<br/>
References :- <br/>
1. [Cucumber-JVM Docs](https://cucumber.io/docs/reference/jvm#java) <br/>
2. [Google Group Discussion](https://groups.google.com/forum/#!topic/cukes/hBOSjFZE7To) - Failing `java.lang.NumberFormatException: For input string: "1, 3, 5, 7, 11"`

