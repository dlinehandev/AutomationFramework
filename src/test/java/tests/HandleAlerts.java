package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class HandleAlerts extends TestBase {

	private WebDriver driver = null;
	
	@Test
	public void Dismiss_Confirm() throws Exception {
		
		try {
		
			driver = this.getDriver();
			driver.findElement(By.xpath("//*[@id='confirmbtn']")).click();
			Thread.sleep(3000);
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			reporter().report(LogStatus.PASS,"Checking for alert dismiss", "Alert dismiss is successful", true);
			
			driver.findElement(By.xpath("//*[@id='confirmbtn']")).click();
			Thread.sleep(3000);
			Alert alert2 = driver.switchTo().alert();
			alert2.accept();
			reporter().report(LogStatus.PASS,"Checking for alert accept", "Alert accept is successful", true);
		
		}
		
		catch(Exception e) {
			reporter().report(LogStatus.FAIL,"Exception Occurred", e.getMessage(), true);			
		}
	}
	
}
