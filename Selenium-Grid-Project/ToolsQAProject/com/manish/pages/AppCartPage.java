package com.manish.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.manish.base.DriverBase;

import java.util.List;
import java.util.ArrayList;

public class AppCartPage extends DriverBase {
	WebDriver driver;
	
	public AppCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement element() {
		By by = By.cssSelector("div#content_container>div#container>div#content>article");
		super.driver = driver;
		return getElement(by);
	}
	
	public String getHeader() {
		By by = By.cssSelector("header.page-header>h1");
		WebElement element = element();
		return getElement(element, by).getText();
	}
	
	private List<WebElement> getProductElementList() {
		By by = By.cssSelector("table.checkout_cart>tbody tr.product_row");
		return element().findElements(by);
	}
	
	public List<String> getProductsList() {
		List<String> productList = new ArrayList<String>();
		for(WebElement rowElement : getProductElementList()) { 
			By by = By.cssSelector("td[class^=wpsc_product_name]");
			productList.add(getElement(rowElement, by).getText());
		}
		return productList;
	}
	
	public int getItemCount() {
		return getProductElementList().size();
	}
	
	public void removeItem(String itemName) {
		By by = By.xpath(".//tr[contains(@class,'product_row') and child::td[contains(@class, 'wpsc_product_name') and contains(., '"+itemName+"')]]");
		WebElement productElement = getElement(element(), by);
		By removeBy = By.xpath("./td[contains(@class,'wpsc_product_remove')]//input[@type='submit' and @value='Remove']");
		getElement(productElement, removeBy).click();
	}
}
