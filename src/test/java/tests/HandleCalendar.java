package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.ExpediaHome;
import pages.SearchResult;

public class HandleCalendar extends TestBase {

	ExpediaHome home = null;
	SearchResult result = null;
	
	@Test
	public void Verify_One_Way_Search() throws Exception {
		
		try {
			
			home = new ExpediaHome(getDriver());
			reporter().report(LogStatus.INFO,"Checking for navigation to Expedia", "Navigation to Expedia is successful");
			home.enterOneWayFlightDetails("Dublin", "London", "02/05/2021");
			reporter().report(LogStatus.PASS,"Checking for successful search", "Search is successful", true);

			
			result = new SearchResult(getDriver());
			reporter().report(LogStatus.INFO,"Checking for navigation to Search Page", "Navigation to Search Page is successful");
			result.sortResults();
			reporter().report(LogStatus.PASS,"Checking for successful sort", "Sort is successful", true);

		
		}
		
		catch(Exception e) {
			reporter().report(LogStatus.FAIL,"Exception Occurred", e.getMessage(), true);			
		}
	}
	
	
}
