package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By logo=By.cssSelector("#logo");
	private By accHeaders=By.cssSelector("#content h2");
	private By searchField=By.name("search");
	private By searchButton=By.cssSelector("div#search button");
	
	public AccountsPage(WebDriver driver){
		this.driver=driver;
	elementUtil=new ElementUtil(driver);
	}
	
	public String getAccountPageTitle(){
		return elementUtil.waitForTitleIs(5, Constant.ACCOUNT_PAGE_TITLE);
	}
	
	public boolean isLogoExist(){
		return elementUtil.doIsDisplayed(logo);
	}
	
	public int getAccountsPageHeaderCount(){
		return elementUtil.getElements(accHeaders).size();
	}
	
	public List<String> getAccountsPageHeaderList(){
		List<WebElement> accList =elementUtil.getElements(accHeaders);
		List<String> accSectionList= new ArrayList<String>();
		for(WebElement e: accList){
			accSectionList.add(e.getText());
		}
		return accSectionList;
	}
	
	public SearchResultPage doSearch(String productName){
		System.out.println("searching for the product : " + productName );
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchButton);
		return new SearchResultPage (driver);
	
	}
    
}
