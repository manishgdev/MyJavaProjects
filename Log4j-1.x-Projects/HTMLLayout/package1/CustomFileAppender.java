package package1;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;


public class CustomFileAppender extends FileAppender {

	@Override
	public void setFile(String file) {
		if (fileName.indexOf("%timestamp") >= 0) {
            Date d = new Date();
            SimpleDateFormat format = new SimpleDateFormat("_yyyy-MM-dd-HH-mm-ss-SS");
            fileName = fileName.replaceAll("%timestamp", format.format(d));
        }
        super.setFile(fileName);
		super.setFile(file);
	}
}
