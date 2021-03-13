package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {

	ElementUtil elementUtil;
	private WebDriver driver;

	By searchItemResult = By.cssSelector("div.product-layout div.product-thumb");
	By resultItems = By.cssSelector("div.product-thumb h4 a");

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public int getProductResultsCount() {
		return elementUtil.getElements(searchItemResult).size(); 
	}

	public ProductInfoPage selectProductFromResults(String productName) {

		List<WebElement> resultItemList = elementUtil.getElements(resultItems);
		
		System.out.println("total no of items displayed for " + productName + ":" + resultItemList.size());

		for (WebElement e : resultItemList) {
			System.out.println(e.getText());

			if (e.getText().equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage (driver);

	}}
