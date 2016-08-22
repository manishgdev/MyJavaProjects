package com.manish.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class ClassA {
	
	Logger log = Logger.getLogger("myLogger");
	
	public ClassA() {
		log.setLevel(Level.INFO);
	}
	
	public void printLogs() {
		log.trace("This is Trace message in ClassA");
		log.debug("This is Debug message in ClassA");
		log.info("This is Info message in ClassA");
		log.warn("This is Warning message in ClassA");
		log.error("This is Error message in ClassA");
		log.fatal("This is Fatal message in ClassA");
	}
}
