package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class HandleWindows extends TestBase {

	private WebDriver driver = null;

	
	@Test
	public void HandleWindows() throws Exception {
		
		try {
			
			driver = this.getDriver();
			
			String currWindow = driver.getWindowHandle();
			System.out.println("Current window handle is: " + currWindow);
			
			driver.findElement(By.xpath("//*[@id='openwindow']")).click();
			Thread.sleep(3000);
			
			Set<String> handles = driver.getWindowHandles();
			
			for(String handle : handles) {
				System.out.println("Handle ID: " + handle);
			}		
			reporter().report(LogStatus.PASS,"Checking for successful print of window handles", "List of window handles printed successfully", true);
			
			driver.switchTo().window(currWindow);
			reporter().report(LogStatus.INFO,"Checking for switch to current window", "Switch to current window is successful");
			Thread.sleep(3000);
			driver.close();
		
		}
		
		catch(Exception e) {
			reporter().report(LogStatus.FAIL,"Exception Occurred", e.getMessage(), true);			
		}
	}
	
}
