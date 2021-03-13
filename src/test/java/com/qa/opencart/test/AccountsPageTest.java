package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.Error;

public class AccountsPageTest extends BaseTest{
	
	SoftAssert softAssert=new SoftAssert();
	
	@BeforeClass
	
	public void AccSetUp(){
		accPage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void accPageTitletest (){
		String title=accPage.getAccountPageTitle();
		System.out.println("Home page title is:" + title);
		Assert.assertEquals(title, Constant.ACCOUNT_PAGE_TITLE );
		}
	
    @Test (priority=2)
    public void accPageLogoTest(){
    	Assert.assertTrue(accPage.isLogoExist(), Error.LOGO_NOT_AVALIABLE_ERROR);
    	
    	}
	
    @Test (priority=3)
    public void accPageSectionCountTest(){
    	Assert.assertEquals(accPage.getAccountsPageHeaderCount(), Constant.ACCOUNT_PAGE_COUNT, Error.ACCOUNT_PAGE_SECTION_ERROR);
    }
    
    @Test (priority=4)
    public void accPageSectionsTest(){
    	List <String> actualAccSecList= accPage.getAccountsPageHeaderList();
    	System.out.println(actualAccSecList);
    	
    }
    
    @Test (priority=5)
    public void search(){
    	searchResultPage=accPage.doSearch("macbook");
    	Assert.assertTrue(searchResultPage.getProductResultsCount()>0, Error.SEARCH_NOT_SUCCESSFUL);
    	
    }
    
    @Test(priority=6)
    
    public void selectProductTest(){
    	searchResultPage=accPage.doSearch("macbook");
    	productInfoPage=searchResultPage.selectProductFromResults("MacBook Pro");
    	String actualHeader=productInfoPage.getProductHeaderText();
    	softAssert.assertEquals(actualHeader, "MacBook Pro",Error.PRODUCT_HEADER_NOT_FOUND);
    	softAssert.assertEquals(productInfoPage.getProductimagesCount(), Constant.PRODUCT_IMAGES_COUNT_MACBOOK);
    	softAssert.assertAll();
    }
    
   

}
