package com.manish.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.manish.base.DriverBase;

import java.util.List;
import java.util.ArrayList;

public class AppProductListPage extends DriverBase {
	
	WebDriver driver;
	
	public AppProductListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement element() {
		By by = By.cssSelector("div#container>div#content");
		super.driver = driver;
		return getElement(by);
	}
	
	private WebElement getViewChangeElement() {
		WebElement element = element();
		By viewBy = By.xpath(".//div[contains(@class,'product_views')]/div[@class='wrap']");
		return getElement(element, viewBy);
	}
	
	public void changeViewTo(String viewName) {
		WebElement changeViewElement = getViewChangeElement();
		By by = null;
		if(viewName.equals("Grid")) {
			by = By.xpath(".//a[@title='Grid View']");
		}
		else if(viewName.equals("List")) {
			by = By.xpath(".//a[@title='Default View']");
		}
		WebElement viewElement = getElement(changeViewElement, by);
		viewElement.click();
	}
	
	public String getViewName() {
		By by = By.xpath(".//a[contains(@class,'active')]");
		WebElement changeViewElement = getViewChangeElement();
		WebElement activeElement = getElement(changeViewElement, by);
		String title = activeElement.getAttribute("title");
		String viewName = "";
		if(title.trim().equals("Grid View")) {
			viewName = "Grid";
		}
		else if(title.trim().equals("Default View")) {
			viewName = "List";
		}
		return viewName;
	}
	
	public String getCategoryTitle() {
		WebElement element = element();
		By by = By.cssSelector("header.page-header");
		return getElement(element, by).getText();
	}
	
	private List<WebElement> getProductElementList() {
		WebElement element = element();
		String viewName = getViewName();
		By by = null;
		if(viewName.equals("Grid")) {
			by = By.xpath(".//div[contains(@class,'product_grid_display')]/div[contains(@class,'product_grid_item')]");
		}
		else if(viewName.equals("List")) {
			 by = By.xpath(".//div[contains(@class,'accessories')]");
		}
		
		return element.findElements(by);
	}
	
	public int getProductsCounts() {
		return getProductElementList().size();
	}
	
	private WebElement getProductElement(String itemName) {
		WebElement element = element();
		String viewName = getViewName();
		By by = null;
		if(viewName.equals("Grid"))
			by = By.xpath(".//div[contains(@class,'product_grid_item') and child::div[@class='grid_product_info' and child::h2[@class='prodtitle' and contains(.,'"+itemName+"')]]]");
		else if(viewName.equals("List"))
			by = By.xpath(".//div[contains(@class,'accessories') and descendant::div[@class='productcol' and child::h2[@class='prodtitle' and contains(.,'"+itemName+"')]]]");
		
		return getElement(element, by);
	}
	
	public void addToCart(String itemName) {
		WebElement element = getProductElement(itemName);
		By by = By.xpath(".//input[@value='Add To Cart']");
		getElement(element,by).click();
	}
}
