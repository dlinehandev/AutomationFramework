package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpediaHome {
	
	// Home Page Web Elements
	@FindBy(xpath="//*[@id='uitk-tabs-button-container']/li[2]/a")
	private WebElement flightButton;
	
	@FindBy(xpath="//*[@id='uitk-tabs-button-container']/div/li[2]/a")
	private WebElement oneWayButton;
	
	@FindBy(xpath="//*[@id='wizard-flight-tab-oneway']//div[1]/div/div/div/button")
	private WebElement flightOrigin;
	
	@FindBy(xpath="//*[@id=\"location-field-leg1-origin\"]")
	private WebElement flightOriginInput;
	
	@FindBy(xpath="	//*[@id='location-field-leg1-origin-menu']/div[2]/ul/li[1]/button/div/div[1]/span/strong\n")
	private WebElement flightOriginOption;
	
	@FindBy(xpath="//*[@id='location-field-leg1-destination-menu']/div[1]/button")
	private WebElement flightDestination;
	
	@FindBy(xpath="//*[@id=\"location-field-leg1-destination\"]")
	private WebElement flightDestinationInput;
	
	@FindBy(xpath="//*[@id='d1-btn']")
	private WebElement departureDate;
	
	@FindBy(xpath="	//*[@id='wizard-flight-tab-oneway']/div/div[2]/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[2]/button")
	private WebElement departureDateOption;
	
	@FindBy(xpath="	//*[@id=\"wizard-flight-tab-oneway\"]/div/div[2]/div/div/div/div/div/div[2]/div/div[3]/button/span")
	private WebElement departureDone;
	
	@FindBy(xpath="//*[@id='wizard-flight-pwa-1']/div[3]/div[2]/button")
	private WebElement searchButton;
	
	private WebDriver driver = null;
	
	public ExpediaHome (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean launchExpedia(String url) {
		driver.get(url);
		return flightButton.isDisplayed();
	}
	
	public void enterOneWayFlightDetails(String origin, String destination, String date) throws InterruptedException {
		flightButton.click();
		oneWayButton.click();
		flightOrigin.click();
		Thread.sleep(1000);
		flightOriginInput.sendKeys(origin);
		Thread.sleep(1000);
		flightOriginOption.click();
		Thread.sleep(1000);
		flightDestination.click();
		Thread.sleep(1000);
		flightDestinationInput.sendKeys(destination);
		Thread.sleep(1000);
		flightDestinationInput.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		departureDate.click();
		Thread.sleep(1000);
		departureDateOption.click();
		Thread.sleep(1000);
		departureDone.click();
		Thread.sleep(1000);
		searchButton.click();
	}
	
}
