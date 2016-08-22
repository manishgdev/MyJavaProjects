package package1;
import org.apache.log4j.Logger;

public class LoggerExtend {
	public Logger log=Logger.getLogger(LoggerExtend.class.getClass());
	
	public void printLog(String text) {
		log.info(text);
	}
}
