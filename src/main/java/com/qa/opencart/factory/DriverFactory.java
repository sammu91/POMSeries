package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author AnandSingh
 *
 */

public class DriverFactory {
	
	Properties prop;
	public static String highlight;
	OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal <WebDriver>();
	
	public WebDriver init_browser (Properties prop){
	String browserName=prop.getProperty("browser").trim();
	highlight= prop.getProperty("highlight").trim();
	optionsManager =new OptionsManager(prop);
	
	System.out.println("browser name is : " + browserName);
	
	if(browserName.equalsIgnoreCase("chrome")){
		WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver(optionsManager.getChromeoptions());
		tlDriver.set(new ChromeDriver(optionsManager.getChromeoptions()));
	}
	else if(browserName.equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver (optionsManager.getFirefoxoptions());
		tlDriver.set(new FirefoxDriver (optionsManager.getFirefoxoptions()));
	}
	
	else if(browserName.equalsIgnoreCase("safari")){
		//driver=new SafariDriver ();
		tlDriver.set(new SafariDriver ());
		
	}
	
	else {
		System.out.println(" browser is not found... please pass correct browser" + browserName);
	}
	getDriver().manage().window().fullscreen();
	getDriver().manage().deleteAllCookies();
	getDriver().get(prop.getProperty("url").trim());
	return getDriver();
	
	}
	
	public static synchronized WebDriver getDriver(){
		return tlDriver.get();
		
	}
	
   public Properties init_prop() {
	   prop=new Properties();
	   FileInputStream ip=null;
	   String env= System.getProperty("env");
	   if (env==null){
		 try {
			ip=new FileInputStream ("./src/test_resources/config/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
	   else {
		   try{
		   
		   switch (env) {
		case "qa":
			ip=new FileInputStream ("./src/test_resources/config/qa.config.properties");
			break;
			
		case "stage":
			ip=new FileInputStream ("./src/test_resources/config/stage.config.properties");
			break;
		case "dev":
			ip=new FileInputStream ("./src/test_resources/config/dev.config.properties");
			break;

		default:
			System.out.println("please pass the right env value....");
			break;
		}}
		   
		   catch (FileNotFoundException e) {
				e.printStackTrace();
			} }
	
	   
	try {
		prop.load(ip);
	} catch (IOException e) {
		e.printStackTrace();
	}
	   return prop;
   }
   
  /**
   * take screenshot
   */
   public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		//File srcFile = new File(src);

		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}
  }


