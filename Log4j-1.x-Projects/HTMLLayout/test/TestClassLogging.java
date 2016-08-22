package test;

import package1.LoggerExtend;
public class TestClassLogging extends LoggerExtend {

	public void printMessage() {
		log.info("Message From Child Class");
	}

}
