##EXTENT REPORTS PROJECT

- This project is based on ExtentReports plugin which is used to create HTML reports for automation tests.<br/>
URL :- http://extentreports.relevantcodes.com/
<br/>
References taken from ExtentReports Documentation :- http://extentreports.relevantcodes.com/java/ <br/>

Procedure to create Report :-<br/>
- Create ```ExtentReports``` object <br/>
	```ExtentReports extent = new ExtentReports(file-path, replaceExisting);```
- Create ```ExtentTest``` object using instance of ExtentReports<br/>
	```ExtentTest test = extent.startTest("Test Name", "Sample description");```
- Create the Step log using the **log** method in **test** object
- After the test is completed call the **endTest** method of **extent** object by passing to it the **test** object<br/>
	```extent.endTest(test);``` 

- Call the **flush** method of extent object to write the logs to the file<br/>
	```extent.flush();```
- At the end before closing the test call **close** method to close the output stream created to write the logs

<br/>
Other Capabilities :-
- Assign Test Categories
- Assign Authors of the test
- Adding Child tests to a test
- Insert Custome HTML
- Insert Snapshot and Screencast
- Add System info


<br/>
Differences between close and flush::

- If we fail to end any of our tests safely (by calling endTest), close will still show them in the report with a warning sign. 
- Calling Flush will only write tests to the report once they are ended
- Close does not write SystemInfo to the report (flush does)
- We can call flush any number of times for a report session but close only once, because:
Close closes the underlying stream and destroys the source references so no other Extent commands can be used
