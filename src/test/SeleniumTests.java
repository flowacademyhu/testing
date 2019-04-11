import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.FileSystems;
import java.util.ArrayList;

public class SeleniumTests 
{
	private WebDriver browser;
	
	@BeforeAll
	public void Before() {
		String driverPath = FileSystems.getDefault().getPath("src/test/resources/chromedriver").toString();
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--start-fullscreen");		
		browser = new ChromeDriver(options);
	}

    @Test
	public void searchForTextUseId(){
    	browser.get("http://automationpractice.com/");
    	WebElement searchField = browser.findElement(By.id("search_query_top"));
        searchField.sendKeys("by id");
	}
    
    @Test
	public void searchForTextUseName(){
    	browser.get("http://automationpractice.com/");
        WebElement searchField = browser.findElement(By.name("search_query"));
        searchField.sendKeys("by name");
	}
    
    @Test
	public void searchForTextUseClassName(){
    	browser.get("http://automationpractice.com/");
        WebElement searchField = browser.findElement(By.className("search_query"));
        searchField.sendKeys("by className");
	}
    
    @Test
	public void searchForTextUseTagnameId(){
    	browser.get("http://automationpractice.com/");
    	WebElement searchField = browser.findElement(By.cssSelector("input#search_query_top"));
        searchField.sendKeys("by tagname and id");
	}
    
    @Test
	public void searchForTextUseTagnameClassnameAttribute(){
    	browser.get("http://automationpractice.com/");
    	WebElement searchField = browser.findElement(By.cssSelector("input.search_query[placeholder=Search]"));
        searchField.sendKeys("by tagname, classname and attribute");
	}

	// example for tag name
	// also an example for the fact
	// that you really should try to use a specific locator :)
	@Test
	public void signUpForNewsUseTagName(){
		browser.get("http://automationpractice.com/");
		// since there are multiple buttons on the site
		// this locator will return with the first one
		// which is not really what we're looking for
		WebElement newsField = browser.findElement(By.id("newsletter_block_left"));
		WebElement signUpButton = newsField.findElement(By.tagName("button"));
		signUpButton.click();
	}
    
    @Test
	public void signInUseLinkText(){
    	browser.get("http://automationpractice.com/");
        WebElement signInButton = browser.findElement(By.linkText("Sign in"));
        signInButton.click();
	}
    
    @Test
	public void signInUsePartialLinkText(){
    	browser.get("http://automationpractice.com/");
        WebElement signInButton = browser.findElement(By.partialLinkText("Sign"));
        signInButton.click();
	}
    
    @Test
	public void signInUseXPath(){
    	browser.get("http://automationpractice.com/");
        WebElement signInButton = browser.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));        
        signInButton.click();
	}
    
    // https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html
    @Test
	public void contactUsSendEmptyMessage(){
    	browser.get("http://automationpractice.com/");
        WebElement contactUsButton = browser.findElement(By.linkText("Contact us"));
        contactUsButton.click();
        
        WebElement sendButton = browser.findElement(By.id("submitMessage"));
        (new WebDriverWait(browser, 5)).until(ExpectedConditions.elementToBeClickable(sendButton));
        
        sendButton.click();
	}
    
    @Test
	public void switchBetweenTabs(){
    	browser.get("http://automationpractice.com/");

    	WebElement fbFollowLink = browser.findElement(By.cssSelector("li.facebook")).findElement(By.tagName("a"));
    	fbFollowLink.click();    	
    	
        ArrayList<String> tabs = new ArrayList<String>(browser.getWindowHandles());
        
        // get the first tab and close it
        browser.switchTo().window(tabs.get(0));
        browser.close();
	}
    
    @Test
	public void openNewTabsWindows(){
    	browser.get("http://automationpractice.com/");

    	((JavascriptExecutor)browser).executeScript("window.open();");
    	
    	// alternative for opening a windows - not a portable solution!
    	// String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
    	// driver.findElement(By.tagName("body")).sendKeys(selectLinkOpeninNewTab);
    	
        ArrayList<String> windows = new ArrayList<String>(browser.getWindowHandles());

        // get the first tab and close it
        browser.switchTo().window(windows.get(0));
        browser.close();
	}
    
	@AfterAll
	public void After() {
		browser.quit();
	}
}
