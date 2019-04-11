import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import java.nio.file.FileSystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest 
{
	private static WebDriver browser;
	
	@BeforeEach
	public void Before() {
		String driverPath = FileSystems.getDefault().getPath("test/resources/chromedriver").toString();
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		browser = new ChromeDriver(options);
	}

    @Test
	public void loginWithValidCredentials(){
    	browser.get("http://automationpractice.com/");
    	
    	WebElement signInButton = browser.findElement(By.cssSelector("a.login"));
    	signInButton.click();
    	
    	WebElement submitLoginButton = browser.findElement(By.id("SubmitLogin"));
        (new WebDriverWait(browser, 10)).until(ExpectedConditions.elementToBeClickable(submitLoginButton));
        
        WebElement email = browser.findElement(By.id("email"));
        WebElement passwd = browser.findElement(By.id("passwd"));
    	
        email.sendKeys("flow@mailinator.com");
        passwd.sendKeys("Test1234");
        submitLoginButton.click();
        
    	WebElement myAccountButton = browser.findElement(By.cssSelector("a.account"));
        (new WebDriverWait(browser, 5)).until(ExpectedConditions.elementToBeClickable(myAccountButton));
        
        assertEquals("Flow test", myAccountButton.getText(), "The account logged in is not the expected one!");
	}
    
    @Test
	public void loginWithValidCredentialsUsePOs(){
    	HomePage homePage = new HomePage(browser);
    	
    	LoginPage loginPage = homePage.signIn();
    	homePage = loginPage.loginAs("flow@mailinator.com", "Test1234");
    	assertTrue(homePage.isSignedIn(), "The account logged in is not the expected one!");
	}

	@Test
	public void loginWithInvalidEmail(){
		browser.get("http://automationpractice.com/");
		WebElement signInButton = browser.findElement(By.className("login"));
		signInButton.click();

		browser.findElement(By.id("email_create")).sendKeys("invalid email");
		browser.findElement(By.id("SubmitCreate")).click();

		WebElement errorField = browser.findElement(By.id("create_account_error"));
		(new WebDriverWait(browser, 5)).until(ExpectedConditions.visibilityOf(errorField));

		assertTrue(errorField.isDisplayed());
	}

	@AfterEach
	public void After() {
		browser.quit();
	}
}
