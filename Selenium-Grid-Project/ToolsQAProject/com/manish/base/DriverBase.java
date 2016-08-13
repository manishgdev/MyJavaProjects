package com.manish.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class DriverBase {
	public WebDriver driver;
	
	public WebElement getElement(By by) {
		//System.out.println("Driver == null :- "+(driver == null));
		try {
			return driver.findElement(by);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public WebElement getElement(WebElement element, By by) {
		try {
			return element.findElement(by);
		}
		catch(Exception ex) {
			return null;
		}
	}
}
