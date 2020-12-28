package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private WebDriver driver = null;
	
	public WebDriver getDriver(String browser) {	
		switch(browser.toLowerCase()) {
			case "chrome"  : 
				System.setProperty("webdriver.chrome.driver", "/Users/daniellinehan/eclipse/WizdomQA/chromedriver");
				driver = new ChromeDriver();
				break;
			case "firefox" :
				System.setProperty("webdriver.gecko.driver", "/Users/daniellinehan/eclipse/WizdomQA/geckodriver");
				driver = new FirefoxDriver();
			default : System.out.println("Incorrect browser name provided: "+ browser);
				
		}

		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(TestConfig.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getProperty("implicitWait")), TimeUnit.SECONDS);
		return driver;	
	}
	
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}

}