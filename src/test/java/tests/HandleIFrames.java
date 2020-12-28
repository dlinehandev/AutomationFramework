package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import core.DriverFactory;


public class HandleIFrames extends TestBase {

	private WebDriver driver = null;
	
	@Test
	public void HandleIFrames() throws InterruptedException {
		// Write a script handling Iframe
				
		//Thread.sleep(5000);
		driver = this.getDriver();
		
		driver.switchTo().frame("courses-iframe");
		
		List<WebElement> headerlinks = driver.findElements(By.xpath("//header/div[2]/div/div/div[2]/nav/div[2]/ul/li/a"));
		
		System.out.println("iFrame nav links are:");
		
		for (WebElement link : headerlinks) {
			System.out.println(link.getText());
		}
				
		driver.switchTo().defaultContent();
				

	}
}
