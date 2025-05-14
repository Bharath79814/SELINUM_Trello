package com.qsp.trello.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteBoard {
	WebDriver driver;
	@FindBy(xpath = "//button[normalize-space()='Permanently delete board']")
	private WebElement deleteBoard;

	public DeleteBoard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public WebElement getDeleteBoard() {
		return deleteBoard;
		
	}
	@FindBy(xpath = "//button[normalize-space()='Delete']")
	private WebElement deleteButton;
	
	public WebElement getDeleteButton() {
		return deleteButton;
	}
}
