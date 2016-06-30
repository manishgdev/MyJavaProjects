## Execute Tests parallely in TestNG

1. **parallel="methods"**: TestNG will run all your test methods in separate threads. Dependent methods will also run in separate threads but they will respect the order that you specified.

2. **parallel="tests"**: TestNG will run all the methods in the same <test> tag in the same thread, but each <test> tag will be in a separate thread. This allows you to group all your classes that are not thread safe in the same <test> and guarantee they will all run in the same thread while taking advantage of TestNG using as many threads as possible to run your tests.

3. **parallel="classes"**: TestNG will run all the methods in the same class in the same thread, but each class will be run in a separate thread.

4. **parallel="instances"**: TestNG will run all the methods in the same instance in the same thread, but two methods on two different instances will be running in different threads.

Reference :- <br/>
[TestNG Parallel Documentation](http://testng.org/doc/documentation-main.html#parallel-running)
