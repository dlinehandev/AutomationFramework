package tests;

import java.util.Map;

import org.testng.annotations.Test;

public class HandleDataProviders extends TestBase {
		
	@Test(dataProvider = "getData")
	public void verifyMyntraProductAddToCart (int itr, Map<String,String> data) {
				
		System.out.println(data);
		System.out.println("Username is: " + data.get("username"));
		System.out.println("Password is: " + data.get("password"));

	}

}
