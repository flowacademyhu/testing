import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.ContactUsPage;
import pageobjects.HomePage;

import java.nio.file.FileSystems;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ContactUsTestWithPageObjects
{
	private static WebDriver browser;
	
	@BeforeAll
	public static void Before() {
		String driverPath = FileSystems.getDefault().getPath("test/resources/chromedriver").toString();
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		browser = new ChromeDriver(options);
	}

    @Test
	public void contactUsSendMessageUsePOs(){
    	HomePage homePage = new HomePage(browser);
    	
    	ContactUsPage contactUsPage = homePage.openContactUsPage();
    	contactUsPage.selectSubject("Webmaster");
    	contactUsPage.typeEmail("test@example.com");
    	contactUsPage.typeOrderRefNum("98765");
    	contactUsPage.typeMessage("test msg");
        homePage = contactUsPage.sendMessage();
        
        assertTrue(homePage.isMessageSuccessfullySent(), "Success message is not correct!");
	}
    
	@AfterAll
	public static void After() {
		browser.quit();
	}
}
