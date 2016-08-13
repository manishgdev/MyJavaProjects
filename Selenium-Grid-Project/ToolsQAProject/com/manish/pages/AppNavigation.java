package com.manish.pages;

import org.openqa.selenium.WebElement;
import com.manish.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

public class AppNavigation extends DriverBase {

	WebDriver driver;
	
	public AppNavigation(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement element() {
		super.driver = driver;
		By by = By.id("main-nav");
		return getElement(by);
	}
	
	public void navigateTo(String primaryMenu) {
		WebElement navElement = element();
		By by = By.xpath(".//a[contains(text(),'"+primaryMenu+"')]");
		WebElement primaryElement = getElement(navElement, by);
		primaryElement.click();
	}
	
	public void navigateTo(String primaryMenu, String secondaryMenu) {
		WebElement navElement = element();
		By by = By.xpath(".//a[contains(text(),'"+primaryMenu+"')]");
		WebElement primaryElement = getElement(navElement, by);
		
		By secondaryBy = By.xpath("./following-sibling::ul[@class='sub-menu']/li[contains(.,'"+secondaryMenu+"')]");
		Actions action = new Actions(driver);
		Action builder = action.moveToElement(primaryElement).click(getElement(primaryElement, secondaryBy)).build();
		builder.perform();
		
		// WebElement secondaryElement = getElement(primaryElement, secondaryBy);
		// secondaryElement.click();
	}
	
	public void searchProduct(String productName) {
		//System.out.println("Inside Search Product Function");
		WebElement searchElement = getSearchElement();
		searchElement.sendKeys(productName + Keys.ENTER);
	}
	
	private WebElement getSearchElement() {
		By by = By.xpath(".//form/fieldset/input[@type='text']");
		WebElement navElement = element();
		//System.out.println("Returning Search Element for the Navigation :- "+navElement);
		return getElement(navElement, by);
	}
}
