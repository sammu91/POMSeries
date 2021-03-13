package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	
   ElementUtil elementUtil;
   private WebDriver driver;
	//Page object- By locator or object repository
	
	private By userName=By.id("input-email");
	private By passWord= By.id("input-password");
	private By login= By.xpath("//input[@value='Login']");
	private By forgotPwd=By.xpath("//div[@class='form-group']/a[text()='Forgotten Password']");
	private By registerLink=By.linkText("Register");
	
	//constructor 
	public LoginPage (WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil (driver);
		
	}
	// page actions
	
	public String getLoginPageTitle(){
		return elementUtil.waitForTitleIs(5, Constant.LOGIN_PAGE_TITLE);
	}
	public boolean isForgotPwdLinkExist(){
		return elementUtil.doIsDisplayed(forgotPwd);
	}
	
	public AccountsPage doLogin(String un, String pwd){
		System.out.println("login with:"+ un + ":" + pwd);
		elementUtil.doSendKeys(userName, un);
		elementUtil.doSendKeys(passWord, pwd);
		elementUtil.doClick(login);
		return new AccountsPage(driver);
		
		
	}
	
	public RegisterPage navigateToRegisterPage(){
		elementUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
}
