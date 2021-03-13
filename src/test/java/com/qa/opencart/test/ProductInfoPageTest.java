package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constant;

public class ProductInfoPageTest extends BaseTest{
	
	@BeforeClass
	
	public void productInfoSetup(){
		accPage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test
	public void productInfoTest(){
		searchResultPage=accPage.doSearch("MacBook Pro");
		productInfoPage=searchResultPage.selectProductFromResults("MacBook Pro");
		String headertext=productInfoPage.getProductHeaderText();
		Assert.assertEquals(headertext, Constant.PRODUCT_HEADER_TEXT);
		
	}
	
	@Test
	
	public void quantityTest(){
		productInfoPage.selectQuantity("5");
		productInfoPage.doAddtoCart();
		
	}
	
}
