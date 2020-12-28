package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HandleAlerts extends TestBase {

	private WebDriver driver = null;
	
	@Test
	public void Dismiss_Confirm() throws InterruptedException {
		
		driver = this.getDriver();
		driver.findElement(By.xpath("//*[@id='confirmbtn']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		driver.findElement(By.xpath("//*[@id='confirmbtn']")).click();
		Thread.sleep(3000);
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
	}
	
}
