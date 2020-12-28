package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.DriverFactory;
import pages.ExpediaHome;
import pages.SearchResult;

public class HandleCalendar extends TestBase {

	ExpediaHome home = null;
	SearchResult result = null;
	
	@Test
	public void Verify_One_Way_Search() throws InterruptedException {
		
		home = new ExpediaHome(getDriver());
		Assert.assertEquals(home.launchExpedia("https://www.expedia.com/"), true, "Unable to reach Expedia Home");
		home.enterOneWayFlightDetails("Dublin", "London", "02/05/2021");
		
		result = new SearchResult(getDriver());
		Assert.assertEquals(result.searchResultsOpen(), true, "Unable to reach Search Results page");
		result.sortResults();
		
		getDriver().quit();
	}
	
	
}
