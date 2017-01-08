import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObjectByReflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String driverPath = "/home/manish/Downloads/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		
		
		driver.manage().window().maximize();
		
		
//		driver.navigate().to("www.google.com");
		driver.get("http://store.demoqa.com/");
		
		String locator = "xpath=//li[@id='menu-item-72']/a";
		System.out.println("Locator Type = "+locator.split("=")[0]);
		System.out.println("Locator Value = "+locator.split("=")[1]);
		String[] locatorValArr = locator.split("=");
		
		String locatorType = locatorValArr[0];
		String locatorValue = "";
		for(int i = 1; i < locatorValArr.length; i++)
			locatorValue += locatorValArr[i]+"=";
		locatorValue = locatorValue.replaceAll("\\=$", "");
		
		System.out.println("Locator Value after Loop = "+locatorValue);
		
		Class<By> byClass = (Class<By>) Class.forName(By.class.getName());
        Method getMethodBy = byClass.getMethod(locatorType, String.class);
        System.out.println("Bymethod created :- "+getMethodBy);
        By newById = (By) getMethodBy.invoke(null, locatorValue);
        System.out.println("By Object created");
        driver.findElement(newById).click();
		try {
			Thread.sleep(5000);
		}
		catch(Exception ex){}
		System.out.println("Exiting from the Webdriver");
		driver.close();
	}
}
