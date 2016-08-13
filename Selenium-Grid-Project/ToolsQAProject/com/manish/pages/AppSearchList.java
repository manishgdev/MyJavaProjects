package com.manish.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.manish.base.DriverBase;

import java.util.List;
import java.util.ArrayList;

public class AppSearchList extends DriverBase {
	
	WebDriver driver;
	
	public AppSearchList(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement element() {
		By by = By.xpath("//div[@id='grid_view_products_page_container']/div[@class='product_grid_display group']");
		super.driver = driver;
		return getElement(by);
	}
	
	private List<WebElement> getResultELementList() {
		WebElement resultElement = element();
		List<WebElement> resultElementList = new ArrayList<WebElement>();
		resultElementList = resultElement.findElements(By.xpath("./div[contains(@class,'product_grid_item')]"));
		return resultElementList;
	}
	
	public int searchResultCount() {
		return getResultELementList().size();
	}
	
	public List<String> getProductList() {
		List<String> productList = new ArrayList<String>();
		for(WebElement resultElement : getResultELementList()) {
			By by = By.xpath("./div[@class='grid_product_info']/h2[@class='prodtitle']");
			WebElement prodTitleElement = getElement(resultElement, by);
			productList.add(prodTitleElement.getText());
		}
		return productList;
	}
}
