package testcases;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Baseclass;
import utilities.CommonMethods;
import utilities.Utils;

//script 01

public class TC_01_AddEmployee

{

	public static void main(String[] args) throws Throwable {

		WebDriver driver = Utils.openBrowser("chrome");

		new Baseclass(driver);

		driver.get("https://seleniumprep-trials65101.orangehrmlive.com");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// Excel reading
		String project_path = System.getProperty("user.dir");

		FileInputStream file_stream = new FileInputStream(project_path + "\\test-resources\\TestData01.xlsx");

		XSSFWorkbook x_book = new XSSFWorkbook(file_stream);
		

		XSSFSheet x_sheet = x_book.getSheet("AddEmployee");

		String titleofPage = driver.getTitle();
		System.out.println("Title is ...." + titleofPage);
		if (titleofPage.equalsIgnoreCase("OrangeHRM")) {
			System.out.println("Title is matched");
		} else {
			System.out.println("Title is not matched.");
		}

		String userName = x_sheet.getRow(1).getCell(3).getStringCellValue();
		String password = x_sheet.getRow(1).getCell(4).getStringCellValue();
		CommonMethods.orangeHRMLogin(userName, password);

		// pim
		driver.findElement(By.xpath("//span[text ()='PIM']")).click();
		System.out.println("Pim is clicked.");

		// Add employees
		driver.findElement(By.xpath("//span[text ()='Add Employee']")).click();
		System.out.println("Add employees is clicked");

		// firstname
		String firstName = x_sheet.getRow(1).getCell(5).getStringCellValue();
		driver.findElement(By.xpath("//input[contains(@ng-model,'firstName')]")).sendKeys(firstName);
		System.out.println(firstName + " is entered as First Name. ");

		// middlename
		/*
		 * driver.findElement( By.
		 * xpath("//input[@class= 'ng-pristine ng-untouched ng-valid ng-empty ng-valid-schema-form']"
		 * )) .sendKeys("Banana");
		 * System.out.println("Middlename is entered as Banana");
		 */

		// lastname
		String lastName = x_sheet.getRow(1).getCell(6).getStringCellValue();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
		System.out.println(lastName + " is entered as Lastname ");

		// click on india
		String locationName = x_sheet.getRow(1).getCell(7).getStringCellValue();

		driver.findElement(By.xpath("//div[@class='select-wrapper initialized']/input[@type='text']")).click();
		System.out.println(" Country drop down is selected.");
		driver.findElement(By.xpath("//span[contains(text(),'" + locationName + "')]")).click();
		System.out.println(locationName + " is selected as a Country");

		driver.findElement(By.xpath("//a[@id='systemUserSaveBtn']")).click();
		System.out.println("Save button is clicked");

		// EEO Race & Ethinicity
		try {
			String EEO = x_sheet.getRow(1).getCell(8).getStringCellValue();
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//label[text()='EEO Race and Ethnicity']//parent::div//child::input")));
			driver.findElement(By.xpath("//label[text()='EEO Race and Ethnicity']//parent::div//child::input")).click();
			System.out.println("EEO Race & Ethinicity is selected.");

			driver.findElement(By.xpath("//span[text()='" + EEO + "']")).click();
			System.out.println("White is selected.");
		} catch (Exception e) {
			System.out.println("EEO Race & Ethinicity is not avilable for selected.");
		}

		// select bloodgroup
		String bloodGroup = x_sheet.getRow(1).getCell(9).getStringCellValue();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='1_inputfileddiv']/div/input")));
		driver.findElement(By.xpath("//div[@id='1_inputfileddiv']/div/input")).click();
		driver.findElement(By.xpath("//span[text()='" + bloodGroup + "']")).click();
		System.out.println(bloodGroup + " is selected as Bloodgroup.");

		// Select hobbies
		driver.findElement(By.xpath("//*[@id=\"5\"]")).sendKeys("Reading Books & Plating Cricket");
		System.out.println("Hobbies is selected");

		// click button
		driver.findElement(By.xpath("//button[@ng-click='vm.onNextStep()']")).click();
		System.out.println("Click button is selected");

		// Select region
		String region = x_sheet.getRow(1).getCell(11).getStringCellValue();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//label[text()='Region']//parent::div//child::input[1]")));
		WebElement element_region = driver
				.findElement(By.xpath("//label[text()='Region']//parent::div//child::input[1]"));
		System.out.println("Region  is clicked.");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element_region);
		Thread.sleep(2000);
		element_region.click();
		System.out.println("Region scroll down is come down.");

		driver.findElement(By.xpath("//div[@id='9_inputfileddiv']/div/ul/li/span[contains(text(),'" + region + "')]"))
				.click();
		System.out.println(region + " value is selected as Region.");

		// Select F.T.E
		String fte = x_sheet.getRow(1).getCell(12).getStringCellValue();
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/input[@type='text']")).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@id='10_inputfileddiv']/div/ul/li/span[text()='" + fte + "']")));
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/ul/li/span[text()='" + fte + "']")).click();
		System.out.println(fte + " is selected as FTE");

		// select Dept
		String dept = x_sheet.getRow(1).getCell(13).getStringCellValue();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@id='11_inputfileddiv']/div/input[@type='text']")));
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/input[@type='text']")).click();
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/ul/li/span[contains(text(),'" + dept + "')]"))
				.click();
		System.out.println(dept + " is selected as Department");

		// button
		driver.findElement(By.xpath("//button[@ng-click='vm.onFinish()']")).click();
		System.out.println("Save Button is saved");
		Thread.sleep(1000);
		// HR Link &Logout
		CommonMethods.orangeHRMLogout();

		Utils.closeBrowser(driver);
		x_book.close();
		file_stream.close();
		
	}

}
