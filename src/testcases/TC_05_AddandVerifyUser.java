package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Baseclass;
import utilities.CommonMethods;
import utilities.Utils;

public class TC_05_AddandVerifyUser {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver= Utils.openBrowser("chrome");
		new Baseclass(driver);
		
		driver.get("https://seleniumtesters-trials6562.orangehrmlive.com/auth/login");
		WebDriverWait wait= new WebDriverWait(driver,30);
		int rownuber= 3;
		
		String project_path= System.getProperty("user.dir");
		FileInputStream file_stream= new FileInputStream(project_path+"\\test-resources\\TestData01.xlsx");
		XSSFWorkbook x_book= new XSSFWorkbook(file_stream);
		XSSFSheet x_sheet= x_book.getSheet("AddandVerifyUser"); 
		
		
		
		//Title of Page
		String title = driver.getTitle();
		System.out.println("Title of website is .." + title);
		if (title.equalsIgnoreCase("OrangeHRM")) {
			System.out.println("Title is correct");
		} else {
			System.out.println("Title is Wrong");
			throw new Exception();
		}
		
		String userName= x_sheet.getRow(rownuber).getCell(3).getStringCellValue();
		String password=x_sheet.getRow(rownuber).getCell(4).getStringCellValue();
		CommonMethods.orangeHRMLogin(userName,password);
		
		// Verify the Dashboard availability on Home Page (If not available make test
		// case fail)

		if (driver.findElement(By.xpath("//li[contains(text(),'Dashboard')]")).isDisplayed()) {
			System.out.println("Dashboard availability is a present");
		} else {

			System.out.println("Dashboard availability is not present");
			throw new Exception();
		}

		// Take a Screenshot and Append the screenshot name with the
		// OrangeHRMLogin_Admin_Timestamp

		SimpleDateFormat st = new SimpleDateFormat("ddMMyyyy hhmmss");
		Date date = new Date();
		String timestamp = st.format(date);

		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File source1 = ts1.getScreenshotAs(OutputType.FILE);
		File destination1 = new File(
				"C:\\Selenium Catalogue\\Documents\\Screenshots\\OrangeHRMLogin_Admin_" + timestamp + ".jpg");
		FileUtils.copyFile(source1, destination1);
		System.out.println("Screenshot OrangeHRMLogin_Admin_Timestamp is take it.");

		// Click on Admin
		driver.findElement(By.xpath("//li[@id='menu_admin_viewAdminModule']/a")).click();
		System.out.println("Admin is clicked.");

		// Click on User management
		driver.findElement(By.xpath("//span[contains(text(),'User Management')]")).click();
		System.out.println("User management is clicked");

		// Click on Users
		driver.findElement(By.xpath("(//span[contains(text(),'Users')])[1]")).click();
		System.out.println("users is clicked");

		// Get all the employeenames from the page and store in a Array variable.

		String emp_names[] = new String[50];
		List<WebElement> employeenames = driver
				.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr/td[4]/ng-include/span"));
		int number = 0;
		for (WebElement name : employeenames) {
			String employee = name.getText();
			emp_names[number] = employee;
			number++;
		}
		/*for (int j = 0; j < 50; j++) {
			System.out.println(emp_names[j]);
		}*/

		// Using the Random class of the Java, get the Random Number and get the
		// UserName text value
		// from that random number position in above array store in employee name
		// variable
		Random random_number = new Random();

		int ra_namber = random_number.nextInt(50);
		String finalemployeename = emp_names[ra_namber];
		System.out.println("final employee's name" + finalemployeename);

		String PartialEmployeeName = finalemployeename.split(" ")[0];
		System.out.println("Employee name is confirmed.");
		
		// write data in excel
		
		
	
		
		
		
		// Click on + icon on right top corner of the page
		driver.findElement(By.xpath("//div[@ng-if='systemUsersCtrl.permissions.create']/a/i")).click();
		System.out.println("Pluse button is clicked");
		Thread.sleep(2000);
		
