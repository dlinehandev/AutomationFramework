package tests;

import core.TestConfig;
import core.TestReporter;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import core.DriverFactory;
import core.ExcelDataProvider;
import core.ITestData;
import core.JSONDataProvider;

public class TestBase {
	
	private WebDriver driver;
	private ITestData testData;
	private static TestReporter reporter;

	@Parameters({"env"})
	@BeforeSuite
	public void initSuite(String env) throws Exception {
		TestConfig.load(env);
		TestConfig.addProperty("env",env);
		reporter = new TestReporter();
	}
	
	@BeforeClass
	public void initDriver() {
		String browser = TestConfig.getProperty("browser");
		driver = new DriverFactory().getDriver(browser);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	public void launchApp() {
		driver.get(TestConfig.getProperty("appBaseURL"));
	}
	
	@BeforeMethod
	public void initTestReport(Method method){
		reporter.startReporting(method.getName(), driver);
	}
	
	public TestReporter reporter(){
		if(reporter!=null){
			return reporter;
		}
		return null;
	}
	
	@DataProvider
	public Object[][] getData(Method testCase) throws Exception {
		File testDataLocation = new File("src/test/resources/testdata");
		List<HashMap<String,String>> extractedData = null;
		String dataSource = TestConfig.getProperty("dataSource");
		System.out.println("Data Source : "+ dataSource);
		
		// Setting the data source
		if(dataSource.equalsIgnoreCase("excel")){
			String sheetName  =  TestConfig.getProperty("env").toUpperCase();
			this.testData = new ExcelDataProvider(testDataLocation.getAbsolutePath()+"/TestData.xlsx",sheetName);
			extractedData = this.testData.getAllData(testCase.getName());
		}else if(dataSource.equalsIgnoreCase("json")){
			String envName = TestConfig.getProperty("env");
			this.testData = new JSONDataProvider(testDataLocation+"/data."+ envName +".json");
			extractedData = this.testData.getAllData(testCase.getName());
		}else{
			throw new Exception("Invalid data source specified : " + dataSource);
		}
		Object[][] finaldata = this.createDataProvider(extractedData);
		return finaldata;
	}
	
	private Object[][] createDataProvider(List<HashMap<String,String>> dataSet){
		int rowNo = dataSet.size();
		Object[][] dataArray = new Object[rowNo][2];

		int dim = 0;

		for(int iRow=0;iRow<rowNo;iRow++) {
			dataArray[dim][0] = iRow+1;
			dataArray[dim][1] = dataSet.get(iRow);
			dim++;
		}
		return dataArray;
	}

	@AfterMethod
	public void closeReport(){
		reporter.endReporting();
	}
	
	@AfterClass
	public void cleanUp() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@AfterSuite
	public void clearReport(){
		reporter.flushReport();
	}
	

}
