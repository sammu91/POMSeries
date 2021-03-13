package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By firstname=By.id("input-firstname");
	private By lastname=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telephone=By.id("input-telephone");
	private By password=By.id("input-password");
	private By confirmpassword=By.id("input-confirm");
	
	private By subscribeYes=By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo=By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
	private By agreeCheckbox=By.name("agree");
	private By continueButton=By.xpath("//input[@type='submit' and @value='Continue']");
	private By suceesMsg=By.cssSelector("div#content h1");
	
	private By logoutLink= By.linkText("Logout");
	private By registerLink= By.linkText("Register");
	
	
	
	public RegisterPage(WebDriver driver){
		this.driver=driver;
	elementUtil=new ElementUtil(driver);
	}
	
	public boolean accountRegistration(String firstName, String lastName, String email, String telephone, String password,
			String subscribe){
		
		elementUtil.doSendKeys(this.firstname, firstName);
		elementUtil.doSendKeys(this.lastname, lastName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmpassword, password);
		
		if(subscribe.equals("yes")){
			elementUtil.doClick(this.subscribeYes);
		}
		else {
			elementUtil.doClick(this.subscribeNo);
		}
		elementUtil.doClick(this.agreeCheckbox);
		elementUtil.doClick(this.continueButton);
		
		elementUtil.waitForPresenceOfElement(this.suceesMsg, 5);
		
		String mesg=elementUtil.doGetElementText(this.suceesMsg);
		System.out.println("account creation" + mesg);
		
		if (mesg.contains(Constant.ACCOUNT_CREATION_SUCCESS_MSG)){
			
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			
			
			return true;
		}
		else{
			return false;
		}
		}
	
	
}
