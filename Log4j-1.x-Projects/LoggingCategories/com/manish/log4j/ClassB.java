package com.manish.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class ClassB {
	
	Logger log = Logger.getLogger("myLogger");
	
	public ClassB() {
		log.setLevel(Level.WARN);
	}
	
	public void printLogs() {
		log.trace("This is Trace message in ClassB");
		log.debug("This is Debug message in ClassB");
		log.info("This is Info message in ClassB");
		log.warn("This is Warning message in ClassB");
		log.error("This is Error message in ClassB");
		log.fatal("This is Fatal message in ClassB");
	}
}
