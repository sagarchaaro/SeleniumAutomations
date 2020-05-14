package testcases;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class TC_05_AddandVerifyUser extends Suite{
	private static final String sheetName="AddandVerifyUser";
	private static int rowNum_TestCases=0;
	private static String screenshotPath;
	private static int rowNum_AddUser=0;
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
		
		rowNum_AddUser=ExcelConfig.getRowContains(testID, Constant.col_testcaseID, sheetName);
		Log.info(testID+" Row Number in AddAndVerifyUser sheet is :"+rowNum_AddUser);
		logger.log(Status.INFO, "Row Number in AddAndVerifyUser sheet is :"+rowNum_AddUser);
	}
	
	@Test
	public static void test_AddUser() throws Exception {
		String browser=ExcelConfig.getCellData(rowNum_TestCases, Constant.col_browser, "TestCases");
		driver = Utils.openBrowser(browser);
		new BaseClass(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		String appUrl=YamlConfig.getYamlData("url");
		driver.get(appUrl);
		Log.info(appUrl + " is loaded");
		Utils.takeScreenshot(testName+"_LoginPage_Admin", screenshotPath);
		logger.log(Status.INFO, appUrl + " is loaded", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_LoginPage_Admin.jpg").build());
		
		//title
		String title = driver.getTitle();
		Log.info("Title of website is .." + title);
		if (title.equalsIgnoreCase("orangehrm")) {
			Log.info("Title of the OrangeHRM application is matched");
			logger.log(Status.INFO, "Title of the OrangeHRM application is matched");
		} else {
			Log.info("Title of the OrangeHRM application is not matched");
			logger.log(Status.INFO, "Title of the OrangeHRM application is not matched");
			BaseClass.status=false;
			throw new Exception();
		}
		
		String userName=ExcelConfig.getCellData(rowNum_AddUser, Constant.col_username, sheetName);
		String password = ExcelConfig.getCellData(rowNum_AddUser, Constant.col_password, sheetName);
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

		// Click on Admin
		driver.findElement(By.xpath("//li[@id='menu_admin_viewAdminModule']/a")).click();
		Log.info("Admin link is clicked");
		logger.log(Status.INFO, "Admin link is clicked");

		// Click on User management
		driver.findElement(By.xpath("//span[contains(text(),'User Management')]")).click();
		Log.info("User management link is clicked");
		logger.log(Status.INFO, "User management link is clicked");

		// Click on Users
		driver.findElement(By.xpath("(//span[contains(text(),'Users')])[1]")).click();
		Log.info("Users link is clicked");
		logger.log(Status.INFO, "Users link is clicked");

		// Get all the employee names from the page and store in a Array variable.
		String employee[] = new String[50];
		List<WebElement> employeenames = driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr/td[4]/ng-include/span"));
		int empNo = 0;
		for (WebElement name : employeenames) {
			String employeename = name.getText();
			employee[empNo] = employeename;
			empNo++;
		}
		Log.info("All Employee Names are stored in the Array");
		Utils.takeScreenshot(testName+"Users", screenshotPath);
		logger.log(Status.INFO, "All Employee Names are stored in the Array", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_Users.jpg").build());
		
		//Get the Random Employee Name from the employee array
		Random empRandom = new Random();
		int empRandomNo = empRandom.nextInt(50);
		String randomEmployeeName = employee[empRandomNo];
		Log.info("Random Employee Name from array is" + randomEmployeeName);
		logger.log(Status.INFO, "Random Employee Name from array is" + randomEmployeeName);
	

		// Click on + icon on right top corner of the page
		driver.findElement(By.xpath("//div[@ng-if='systemUsersCtrl.permissions.create']/a/i")).click();
		Log.info("+ button is clicked");
		logger.log(Status.INFO, "+ button is clicked");

		// Enter the above EmployeeName  variable data in EmployeeName text
		String partialEmployeeName = randomEmployeeName.split(" ")[0];
		driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys(partialEmployeeName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys(Keys.ENTER);
		Log.info(partialEmployeeName + "is entered as username");
		logger.log(Status.INFO, partialEmployeeName + "is entered as username");

		//Employee Name
		String username = RandomStringUtils.randomAlphabetic(4);
		username = partialEmployeeName + username;
		Log.info("User Name is :"+username);
		logger.log(Status.INFO, "User Name is :"+username);
		driver.findElement(By.xpath("(//sf-decorator[@ng-repeat='item in form.items'])[3]/div/input")).sendKeys(username);
		Log.info(username+ " is entered as Employee Name");
		logger.log(Status.INFO, username+ " is entered as Employee Name");

		// Select the ESS Role as Default ESS Role
		String ess=ExcelConfig.getCellData(rowNum_AddUser, Constant.col_essRole, sheetName);
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[1]/input")).click();
		Log.info("ESS Role drop-down is clicked");
		logger.log(Status.INFO, "ESS Role drop-down is clicked");
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[1]/ul/li/span[text()='"+ess+"']")).click();
		Log.info(ess+" is selcted from the ESS Role");
		logger.log(Status.INFO, ess+" is selcted from the ESS Role");

		// Select the Supervisor Role as Default Supervisor
		String supervisorRole=ExcelConfig.getCellData(rowNum_AddUser, Constant.col_supervisorRole, sheetName);
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[2]/input")).click();
		Log.info("Supervisor Role drop-down is clicked");
		logger.log(Status.INFO, "Supervisor Role drop-down is clicked");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[2]/ul/li/span[text()='"+supervisorRole+"']")).click();
		Log.info(supervisorRole+" role is selected from Supervisor role");
		logger.log(Status.INFO, supervisorRole+" role is selected from Supervisor role");

		// Select the Admin Role as Regional HR Manager
		String adminRole=ExcelConfig.getCellData(rowNum_AddUser, Constant.col_adminRole, sheetName);
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[3]/input")).click();
		Log.info("Admin Role drop-down is clicked");
		logger.log(Status.INFO, "Admin Role drop-down is clicked");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[3]/ul/li/span[text()='"+adminRole+"']")).click();
		Log.info(adminRole+" is selected from the Admin Role drop-down");
		logger.log(Status.INFO, adminRole+" is selected from the Admin Role drop-down");

		// Select the Status as Enabled
		String status=ExcelConfig.getCellData(rowNum_AddUser, Constant.col_status_addUser, sheetName);
		driver.findElement(By.xpath("(//sf-decorator[@ng-repeat='item in form.items'])[9]/div/div/input")).click();
		Log.info("Status drop-down is clicked");
		logger.log(Status.INFO, "Status drop-down is clicked");
		driver.findElement(By.xpath("(//sf-decorator[@ng-repeat='item in form.items'])[9]/div/div/ul/li/span[text()='"+status+"']")).click();
		Log.info(status+"Enabled is selected from the status drop-down");
		logger.log(Status.INFO, status+" is selected from the status drop-down");

		// Enter the Password as "Admin@123"
		String userPassword=ExcelConfig.getCellData(rowNum_AddUser, Constant.col_userPassword, sheetName);
		driver.findElement(By.xpath("(//input[contains(@class,'ng-pristine ng-untouched ng-valid ng-empty ng-valid-schema-form')])[1]")).sendKeys(userPassword);
		Log.info("Admin@123 is enetred as Password");
		logger.log(Status.INFO, "Admin@123 is enetred as Password");
		String confirmUserPassword=ExcelConfig.getCellData(rowNum_AddUser, Constant.col_ConfirmuserPassword, sheetName);	
		driver.findElement(By.xpath("//*[@id='confirmpassword']")).sendKeys(confirmUserPassword);
		Log.info("Admin@123 is enetred as ConfirmPassword");
		Utils.takeScreenshot(testName+"_AddUser_1", screenshotPath);
		logger.log(Status.INFO, "Admin@123 is enetred as ConfirmPassword", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_AddUser_1.jpg").build());
		
		// Click on Save button
		driver.findElement(By.xpath("//a[@id='systemUserSaveBtn']")).click();
		Log.info("Save button is clicked");
		logger.log(Status.INFO, "Save button is clicked");

		// Click on Save button
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Save']")));
			Thread.sleep(3000);
			Utils.takeScreenshot(testName+"_AddUser_2", screenshotPath);
			driver.findElement(By.xpath("//a[text()='Save']")).click();
			Log.info("Save button is clicked with All Regions");
			logger.log(Status.INFO, "Save button is clicked with All Regions",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_AddUser_2.jpg").build());
		}catch(Exception e){
			Log.info("Save button is not available in All Regions");
			logger.log(Status.INFO, "Save button is not available in All Regions");
		}		

		// Now Verify the User added or not by clicking on Filter Icon button on top of the page
		driver.findElement(By.xpath("//i[contains(text(),'ohrm_filter')]")).click();
		Log.info("Filter button is clicked");
		logger.log(Status.INFO, "Filter button is clicked");

		// Enter the above Username value in Username textbox
		driver.findElement(By.cssSelector("#systemuser_uname_filter")).sendKeys(username);
		Log.info(username+" is entered in search box");
		logger.log(Status.INFO, username+" is entered in search box");

		// Click on Search
		driver.findElement(By.cssSelector("#systemUser_list_search_modal a[class='modal-action modal-close waves-effect btn primary-btn']")).click();
		Log.info("Search button clicked");
		logger.log(Status.INFO, "Search button clicked");

		// Verify whether added user is available in the Search

		if (driver.findElement(By.xpath("//tbody[@ng-if='!listData.staticBody']/tr/td[2]/ng-include/span")).isDisplayed()) {
			Log.info("Username is avilable in Search Result" + username);
			Utils.takeScreenshot(testName+"_FilterSearchResult", screenshotPath);
			logger.log(Status.INFO, "Username is avilable in Search Result" + username, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_FilterSearchResult.jpg").build());
		} else {

			Log.info("Username is not avilable in Search Result " + username);
			logger.log(Status.INFO, "Username is not avilable in Search Result " + username);
			throw new Exception();

		}

		CommonMethods.orangeHRMLogout();
		Utils.takeScreenshot(testName+"_LogoutPage_Admin", screenshotPath);
		logger.log(Status.INFO, "OrangeHRM application is Loggedout for Admin user", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_LogoutPage_Admin.jpg").build());

		
		CommonMethods.orangeHRMLogin(username, "Admin@123");
		
		// Verify the Employee Name on Home Page
		String Username_text = driver.findElement(By.xpath("//a[@id='user-dropdown']/span[1]")).getText();
		if (Username_text.equalsIgnoreCase(username)) {
			Log.info("Employee Name is matched after login screen");
			Utils.takeScreenshot(testName+"_LoginPage_"+username, screenshotPath);
			logger.log(Status.INFO, "LoginPage_"+username, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_LoginPage_"+username+".jpg").build());
		} else {
			Log.info("Employee Name is not matched after login screen");
			logger.log(Status.INFO, "Employee Name is not matched after login screen");
		}
		
		CommonMethods.orangeHRMLogout();
		Utils.takeScreenshot(testName+"_LogoutPage_"+username, screenshotPath);
		logger.log(Status.INFO,	"OrangeHRM application is Loggedout for "+username, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+testName+"_LogoutPage_"+userName+".jpg").build());

		ExcelConfig.setCellData(randomEmployeeName, rowNum_AddUser, Constant.col_employeeName_addUser, sheetName);
		Log.info(randomEmployeeName+" is written in the excel as a EmployeeName");
		ExcelConfig.setCellData(username, rowNum_AddUser, Constant.col_username_addUser, sheetName);
		Log.info(username+" is writen in the excel as a UserName");
			
		
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
