package com.manish.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.manish.base.DriverBase;

import java.util.List;
import java.util.ArrayList;

public class AppPopUp extends DriverBase {
	
	WebDriver driver;
	
	public AppPopUp(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement element() {
		By by = By.cssSelector("div#fancy_notification_content");
		super.driver = driver;
		return getElement(by);
	}
	
	public boolean isPresent() {
		WebElement element = element();
		if(element == null)
			return false;
		else if(element.isDisplayed()) 
			return true;
		else
			return false;
	}
	
	public String getMessage() {
		doShortWait();
		if(isPresent()) {
			WebElement element = element();
			By by = By.cssSelector("div#fancy_notification_content>span");
			return getElement(by).getText();
		}
		else
			return "";
	}
	
	public void click(String buttonName) {
		doShortWait();
		if(isPresent()) {
			WebElement element = element();
			//System.out.println("Inside click on Button Name : Element == null :- "+element);
			By by = By.xpath(".//a[text()='"+buttonName+"']");
			getElement(element, by).click();
			//System.out.println("Clicked on element");
		}
		else
			throw new RuntimeException("Popup not present on the Screen");
	}
	
	private void doShortWait() {
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			
		}
	}
}
