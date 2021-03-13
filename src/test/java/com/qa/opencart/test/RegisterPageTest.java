package com.qa.opencart.test;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.Error;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	
	
	@BeforeClass
	public void setupRegister() {
		registerpage = loginpage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
		Object data[][] = ExcelUtil.getTestData(Constant.REGISTER_SHEET_NAME);
		return data;
	}
	
	
//	public String getRandomNumber() {
//		Random randomGenerator = new Random();
//		String email = "testautomation" + randomGenerator.nextInt(1000) + "@gmail.com";
//		return email;
//	}
	
	@Test(dataProvider = "getRegisterData")
	public void userRegisterTest(String firstName, String lastName, String telephone
			, String password, String subscribe) {
		
		
	}
	
	

}