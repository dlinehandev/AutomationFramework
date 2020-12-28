package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HandleWindows extends TestBase {

	private WebDriver driver = null;

	
	@Test
	public void HandleWindows() throws InterruptedException {
		
		driver = this.getDriver();
		
		String currWindow = driver.getWindowHandle();
		System.out.println("Current window handle is: " + currWindow);
		
		driver.findElement(By.xpath("//*[@id='openwindow']")).click();
		Thread.sleep(3000);
		
		Set<String> handles = driver.getWindowHandles();
		
		for(String handle : handles) {
			System.out.println("Handle ID: " + handle);
		}
		
		driver.switchTo().window(currWindow);
		Thread.sleep(3000);
		driver.close();
	}
	
}
