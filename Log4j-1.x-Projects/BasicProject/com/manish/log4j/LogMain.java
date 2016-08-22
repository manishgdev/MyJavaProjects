package com.manish.log4j;

import org.apache.log4j.Logger;

public class LogMain {
	
	static Logger log = Logger.getLogger("myLogger");
	
	public static void main(String[] args) {
		log.trace("This is Trace message");
		log.debug("This is Debug message");
		log.info("This is Info message");
		log.warn("This is Warning message");
		log.error("This is Error message");
		log.fatal("This is Fatal message");
		
	}
	
}
