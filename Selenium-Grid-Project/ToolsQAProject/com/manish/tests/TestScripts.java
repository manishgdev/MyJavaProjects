package com.manish.tests;

import com.manish.pages.AppMain;
import java.net.MalformedURLException;
import com.manish.base.DriverBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.Assert;
import java.lang.reflect.Method;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class TestScripts {
	AppMain app;
	String siteUrl = "http://store.demoqa.com/";
	
	@BeforeMethod
	public void beforeMethod(Method m, ITestContext context) throws MalformedURLException, InterruptedException  {
		System.out.println("Inside before Method to Initialize WebDriver");
		app = new AppMain("remote-ff");
		
	}
	
	@AfterMethod
	public void AfterMethod(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("Test Passed");
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Test Failed");	
			System.out.println(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			System.out.println("Test Skipped");	
		}
		app.takeScreenShot();
		app.close();
	}
	
	//@Test
	public void checkSiteTitle() {
		app.openPage(siteUrl);
		String pageTitle = app.getTitle();
		Assert.assertEquals(pageTitle, "ONLINE STORE | Toolsqa Dummy Test site", "Page Title is not equal");
		app.nav.searchProduct("iphone");
	}
	
	//@Test
	public void checkSearchResultCount() {
		app.openPage(siteUrl);
		String pageTitle = app.getTitle();
		app.nav.searchProduct("iphone");
		int resultCount = app.search.searchResultCount();
		Assert.assertEquals(resultCount, 4, "Search Result Counts are not matching :- ");
	}
	
	//@Test
	public void checkSearchResultItems() {
		app.openPage(siteUrl);
		String pageTitle = app.getTitle();
		app.nav.searchProduct("iphone");
		List<String> searchResultList = app.search.getProductList();
		for(String searchResult : searchResultList)
			Assert.assertEquals(searchResult.toLowerCase().contains("iphone"),true, "Item '"+searchResult+"' in the Result List :- "+searchResultList+" should contain 'iphone' in title :- ");
	}
	
	//@Test
	public void checkProductCategoryTitle() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		String categoryTitle = app.productList.getCategoryTitle();
		Assert.assertEquals(categoryTitle, "Accessories", "Category title not matching :- ");
	}
	
	//@Test
	public void checkProductCategoryDefaultView() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		String viewName = app.productList.getViewName();
		Assert.assertEquals(viewName, "List", "View name not matching :- ");
	}
	
	//@Test
	public void checkProductCategoryChangeToGrid() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		app.productList.changeViewTo("Grid");
		String viewName = app.productList.getViewName();
		Assert.assertEquals(viewName, "Grid", "View name not matching :- ");
	}
	
	//@Test
	public void checkProductCountDefaultView() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		int productCount = app.productList.getProductsCounts();
		Assert.assertEquals(productCount, 6, "Product Count not matching :- ");
	}
	
	//@Test
	public void checkProductCountGridView() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		app.productList.changeViewTo("Grid");
		int productCount = app.productList.getProductsCounts();
		Assert.assertEquals(productCount, 6, "Product Count not matching :- ");
	}
	
	//@Test
	public void checkPopUpOnAddToCart() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		app.productList.addToCart("Apple TV");
		Assert.assertEquals(app.popup.isPresent(), true, "Popup should be displayed after clicking Add To Cart :- ");
	}
	
	//@Test
	public void checkPopUpOnAddToCartInGridView() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		app.productList.changeViewTo("Grid");
		app.productList.addToCart("Apple TV");
		Assert.assertEquals(app.popup.isPresent(), true, "Popup should be displayed after clicking Add To Cart :- ");
	}
	
	//@Test
	public void checkMessageAfterAddToCart() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		String prodName = "Apple TV";
		app.productList.addToCart(prodName);
		String message = "You just added \""+prodName+"\" to your cart.";
		Assert.assertEquals(app.popup.getMessage(), message, "Message in popup should be equal :- ");
	}
	
	//@Test
	public void checkMessageAfterAddToCartGridView() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		String prodName = "Apple TV";
		app.productList.changeViewTo("Grid");
		app.productList.addToCart(prodName);
		String message = "You just added \""+prodName+"\" to your cart.";
		Assert.assertEquals(app.popup.getMessage(), message, "Message in popup should be equal :- ");
	}
	
	//@Test
	public void checkItemCountAfterAddToCart() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		Integer count = 0;
		Assert.assertEquals(app.getCartItemCount(), count, "Count for Items in cart should match :- ");
		String prodName = "Apple TV";
		app.productList.addToCart(prodName);
		count++;
		app.waitForPopup();
		app.popup.click("Continue Shopping");
		Assert.assertEquals(app.getCartItemCount(), count, "Count for Items in cart should match :- ");
		
		prodName = "Magic Mouse";
		app.productList.addToCart(prodName);
		count++;
		app.waitForPopup();
		app.popup.click("Continue Shopping");
		Assert.assertEquals(app.getCartItemCount(), count, "Count for Items in cart should match :- ");
	}
	
	//@Test
	public void checkItemCountAfterAddToCartGridView() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		Integer count = 0;
		Assert.assertEquals(app.getCartItemCount(), count, "Count for Items in cart should match :- ");
		app.productList.changeViewTo("Grid");
		String prodName = "Apple TV";
		app.productList.addToCart(prodName);
		count++;
		app.waitForPopup();
		app.popup.click("Continue Shopping");
		Assert.assertEquals(app.getCartItemCount(), count, "Count for Items in cart should match :- ");
		
		prodName = "Magic Mouse";
		app.productList.addToCart(prodName);
		count++;
		app.waitForPopup();
		app.popup.click("Continue Shopping");
		Assert.assertEquals(app.getCartItemCount(), count, "Count for Items in cart should match :- ");
	}
	
	//@Test
	public void checkCartPageHeader() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		Integer count = 0;
		String prodName = "Apple TV";
		app.productList.addToCart(prodName);
		app.waitForPopup();
		app.popup.click("Go to Checkout");
		String header = app.cart.getHeader();
		Assert.assertEquals(header, "Checkout", "Cart page header should match :- ");
	}
	
	//@Test
	public void checkCartPageHeaderFromGridList() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		String prodName = "Apple TV";
		app.productList.changeViewTo("Grid");
		app.productList.addToCart(prodName);
		app.waitForPopup();
		app.popup.click("Go to Checkout");
		String header = app.cart.getHeader();
		Assert.assertEquals(header, "Checkout", "Cart page header should match :- ");
	}
	
	//@Test
	public void checkItemCountCartPage() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		String prodName = "Apple TV";
		int count = 0;
		app.productList.addToCart(prodName);
		count++;
		app.waitForPopup();
		app.popup.click("Continue Shopping");
		prodName = "Magic Mouse";
		app.productList.addToCart(prodName);
		count++;
		app.waitForPopup();
		app.popup.click("Go to Checkout");
		int itemCount = app.cart.getItemCount();
		Assert.assertEquals(itemCount, count, "Count of items in the cart should match :- ");
	}
	
	//@Test
	public void checkItemCountCartPageFromGridView() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		String prodName = "Apple TV";
		int count = 0;
		app.productList.addToCart(prodName);
		count++;
		app.waitForPopup();
		app.popup.click("Continue Shopping");
		prodName = "Magic Mouse";
		app.productList.addToCart(prodName);
		count++;
		app.waitForPopup();
		app.popup.click("Go to Checkout");
		int itemCount = app.cart.getItemCount();
		Assert.assertEquals(itemCount, count, "Count of items in the cart should match :- ");
	}
	
	//@Test
	public void checkItemsInCartPage() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		List<String> productList = new ArrayList<String>();
		String prodName = "Apple TV";
		productList.add(prodName);
		app.productList.addToCart(prodName);
		app.waitForPopup();
		app.popup.click("Continue Shopping");
		prodName = "Magic Mouse";
		productList.add(prodName);
		app.productList.addToCart(prodName);
		app.waitForPopup();
		app.popup.click("Go to Checkout");
		List<String> cartItemList = app.cart.getProductsList();
		Assert.assertEquals(cartItemList.size(), productList.size(), "Number of items present in cart should match :- ");
		for(String product : productList)
			Assert.assertEquals(cartItemList.contains(product), true, cartItemList + " should contain '"+product+"' :- ");
	}
	
	//@Test
	public void checkItemsInCartPageFromGridView() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		List<String> productList = new ArrayList<String>();
		String prodName = "Apple TV";
		productList.add(prodName);
		app.productList.changeViewTo("Grid");
		app.productList.addToCart(prodName);
		app.waitForPopup();
		app.popup.click("Continue Shopping");
		prodName = "Magic Mouse";
		productList.add(prodName);
		app.productList.addToCart(prodName);
		app.waitForPopup();
		app.popup.click("Go to Checkout");
		List<String> cartItemList = app.cart.getProductsList();
		Assert.assertEquals(cartItemList.size(), productList.size(), "Number of items present in cart should match :- ");
		for(String product : productList)
			Assert.assertEquals(cartItemList.contains(product), true, cartItemList + " should contain '"+product+"' :- ");
	}
	
	@Test
	public void checkRemoveItemsFromCartPage() {
		app.openPage(siteUrl);
		app.nav.navigateTo("Product Category", "Accessories");
		List<String> productList = new ArrayList<String>();
		String prodName = "Apple TV";
		productList.add(prodName);
		app.productList.addToCart(prodName);
		app.waitForPopup();
		app.popup.click("Continue Shopping");
		
		prodName = "Magic Mouse";
		productList.add(prodName);
		app.productList.addToCart(prodName);
		app.waitForPopup();
		app.popup.click("Continue Shopping");
		
		prodName = "Sennheiser RS 120";
		productList.add(prodName);
		app.productList.addToCart(prodName);
		app.waitForPopup();
		
		app.popup.click("Go to Checkout");
		
		app.cart.removeItem("Magic Mouse");
		productList.remove("Magic Mouse");
		List<String> cartItemList = app.cart.getProductsList();
		Assert.assertEquals(cartItemList.size(), productList.size(), "Number of items present in cart should match :- ");
		for(String product : productList)
			Assert.assertEquals(cartItemList.contains(product), true, cartItemList + " should contain '"+product+"' :- ");
	}
}
