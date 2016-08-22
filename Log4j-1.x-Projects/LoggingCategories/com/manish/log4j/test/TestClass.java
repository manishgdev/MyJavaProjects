package com.manish.log4j.test;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class TestClass {
	
	Logger log = Logger.getLogger("Test-Logger");
	
	public TestClass() {
		log.setLevel(Level.DEBUG);
	}
	
	public void printLogs() {
		log.trace("This is Trace message in TestClass");
		log.debug("This is Debug message in TestClass");
		log.info("This is Info message in TestClass");
		log.warn("This is Warning message in TestClass");
		log.error("This is Error message in TestClass");
		log.fatal("This is Fatal message in TestClass");
	}
}
