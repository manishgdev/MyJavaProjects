package com.manish.extent;

import java.io.File;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	static ExtentReports extent;
    final static String filePath;
    final static String folderPath;
    
    static {
		folderPath = System.getProperty("user.dir")+File.separator+"extent-reports";
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		filePath = folderPath + File.separator + "Report-" + df.format(new Date()) + ".html";
	}
    
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);
            extent.addSystemInfo("Environment", "Testing Extent Report");
			
			extent.loadConfig(new  File(folderPath + File.separator +".."+ File.separator +"extent-config.xml"));
        }
        
        return extent;
    }
}
