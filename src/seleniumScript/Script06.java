package seleniumScript;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.implementation.bytecode.Throw;

public class Script06 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 

		driver.get("https://seleniumtesters-trials6562.orangehrmlive.com/auth/login");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		//1. Verify the Title of Orange HRM website

		String pg_title =driver.getTitle();
		System.out.println("Titile of page is a "+pg_title);
		if(pg_title.equalsIgnoreCase("OrangeHR"))
		{
			System.out.println("title is correct");
		}else
		{
			System.out.println("title is wrong");
		}
	
		//2. Enter the Username as Admin 
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		System.out.println("Username as Admin");
		
		//3. Enter the Password as Admin@123 
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#txtPassword"))).sendKeys("Admin@123");;
		System.out.println("Password as Admin@123");
		
		//4. Click on Login button
		driver.findElement(By.cssSelector("#btnLogin")).click();
		System.out.println("Login button Clicked");
	
		//Verify the Dashboard availability on Home Page (If not available make test case fail)
		
		if (driver.findElement(By.xpath("//li[contains(text(),'Dashboard')]")).isDisplayed())
		{
			System.out.println("Dashboard is display");
		}else
		{
			System.out.println("Dashboard is not display");
			throw new Exception();
		}
	
		// Take a Screenshot and Append the screenshot name with the OrangeHRMLogin_Admin_Timestamp
		SimpleDateFormat st= new SimpleDateFormat("ddMMyyyy hhmmss");
		Date date= new Date();
		String timestamp= st.format(date);
		
		TakesScreenshot tk= (TakesScreenshot)driver;
		File source1= tk.getScreenshotAs(OutputType.FILE);
		File destination1 = new File("C:\\Selenium Catalogue\\Documents\\Screenshots\\OrangeHRMLogin_Admin_"+timestamp +".jpg");
		FileUtils.copyFile(source1, destination1);
		System.out.println("take screenshot");
		
		//Click on Admin
		driver.findElement(By.xpath("//span[contains(text(),'Admin')]")).click();
		System.out.println("Admin selected");
		
		// Click on Organization
		driver.findElement(By.xpath("//li[@id='menu_admin_Organization']/a/span[2]")).click();
		System.out.println("organizaton clicked");
		
		//Click on Locations
		driver.findElement(By.id("menu_admin_viewLocations")).click();
		System.out.println("location clicked");
		
		//Get all the Names into Array in a page, by using the Random class of Java,
		//select the value Randomly from the Array and keep it in one variable as locationName
		
		String s1[]= new String[16];
		List<WebElement> names= driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr/td[2]/ng-include/span"));
		int i=0;
		for (WebElement name:names) 
		{
			String sname= name.getText();
			s1[i]=sname;
			i++;
		}
		System.out.println("sname work");
		for(int j=0; j<16; j++)
		{
			System.out.println(s1[j]);
		}
		
		Random r1= new Random();
		int random1 =r1.nextInt(16);
		String location_name= s1[random1];
		System.out.println("Location name "+location_name);
		/*String locationname= location_name.split( "  ")[0];
		System.out.println("***"+locationname);*/
		Thread.sleep(5000);
		
		//Click on Edit Icon opposite to the selected name
		List<WebElement> edit=driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr/td[8]/i"));
		
		WebElement a= edit.get(random1);
		
		a.click();
		Thread.sleep(5000);
		
		//###not working ###Click Get the selected country name from Country drop-down and keep it in one variable as "country"
		
		String country= driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[1]/input")).getAttribute("value");
		
		System.out.println("country name is .."+country);
		
		//Clear the Existing Name in the Name text-box
		
		driver.findElement(By.xpath("(//div[@class='schema-form-section row'])[1]/sf-decorator[1]/div/input")).clear();
		System.out.println("name is clear");
		
		//###not working ### Click Enter the Name as <country>+ space+ 6 DigitRandomString and update this value for "locationName"
		RandomStringUtils rst= new RandomStringUtils();
		String random_name= rst.randomAlphabetic(6);
		System.out.println("Random number is "+random_name);
		String name= country+" "+random_name;
		WebElement w1= driver.findElement(By.xpath("(//div[@class='schema-form-section row'])[1]/sf-decorator[1]/div/input"));
			w1.sendKeys(name);
		System.out.println("New Name added");
		
		//Clear the PhoneNumber
		driver.findElement(By.xpath("//input[@id='phone']")).clear();
		System.out.println("phone number is clear");
		
		// Get the Randomly generated 10 digit phone Number and keep it one variable as "phoneNumber" 
		//and Enter this value in Phone text-box
		
		String random_number=rst.randomNumeric(10);
		System.out.println("random number is "+random_number);
		
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(random_number);
		System.out.println("phone number added");
		Thread.sleep(5000);
		//###not working ###Click on EEO Enables (If not selected only)
		
		//WebElement web=driver.findElement(By.xpath("//div[@class='modal-content']/div/materializecss-decorator[5]/div/sf-decorator/div/label"));
		//WebElement web=driver.findElement(By.cssSelector("label[for='eeo_applicable']"));
		WebElement web=driver.findElement(By.xpath("//input[@id='eeo_applicable']"));
		/*
		 * if (web.isEnabled()) { web.click(); System.out.println("EEO clicked"); }else
		 * { System.out.println("EEO already clicked"); }
		 */
		
		Thread.sleep(5000);
		
		//Click on Save button
		
		driver.findElement(By.xpath("(//div[@class='modal-footer'])[2]/a[1]")).click();
		System.out.println("save it");
		
		//Click on Filter Icon
		driver.findElement(By.xpath("//i[contains(text(),'ohrm_filter')]")).click();
		System.out.println("filter icon clicked");
		
		//Enter the <locatioName> in LocationName text-box
		driver.findElement(By.xpath("//input[@id='location_name_filter']")).sendKeys(name);
		
		// search
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
		System.out.println("Locationname is searching..");
		
		//Validate the Result by verifying with the Updated Name and Updated Phone in Search Result
		Thread.sleep(4000);

		String validate_locationName=driver.findElement(By.xpath("//table[@class='highlight bordered']/tbody/tr[1]/td[2]/ng-include/span")).getText();
  System.out.println("Searched location name is :"+validate_locationName);
  if (validate_locationName.equalsIgnoreCase(name.trim())) {
   System.out.println(" Location Name is verified ");
   
  }else {
   System.out.println(" Location Name is not varified ");
   throw new Exception();
  }
  
  String validate_PhoneNo=driver.findElement(By.xpath("//table[@class='highlight bordered']/tbody/tr[1]/td[5]/ng-include/span")).getText();
  
  if (validate_PhoneNo.equalsIgnoreCase(random_number)) {
   System.out.println(" Phone No is verified ");
   
  }else {
   System.out.println(" Phone No is not varified ");
   throw new Exception();
  }


		//Now Keep the Earlier Add Employee Program in one Method
		
		
		
		// Call this Add Employee Method by passing this <LocationName>,  
		//(Repeat all Add Employee test case steps) with this Edited LocationName
		
		
		
		//So that the New user should be created
		
		
		//Search the EmployeeName in Search text-box
		
		
		//Validate the Result of the EmployeeName location, is appeared with the Edited locationName
		
		
		//Click on Employee Name
		
		
		//Click on Logout
		
		
		
		
		
		
		
		
		
		System.out.println("Its working.. no worries... (@ ^ @)");
		
	}	
}
