package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HandleWebTable extends TestBase {
	
	private WebDriver driver = null;
	
	@Test
	public void HandleWebTable() throws InterruptedException {
		
		// Write a script handling WebTable
		
		//Thread.sleep(3000);
		driver = super.getDriver();
		
		WebElement table = driver.findElement(By.xpath("//table[@id='product']"));
		List<WebElement> rows = table.findElements(By.xpath("//table[@id='product']//tr"));
		
		for (WebElement row : rows) {
			
			List<WebElement> headers = row.findElements(By.xpath("th"));
			
			for (WebElement header : headers) {
				System.out.print(header.getText() + " | ");
			}
						
			List<WebElement> cells = row.findElements(By.xpath("td"));
			
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | ");
			}
			
			System.out.println();
		
		}	

}

}
