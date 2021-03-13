package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constant;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	
	public void loginPageTitleTest(){
		
		String title= loginpage.getLoginPageTitle();
		System.out.println("login page title" + title);
		Assert.assertEquals(title, Constant.LOGIN_PAGE_TITLE);
	}
	
	@Test (priority=2)
	 public void forgotPwdLinkTest(){
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}
	
	@Test (priority=3)
	
	public void loginTest (){
		accPage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccountPageTitle(), Constant.ACCOUNT_PAGE_TITLE);
	}

}