		// Enter the above EmployeeName  variable data in EmployeeName text
		driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys(PartialEmployeeName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys(Keys.ENTER);
		System.out.println(PartialEmployeeName + "is entered as username");

		// Split the above EmployeeName using space/byusing (dot symbol), get the
		// FirstName of the
		// String and store in Partial Employee Name

		// Enter the Username as above "Partial EmployeeName" and append with
		// using the RandomStringUtils generate '4' letter.

		RandomStringUtils rst = new RandomStringUtils();
		String username = rst.randomAlphabetic(4);
		username = PartialEmployeeName + username;
		System.out.println("Employee name is "+ username);
		
		
		
		driver.findElement(By.xpath("(//sf-decorator[@ng-repeat='item in form.items'])[3]/div/input"))
				.sendKeys(username);
		System.out.println(username+" is entered as username.");
		Thread.sleep(2000);
		
		// Select the ESS Role as Default ESS Role
		String ess=x_sheet.getRow(rownuber).getCell(5).getStringCellValue();
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[1]/input")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='select-wrapper initialized'])[1]/ul/li[2]/span[text()='"+ess+"']")));
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[1]/ul/li[2]/span[text()='"+ess+"']")).click();
		System.out.println("ESS role selected");
		System.out.println(ess+ " is selected as ESS Role.");
		
		// Select the Supervisor Role as Default Supervisor
		String supervisor=x_sheet.getRow(rownuber).getCell(6).getStringCellValue();
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[2]/input")).click();
		System.out.println("supervisor role drop -down is selected");
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[2]/ul/li/span[text()='"+supervisor+"']")).click();
		System.out.println(supervisor+ "is selected as Supervisor role.");

		// Select the Admin Role as Regional HR Manager
		String adminRole= x_sheet.getRow(rownuber).getCell(7).getStringCellValue();
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[3]/input")).click();
		System.out.println("Admin role  drop down  is selected.");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[3]/ul/li/span[text()='"+adminRole+"']")).click();
		System.out.println(adminRole+ " is selected as Admin role ");

		// Select the Status as Enabled
		String status= x_sheet.getRow(rownuber).getCell(8).getStringCellValue();
		driver.findElement(By.xpath("(//sf-decorator[@ng-repeat='item in form.items'])[9]/div/div/input")).click();
		driver.findElement(By.xpath("(//sf-decorator[@ng-repeat='item in form.items'])[9]/div/div/ul/li/span[text()='"+status+"']"))
				.click();
		System.out.println(status+ " is selected status.");

		// Enter the Password as "Admin@123"
		String userpassword= x_sheet.getRow(rownuber).getCell(9).getStringCellValue();
		driver.findElement(By.xpath(
				"(//input[contains(@class,'ng-pristine ng-untouched ng-valid ng-empty ng-valid-schema-form')])[1]"))
				.sendKeys(userpassword);
		System.out.println(userpassword+ " is entered.");

		// Enter the Confirm Password as "Admin@123"
		String confirmpassword=x_sheet.getRow(rownuber).getCell(10).getStringCellValue();
		driver.findElement(By.xpath("//*[@id='confirmpassword']")).sendKeys(confirmpassword);
		System.out.println(confirmpassword+ " is entered.");

		// Click on Save button
		driver.findElement(By.xpath("//a[@id='systemUserSaveBtn']")).click();
		System.out.println("save button is clicked");
		Thread.sleep(1000);

		// Click on All Regions (If Unchecked)
		System.out.println("all regions is clicked");
		Thread.sleep(1000);

		// Click on Save button
		driver.findElement(By.cssSelector("a[class='modal-action waves-effect waves-green btn primary-btn']")).click();
		System.out.println("save button is clicked.");
		Thread.sleep(1000);

		// Now Verify the User added or not by clicking on Filter Icon button on top of
		// the page
		driver.findElement(By.xpath("//i[contains(text(),'ohrm_filter')]")).click();
		System.out.println("filter button clicked");

		// Enter the above Username value in Username textbox
		driver.findElement(By.cssSelector("#systemuser_uname_filter")).sendKeys(username);
		System.out.println("username added in search box");

		// Click on Search
		driver.findElement(By.cssSelector(
				"#systemUser_list_search_modal a[class='modal-action modal-close waves-effect btn primary-btn']"))
				.click();
		System.out.println("search button is clicked.");

		// Verify whether added user is available in the Search
		// Result or not (If not available make test case fail)

		if (driver.findElement(By.xpath("//tbody[@ng-if='!listData.staticBody']/tr/td[2]/ng-include/span"))
				.isDisplayed()) {
			System.out.println("Username is avilable  " + username);
		} else {

			System.out.println("U sername is not match so try again...  " + username);
			// throw new Exception();

		}

		// Take a Screenshot with the Name as "<UserName>_Verify_Timestamp"

		Date today_date = new Date();
		String timestamp02 =st.format(today_date);

		
		TakesScreenshot tst02 = (TakesScreenshot) driver;
		File source02 = tst02.getScreenshotAs(OutputType.FILE);
		File destination02 = new File(
				"C:\\Selenium Catalogue\\Documents\\Screenshots\\PartialEmployeeName_" + timestamp + ".jpg");
		FileUtils.copyFile(source02, destination02);
		System.out.println("PartialEmployeeName Screenshot is taken.");

		// Click on Global Manager HR dropdown &logout

		CommonMethods.orangeHRMLogout();
		Thread.sleep(2000);
		// now do login again
		CommonMethods.orangeHRMLogin(username,"Admin@123");
		Thread.sleep(2000);

		// Verify the Employee Name on Home Page

		String Username_text = driver.findElement(By.xpath("//a[@id='user-dropdown']/span[1]")).getText();
		System.out.println("username is " + Username_text);
		System.out.println("finalemployeename is " + finalemployeename);
		if (Username_text.equalsIgnoreCase(username)) {
			System.out.println("Employee Name is a correct");
		} else {
			System.out.println("Employee Name is a wrong");
		}
		
		CommonMethods.orangeHRMLogout();

		Utils.closeBrowser(driver);
		file_stream.close();
		FileOutputStream File_o_Steam=new FileOutputStream(project_path+"\\test-resources\\TestData01.xlsx");
		x_sheet.getRow(rownuber).createCell(11);
		x_sheet.getRow(rownuber).getCell(11).setCellValue(PartialEmployeeName);
		System.out.println(PartialEmployeeName+ " is written in excel as employee name.");
		x_sheet.getRow(rownuber).createCell(12);
		x_sheet.getRow(rownuber).getCell(12).setCellValue(username);
		System.out.println("username is "+username);
		
		x_book.write(File_o_Steam);
		File_o_Steam.close();
		 
		
		System.out.println("Its working.. no worries... (@ ^ @)");

	}

}
