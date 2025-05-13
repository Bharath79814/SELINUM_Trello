package com.qsp.trello.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {

	WebDriver driver;
	public TrelloBoardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "button[aria-label='Create board or Workspace']")
	private WebElement createButtonOption;
	
	public WebElement getCreateButtonOption() {
		return createButtonOption;
	}
	@FindBy(css = "button[data-testid='header-create-board-button'] span[class='BmRHtH7FIX0jcL']")
	private WebElement createBoardButton;

	public WebElement getBoardTitle() {
		return boardTitle;
	}

	public WebElement getCreateBoardButton() {
		return createBoardButton;
	}

	@FindBy(xpath = "//input[@data-testid='create-board-title-input']")
	private WebElement boardTitle;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement createButton;
	
	public WebElement getCreateButton() {
		return createButton;
		
	}
}
