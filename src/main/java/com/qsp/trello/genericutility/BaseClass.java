package com.qsp.trello.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
public WebDriver driver;
public   FileUtility fileUtils = new FileUtility();
 public WebDriverUtility webdriverUtils = new WebDriverUtility();

@BeforeMethod
	public void executeBeforeMethod() throws IOException {
		String browsername = fileUtils.readTheDataFromPropertyFile("browsername");
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
		}else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		webdriverUtils.implicitWait(driver);
		driver.get(fileUtils.readTheDataFromPropertyFile("url"));
	}

@AfterMethod
	public void executeAfterMethod() {
		driver.manage().window().minimize();
//		driver.quit();
	}
}
