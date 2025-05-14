package trelloendtoend;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qsp.trello.genericutility.BaseClass;
import com.qsp.trello.genericutility.FileUtility;
import com.qsp.trello.pomrepo.DeleteBoard;
import com.qsp.trello.pomrepo.TrelloBoardsPage;
import com.qsp.trello.pomrepo.TrelloHomePage;
import com.qsp.trello.pomrepo.TrelloLoginPage;
import com.qsp.trello.pomrepo.TrelloLoginToContinuePage;
import com.qsp.trello.pomrepo.TrelloWelcomePage;

public class TrelloCreateAndDeleteBoard extends BaseClass {
	

	@Test
	public void CreateAndDeleteBoard() throws IOException, InterruptedException {
	
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getloginElement().click();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		loginPage.getEmailTextField().sendKeys(fileUtils.readTheDataFromPropertyFile("email"));
		loginPage.getLoginButton().submit();
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);
//		loginToContinuePage.getPasswordTextField().sendKeys(fileUtils.readTheDataFromPropertyFile("password"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginToContinuePage.getPasswordTextField())).sendKeys(fileUtils.readTheDataFromPropertyFile("password"));
		loginToContinuePage.getLoginToContinueButton().submit();
        TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
        boardsPage.getCreateButtonOption().click();
        boardsPage.getCreateBoardButton().click();
        boardsPage.getBoardTitle().sendKeys(fileUtils.readTheDataFromPropertyFile("boardtitle"));
        wait.until(ExpectedConditions.elementToBeClickable(boardsPage.getCreateButton()));
        boardsPage.getCreateButton().click();
        TrelloWelcomePage welcomePage = new TrelloWelcomePage(driver);
        wait.until(ExpectedConditions.visibilityOf(welcomePage.getMenuOption()));
        welcomePage.getMenuOption().click();
        Actions actions = new Actions(driver);
        actions.moveToElement(welcomePage.getCloseBoard()).click(welcomePage.getCloseBoard()).build().perform();
        welcomePage.getCloaseBoardButton().click();
        try {
        	welcomePage.getMenuOption().click();	
		} catch (Exception e) {
			System.out.println("StaleElementReferenceException");
		}
        welcomePage.getMenuOption().click();
        
       DeleteBoard delete = new DeleteBoard(driver);
        delete.getDeleteBoard().click();
        
        delete.getDeleteButton().click();
        
	}
}
