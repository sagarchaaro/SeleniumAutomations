package testcases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


public class TC_00_Login extends Suite{
	private static final String sheetName="Login";
	private static int rowNum_TestCases=0;
	private static String screenshotPath;
	private static int rowNum_Login=0;
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
		
		rowNum_Login=ExcelConfig.getRowContains(testID, Constant.col_testcaseID, sheetName);
		Log.info(testID+" Row Number in Login sheet is :"+rowNum_Login);
		logger.log(Status.INFO, "Row Number in Login sheet is  :"+rowNum_TestCases);
	}
	
	@Test	
	public static void test_Login() throws Exception {
		String browser=ExcelConfig.getCellData(rowNum_TestCases, Constant.col_browser, "TestCases");
		driver=Utils.openBrowser(browser);
		new BaseClass(driver);
		logger.log(Status.INFO, browser+" browser is launched");
		
		String appUrl=YamlConfig.getYamlData("url");
		driver.get(appUrl);
		Log.info(appUrl + " is loaded");	
		Utils.takeScreenshot(testName+"_LoginPage", screenshotPath);
		logger.log(Status.INFO, appUrl + " is loaded", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_LoginPage").build());
		
		String userName=ExcelConfig.getCellData(rowNum_Login, Constant.col_username, sheetName);
		String password = ExcelConfig.getCellData(rowNum_Login, Constant.col_password, sheetName);
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

		CommonMethods.orangeHRMLogout();
		Utils.takeScreenshot("LogoutPage", screenshotPath);
		logger.log(Status.INFO, "Orange HRM application is logged out");
		
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
