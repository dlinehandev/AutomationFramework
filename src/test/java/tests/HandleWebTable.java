package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class HandleWebTable extends TestBase {
	
	private WebDriver driver = null;
	
	@Test
	public void HandleWebTable() throws Exception {
		
		try {
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
			reporter().report(LogStatus.PASS,"Checking that table data has been printed", "Table data has been printed successfully", true);

		
		}
		
		catch(Exception e) {
			reporter().report(LogStatus.FAIL,"Exception Occurred", e.getMessage(), true);			
		}
		
		

}

}
