package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {
	private WebDriver driver;
	public Properties prop;
    DriverFactory df;
   public LoginPage loginpage;
   public AccountsPage accPage;
   public SearchResultPage searchResultPage ;
   public ProductInfoPage productInfoPage;
   public RegisterPage registerpage;
    
	@BeforeTest
	public void setUp(){
		df= new DriverFactory ();
		prop= df.init_prop();
		driver= df.init_browser(prop);
		loginpage=new LoginPage(driver);
	}
	
	@AfterTest
	
	public void tearDown(){
		driver.quit();
	}

}
