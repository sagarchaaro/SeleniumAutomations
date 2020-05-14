package testcases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pages.BaseClass;
import pages.Suite;
import utilities.CommonMethods;
import utilities.Constant;
import utilities.ExcelConfig;
import utilities.Log;
import utilities.Utils;
import utilities.YamlConfig;

public class TC_01_AddEmployee extends Suite{
	private static final String sheetName="AddEmployee";
	private static int rowNum_TestCases=0;
	private static String screenshotPath;
	private static int rowNum_AddEmployee=0;
	private static WebDriver driver;
	private static ExtentTest logger;
	private static String testName;
	
	@BeforeClass
	public void execute_PreRequisite() throws Exception{
		String projectPath=System.getProperty("user.dir");
		PropertyConfigurator.configure(projectPath+"\\test-resources\\Log4j.properties");
		
		screenshotPath= reportPath+"\\Screenshots\\";					
		YamlConfig.setYamlFile(projectPath+"\\test-resources\\test-info.yaml");
		ExcelConfig.setExcelFile(projectPath+"\\test-resources\\TestData.xlsx");
		
	}
	
	@Parameters({"testID"})
	@BeforeMethod
	public void getTestID(@Optional(Constant.TestCaseID) String testID) throws Exception{
		
		testName=Thread.currentThread().getStackTrace()[1].getClassName().substring(Thread.currentThread().getStackTrace()[1].getClassName().indexOf('.')+1)+"_"+testID;
		Log.startTestCase(testName);
		logger=report.createTest(testName);
		
		rowNum_TestCases=ExcelConfig.getRowContains(testID, Constant.col_testcaseID, "TestCases");
		Log.info(testID+" Row Number in TestCases sheet is :"+rowNum_TestCases);
		logger.log(Status.INFO, "Row Number in TestCases sheet is :"+rowNum_TestCases);
		
		rowNum_AddEmployee=ExcelConfig.getRowContains(testID, Constant.col_testcaseID, sheetName);
		Log.info(testID+" Row Number in AddEmployee sheet is :"+rowNum_AddEmployee);
		logger.log(Status.INFO, "Row Number in AddEmployee sheet is  :"+rowNum_AddEmployee);
	}
	
	
	@Test
	public static void test_AddEmployee() throws Exception {
		String browser=ExcelConfig.getCellData(rowNum_TestCases, Constant.col_browser, "TestCases");
		driver=Utils.openBrowser(browser);
		new BaseClass(driver);
		logger.log(Status.INFO, browser+" browser is launched");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		String appUrl=YamlConfig.getYamlData("url");
		driver.get(appUrl);
		Log.info(appUrl + " is loaded");			
		Utils.takeScreenshot(testName+"_LoginPage", screenshotPath);
		logger.log(Status.INFO, appUrl + " is loaded", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_LoginPage.jpg").build());
		
		String userName=ExcelConfig.getCellData(rowNum_AddEmployee, Constant.col_username, sheetName);
		String password = ExcelConfig.getCellData(rowNum_AddEmployee, Constant.col_password, sheetName);
		CommonMethods.orangeHRMLogin(userName, password);
		
		
		// Verify the Dashboard availability on Home Page (If not available make test case fail)

		if (driver.findElement(By.xpath("//li[contains(text(),'Dashboard')]")).isDisplayed()) {
				Log.info("Dashboard is present on Homepage");
				Utils.takeScreenshot(testName+"_HomePage", screenshotPath);
				logger.log(Status.INFO, "Orange HRM application is logged in", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_HomePage.jpg").build());
		} else {
				Log.info("Dashboard is not present on Homepage");
				BaseClass.status=false;
				throw new Exception();
		}
		
		driver.findElement(By.xpath("//span[@class='left-menu-title'][text()='PIM']")).click();
		Log.info("PIM link is clicked");	
		logger.log(Status.INFO, "PIM link is clicked");
		driver.findElement(By.xpath("//span[@class='left-menu-title'][text()='Add Employee']")).click();
		Log.info("Add Employee link is clicked");
		logger.log(Status.INFO, "Add Employee link is clicked");
		
		//AddEmployee
		//firstName
		String firstName=ExcelConfig.getCellData(rowNum_AddEmployee, Constant.col_firstName, sheetName);
		driver.findElement(By.xpath("//input[contains(@ng-model,'firstName')]")).sendKeys(firstName);
		Log.info(firstName+" is entered as First Name");
		logger.log(Status.INFO, firstName+" is entered as First Name");
		//lastName
		String lastName=ExcelConfig.getCellData(rowNum_AddEmployee, Constant.col_lastName, sheetName);
		driver.findElement(By.xpath("//input[@type='text'][@id='lastName']")).sendKeys(lastName);
		Log.info(lastName+" is entered as Last Name");
		logger.log(Status.INFO, lastName+" is entered as Last Name");
		//Location
		driver.findElement(By.xpath("//input[@type='text'][@readonly='true'][@value='-- Select --']")).click();
		Log.info("Location drop-down is clicked");
		logger.log(Status.INFO, "Location drop-down is clicked");
		String locationName=ExcelConfig.getCellData(rowNum_AddEmployee, Constant.col_location, sheetName);
		driver.findElement(By.xpath("//span[contains(text(),'"+locationName+"')]")).click();
		Log.info(locationName+" is selected from Location drop-down");
		Utils.takeScreenshot(testName+"_AddEmployee_1", screenshotPath);
		logger.log(Status.INFO, locationName+" is selected from Location drop-down", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_AddEmployee_1.jpg").build());
		
		driver.findElement(By.xpath("//a[@id='systemUserSaveBtn']")).click();
		Log.info("Next button is clicked");
		logger.log(Status.INFO, "Next button is clicked");

		//EEO Race and Ethnicity
		try{
			String EEORace=ExcelConfig.getCellData(rowNum_AddEmployee, Constant.col_eeoEthnicity, sheetName);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='EEO Race and Ethnicity']//parent::div//child::input[1]")));
			driver.findElement(By.xpath("//label[text()='EEO Race and Ethnicity']//parent::div//child::input[1]")).click();
			Log.info("EEO Race and Ethnicity is clicked");
			logger.log(Status.INFO, "EEO Race and Ethnicity is clicked");

			driver.findElement(By.xpath("//label[text()='EEO Race and Ethnicity']//parent::div//child::ul[1]/li/span[text()='"+EEORace+"']")).click();
			Log.info("White is selected from EEO Race and Ethnicity drop-down");
			logger.log(Status.INFO, "White is selected from EEO Race and Ethnicity drop-down");
	
		}catch(Exception e){
			Log.info("EEO Race and Ethnicity is not available for selection");
			logger.log(Status.INFO, "EEO Race and Ethnicity is not available for selection");
		}
				
		//Blood group
		String bloodGroup=ExcelConfig.getCellData(rowNum_AddEmployee, Constant.col_bloodGroup, sheetName);
		driver.findElement(By.xpath("//label[text()='Blood Group']//parent::div//child::input[1]")).click();
		Log.info("Bood group is clicked");
		logger.log(Status.INFO, "Bood group is clicked");
		
		driver.findElement(By.xpath("//span[text()='"+bloodGroup+"']")).click();
		Log.info(bloodGroup+" is selected from Blood group drop-down");
		logger.log(Status.INFO, bloodGroup+" is selected from Blood group drop-down");

		// Select hobbies
		String hobbies=ExcelConfig.getCellData(rowNum_AddEmployee, Constant.col_hobbies, sheetName);
		driver.findElement(By.xpath("//*[@id=\"5\"]")).sendKeys(hobbies);
		Utils.takeScreenshot(testName+"_AddEmployee_2", screenshotPath);
		Log.info("Reading Books & Playing Cricket is entered as Hobbies");
		logger.log(Status.INFO, "Reading Books & Playing Cricket is entered as Hobbies", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_AddEmployee_2.jpg").build());
		
		driver.findElement(By.xpath("//button[@ng-click='vm.onNextStep()']")).click();
		Log.info("Next button is clicked");
		logger.log(Status.INFO, "Next button is clicked");

		// Select region
		String region=ExcelConfig.getCellData(rowNum_AddEmployee, Constant.col_region, sheetName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Region']//parent::div//child::input[1]")));
		WebElement element_region=driver.findElement(By.xpath("//label[text()='Region']//parent::div//child::input[1]"));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element_region);
		Thread.sleep(1000);
		element_region.click();
		Log.info("Region drop-down is clicked");
		logger.log(Status.INFO, "Region drop-down is clicked");
		driver.findElement(By.xpath("//div[@id='9_inputfileddiv']/div/ul/li/span[contains(text(),'"+region+"')]")).click();
		Log.info(region+" value is selected from Region drop-down");
		logger.log(Status.INFO, region+" value is selected from Region drop-down");

		// Select F.T.E
		String fte=ExcelConfig.getCellData(rowNum_AddEmployee, Constant.col_fte, sheetName);
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/input[@type='text']")).click();
		Log.info("FTE drop-down is clicked");
		logger.log(Status.INFO, "FTE drop-down is clicked");
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/ul/li/span[text()='"+fte+"']")).click();
		Log.info(fte+" is slected from FTE drop-down");
		logger.log(Status.INFO, fte+" is slected from FTE drop-down");

		// select Dept
		String dept=ExcelConfig.getCellData(rowNum_AddEmployee, Constant.col_department, sheetName);
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/input[@type='text']")).click();
		Log.info("Temporary department drop-down is clicked");
		logger.log(Status.INFO, "Temporary department drop-down is clicked");
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/ul/li/span[contains(text(),'"+dept+"')]")).click();
		Log.info(dept+" is selected for Temporary Department");
		Utils.takeScreenshot(testName+"_AddEmploye_3", screenshotPath);
		logger.log(Status.INFO, dept+" is selected for Temporary Department", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_AddEmploye_3.jpg").build());
		
		driver.findElement(By.xpath("//button[@ng-click='vm.onFinish()']")).click();
		Log.info("Next button is clicked");
		logger.log(Status.INFO, "Next button is clicked");
		
		CommonMethods.orangeHRMLogout();
		Utils.takeScreenshot("LogoutPage", screenshotPath);

	}
	
	@AfterMethod
	public void setStatus(ITestResult result) throws Exception{
		if(result.getStatus()==ITestResult.SUCCESS){
			Log.info("Test Case is Passed");
			logger.log(Status.PASS, "Test case is passed :"+result.getTestClass());
			ExcelConfig.setCellData("Pass", rowNum_TestCases, Constant.col_status, "TestCases");
		}else if(result.getStatus() ==ITestResult.FAILURE){
			Log.info("Test Case is failed");
			Utils.takeScreenshot(testName+"_Fail", screenshotPath);
			logger.log(Status.FAIL, "Test case is Failed and testcase name is :"+result.getTestClass()+"-----"+result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_Fail.jpg").build());
			ExcelConfig.setCellData("Fail", rowNum_TestCases, Constant.col_status, "TestCases");
		}else if(result.getStatus() ==ITestResult.SKIP){
			logger.log(Status.SKIP, "Test case is Skipped :"+result.getTestClass()+"------"+result.getThrowable());
		}	
		report.flush();
		Utils.closeDriver(driver);
		Log.endTestCase();
	}
	
}
