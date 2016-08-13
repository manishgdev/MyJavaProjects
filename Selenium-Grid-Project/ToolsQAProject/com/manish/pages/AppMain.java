package com.manish.pages;

import com.manish.base.DriverBase;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import com.google.common.base.Function;
import java.util.concurrent .TimeUnit;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AppMain extends DriverBase {
	
	public AppNavigation nav;
	public AppSearchList search;
	public AppProductListPage productList;
	public AppPopUp popup;
	public AppCartPage cart;
	public AppProductDetail prodDetail = new AppProductDetail();
	
	public AppMain(String browser) throws MalformedURLException, InterruptedException {
		if(browser.equals("ff")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"lib"+File.separator+"chromedriver");
			String driverPath = "/home/manish/Downloads/chromedriver";
			System.setProperty("webdriver.chrome.driver", driverPath);
			WebDriver driver = new ChromeDriver();
		}
		else if(browser.equals("remote-ff")) {
			DesiredCapabilities capability=null;
			capability= DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(org.openqa.selenium.Platform.ANY);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		}
		// Initialize components with the driver of this class
		nav = new AppNavigation(driver);
		search = new AppSearchList(driver);
		productList = new AppProductListPage(driver);
		popup = new AppPopUp(driver);
		cart = new AppCartPage(driver);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void openPage(String url) {
		driver.get(url);
	}
	
	public void close() {
		driver.close();
		try {
			if(driver != null)
				driver.quit();
		}
		catch(Exception ex) {
			System.out.println("Driver is already Closed");
			ex.printStackTrace();
		}
	}
	
	public void checkOut() {
		By by = By.cssSelector("a[title=Checkout]");
		WebElement element = getElement(by);
		element.click();
	}
	
	public Integer getCartItemCount() {
		By by = By.cssSelector("a[title=Checkout]>em.count");
		WebElement element = getElement(by);
		return Integer.parseInt(element.getText());
	}
	
	public void  waitForPopup() {
		// System.out.println("Inside Wait for popup ; Driver == null :- "+(driver == null));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.pollingEvery(250, TimeUnit.MILLISECONDS)
								.withTimeout(6, TimeUnit.SECONDS)
								.ignoring(NoSuchElementException.class);
			
		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
													public Boolean apply(WebDriver driver) {
														By by = By.cssSelector("div.popup");
														WebElement element = driver.findElement(by);
														if(element != null) {
															by = By.cssSelector("div#fancy_notification_content>a.continue_shopping");
															WebElement msgElement = driver.findElement(by);
															if(msgElement != null)
																if(msgElement.isDisplayed())
																	return true;
															return false;
														}
														return false;
													}
												};
		
		wait.until(function);
	}
	
	public void takeScreenShot() throws IOException {
		DateFormat df = new SimpleDateFormat("dd-mm-yyy-hh-mm-ss");
		String fileName = "Remote_Screentshot-"+df.format(new Date()) +".png";
		String folder = "/home/manish/Documents/webdriver_screenshots/";
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(folder+fileName));
	}
}
