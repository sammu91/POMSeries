package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	ElementUtil elementUtil;
	private WebDriver driver;
	
	private By productHeader=By.cssSelector("div#content h1");
	private By productimages=By.cssSelector("ul.thumbnails img");
	private By quantity= By.name("quantity");
	private By addToCart=By.xpath("//button[text()='Add to Cart']");
	private By successMesg=By.cssSelector("div.alert");
	
	
	public ProductInfoPage (WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getProductHeaderText(){
		return elementUtil.doGetElementText(productHeader);
	}
	
	public int getProductimagesCount(){
		 return elementUtil.getElements(productimages).size();
	}
	
	public void selectQuantity(String qty){
		elementUtil.doClear(quantity);
		elementUtil.doSendKeys(quantity, qty);
	}
	
	public void doAddtoCart(){
		elementUtil.doClick(addToCart);
	}
	
	public String getSuccessMsg(){
	return	elementUtil.doGetElementText(successMesg);
	}


}
