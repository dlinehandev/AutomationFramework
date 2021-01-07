package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import core.TestReporter;


public class HandleIFrames extends TestBase {

	private WebDriver driver = null;
	
	@Test
	public void HandleIFrames() throws Exception {
		// Write a script handling Iframe
		
		try {
		
			//Thread.sleep(5000);
			driver = this.getDriver();
			
			driver.switchTo().frame("courses-iframe");
			
			List<WebElement> headerlinks = driver.findElements(By.xpath("//header/div[2]/div/div/div[2]/nav/div[2]/ul/li/a"));
			
			System.out.println("iFrame nav links are:");
			
			for (WebElement link : headerlinks) {
				System.out.println(link.getText());
			}
			reporter().report(LogStatus.PASS,"Checking for iframe text", "Iframe text is printed", true);

			
			driver.switchTo().defaultContent();
			reporter().report(LogStatus.INFO,"Checking for return to default content", "Return to default content is successful");

			
			
		}
		
		catch(Exception e) {
			reporter().report(LogStatus.FAIL,"Exception Occurred", e.getMessage(), true);			
		}
				

	}
}
