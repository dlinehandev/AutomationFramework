package tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class HandleDataProviders extends TestBase {
		
	@Test(dataProvider = "getData")
	public void verifyMyntraProductAddToCart (int itr, Map<String,String> data) throws Exception {
			
		try {
			
			System.out.println(data);
			System.out.println("Username is: " + data.get("username"));
			System.out.println("Password is: " + data.get("password"));
			reporter().report(LogStatus.PASS,"Checking that data was printed", "Data was successfully printed", true);

		
		}
		
		catch(Exception e) {
			reporter().report(LogStatus.FAIL,"Exception Occurred", e.getMessage(), true);			
		}

	}

}
