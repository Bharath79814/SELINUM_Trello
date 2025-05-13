package com.qsp.trello.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloHomePage {
WebDriver driver;

	public  TrelloHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")
     private WebElement	loginButton;

	public WebElement getloginElement() {
		return loginButton;
	}
}



