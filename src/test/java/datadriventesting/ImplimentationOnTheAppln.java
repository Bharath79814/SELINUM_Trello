package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplimentationOnTheAppln {
	public static WebDriver driver;
	
public static void main(String[] args) throws IOException, Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
	Properties pobj = new Properties();
	pobj.load(fis);
	String browserName = pobj.getProperty("browser");
	if (browserName.equals("chrome")) {
		driver = new ChromeDriver();
	}else if (browserName.equals("firefox")) {
		driver = new FirefoxDriver();
	}else if (browserName.equals("edge")) {
		driver= new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(pobj.getProperty("url"));
	Thread.sleep(2000);
	WebElement usernameTextField = driver.findElement(By.id("username"));
	usernameTextField.sendKeys(pobj.getProperty("username"));
	Thread.sleep(2000);
	WebElement passwordTextField = driver.findElement(By.name("pwd"));
	passwordTextField.sendKeys(pobj.getProperty("password"));
	Thread.sleep(2000);
	WebElement loginOption = driver.findElement(By.id("loginButton"));
	loginOption.click();
	Thread.sleep(2000);
	driver.manage().window().minimize();
	driver.quit();
}
}
