package package1;
import java.awt.Desktop;

import org.apache.log4j.BasicConfigurator;

import test.TestClassLogging;



public class TestJavaLoggingExec {
//
//	static Logger log=Logger.getLogger(TestJavaLoggingExec.class.getClass());
//	BasicConfigurator.configure(); // basic log4j configuration
//	Logger.getRootLogger().setLevel(Level.INFO);  
//	FileAppender fileAppender = null;
//	try {
//	  fileAppender =
//	      new RollingFileAppender(new PatternLayout("%d{dd-MM-yyyy HH:mm:ss} %C %L %-5p:%m%n"),"file.log"); 
//	  logger.addAppender(fileAppender);  
//	} catch (IOException e) {
//	  e.printStackTrace();
//	}

	
	public static void printLog(String logText) {
		
	}
	
	public static void main(String[] args) throws Exception{
	
		BasicConfigurator.configure();
			
		System.out.println("Reachd Here");
		
		new LoggerExtend().log.debug("Hello this is an debug message");
		new LoggerExtend().log.info("Hello this is an info message");
		new LoggerExtend().log.info("Hello this is an info message");
		new LoggerExtend().log.info("Hello this is an info message");
		new LoggerExtend().log.error("This is Error Message");
		new LoggerExtend().log.info("<b>Desktop Class Supported : </b>"+Desktop.isDesktopSupported());
		
		try
		{
			throw new Exception("Throwing Test Exception");
		}
		catch(Exception e)
		{
			new LoggerExtend().log.error(e);
		}
		
		new TestExtendsLogger().printMessage();
		new TestClassLogging().printMessage();
		
		System.out.println("Program Execution Over");
	}

}
