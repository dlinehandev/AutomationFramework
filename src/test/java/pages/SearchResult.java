package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult {

	@FindBy(xpath="//*[@id='listings-sort']")
	private WebElement selectSortBy;
	
	@FindBy(xpath="//*[@id='listings-sort']/option[6]")
	private WebElement selectDepartureEarliestOption;
	
	private WebDriver driver = null;
	
	public SearchResult (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean searchResultsOpen () {
		return selectSortBy.isDisplayed();
	}
	
	public void sortResults() {
		selectSortBy.click();
		selectDepartureEarliestOption.click();
	}
	
	
	
}
