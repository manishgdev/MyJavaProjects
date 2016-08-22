package com.manish.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;

public class LogMain {
	
	static Logger log = Logger.getLogger("myLogger");
	
	public static void main(String[] args) {
		
		try {
			String filePath = "logs/myLogs.log";
			PatternLayout layout = new PatternLayout("%d{dd/MM/yyyy HH:mm:ss} - %c- %t -%p - %l-%M- %m%n");
			FileAppender appender = new FileAppender(layout, filePath);
			appender.setAppend(false);
			appender.activateOptions();
			 
			Logger.getRootLogger().addAppender(appender);
			log.setLevel(Level.DEBUG);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		log.trace("This is Trace message");
		log.debug("This is Debug message");
		log.info("This is Info message");
		log.warn("This is Warning message");
		log.error("This is Error message");
		log.fatal("This is Fatal message");
		
	}
	
}
