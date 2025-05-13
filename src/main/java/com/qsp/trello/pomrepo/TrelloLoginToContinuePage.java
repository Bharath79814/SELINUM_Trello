package com.qsp.trello.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginToContinuePage {

	WebDriver driver;
	public TrelloLoginToContinuePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "password")
	private WebElement passwordTextField;
	
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginToContinueButton() {
		return loginToContinueButton;
	}

	@FindBy(id = "login-submit")
	private WebElement loginToContinueButton;
}
