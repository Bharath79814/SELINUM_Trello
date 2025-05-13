package com.qsp.trello.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloWelcomePage {
	
	WebDriver driver;
	public TrelloWelcomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = "button[aria-label='Show menu']")
	private WebElement menuOption;
	
	public WebElement getMenuOption() {
		return menuOption;
		
	}
	@FindBy(xpath = "//div[normalize-space()='Close board']")
	private WebElement closeBoard;
	
	public WebElement getCloseBoard() {
		return closeBoard;
		
	}
	@FindBy(css = "button[title='Close']")
	private WebElement closeBoardButton;
	
	public WebElement getCloaseBoardButton() {
		return closeBoardButton;
		
	}
	
	

}
