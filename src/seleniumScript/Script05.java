package seleniumScript;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.soap.Text;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;

public class Script05 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 

		driver.get("https://seleniumtesters-trials6562.orangehrmlive.com/auth/login");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("Title of website is .."+title);
		if (title.equalsIgnoreCase("OrangeHRM"))
		{
			System.out.println("Right");
		}else
		{
			System.out.println("Wrong");
		}
		
		//username
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		System.out.println("username");	
		
		//password
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Admin@123");
		System.out.println("password");
		
		//login
		driver.findElement(By.xpath("//input[@name='Submit'] [@class='button']")).click();
		System.out.println("login button");
		
		//Verify the Dashboard availability on Home Page (If not available make test case fail)
	
		
		if (driver.findElement(By.xpath("//li[contains(text(),'Dashboard')]")).isDisplayed())
		{
			System.out.println("It is a present");
		}else
		{
			
			System.out.println("It is not present");
			throw new Exception();
		}
		
		//Take a Screenshot and Append the screenshot name with the OrangeHRMLogin_Admin_Timestamp
		
		SimpleDateFormat st= new SimpleDateFormat("ddMMyyyy hhmmss");
		Date date= new Date();
		String timestamp=st.format(date);
		
		TakesScreenshot ts1= (TakesScreenshot)driver;
		File source1= ts1.getScreenshotAs(OutputType.FILE);
		File destination1 = new File("C:\\Selenium Catalogue\\Documents\\Screenshots\\OrangeHRMLogin_Admin_"+timestamp +".jpg");
		FileUtils.copyFile(source1, destination1);
		System.out.println("a Screenshot");
		
		//Click on Admin
		driver.findElement(By.xpath("//li[@id='menu_admin_viewAdminModule']/a")).click();
		System.out.println("Click on Admin");
		
		//Click on User management
		driver.findElement(By.xpath("//span[contains(text(),'User Management')]")).click();
		System.out.println("Click on User management");
		
		//Click on Users
		driver.findElement(By.xpath("(//span[contains(text(),'Users')])[1]")).click();
		System.out.println("users clicked");	
		
		//Get all the employeenames from the page and store in a Array variable.
		
		String s1[]= new String[50];
		List<WebElement> employeenames =driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr/td[4]/ng-include/span"));
		int i=0;
		for(WebElement name:employeenames)
		{
			String employeename = name.getText();
			s1[i]=employeename;
			i++;
		}
		for (int j=0; j<50; j++)
		{
			System.out.println(s1[j]);
		}
		
		//Using the Random class of the Java, get the Random Number and get the UserName text value 
		//from that random number position in above array store in employee name variable
		Random r1= new Random();
		
		int ra_name= r1.nextInt(50);
		String finalemployeename= s1[ra_name];
		System.out.println("final employee's name"+finalemployeename);
		
		String PartialEmployeeName = finalemployeename.split( " ")[0];
		
		//Click on + icon on right top corner of the page
		driver.findElement(By.xpath("//div[@ng-if='systemUsersCtrl.permissions.create']/a/i")).click();
		System.out.println("+ button clicked");
		
		//Enter the above EmployeeName  variable data in EmployeeName text  
		driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys(PartialEmployeeName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='selectedEmployee_value']")).sendKeys(Keys.ENTER);
		System.out.println(PartialEmployeeName+"is entered as username");
		
		//Split the above EmployeeName using space/byusing (dot symbol), get the FirstName of the
		//String and store in Partial Employee Name
		
		
		
		//Enter the Username as above "Partial EmployeeName" and append with
		//using the RandomStringUtils generate '4' letter.
		
		RandomStringUtils rst = new RandomStringUtils();
		String enam =rst.randomAlphabetic(4);
		PartialEmployeeName = PartialEmployeeName+enam;
		driver.findElement(By.xpath("(//sf-decorator[@ng-repeat='item in form.items'])[3]/div/input")).sendKeys(PartialEmployeeName);
		
		//Select the ESS Role as Default ESS Role
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[1]/input")).click();
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[1]/ul/li[2]/span")).click();
		System.out.println("ESS role selected");
		
		//Select the Supervisor Role as Default Supervisor
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[2]/input")).click();
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[2]/ul/li[2]/span")).click();
		System.out.println("supervisor role selected");
		
		//Select the Admin Role as Regional HR Manager
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[3]/input")).click();
		driver.findElement(By.xpath("(//div[@class='select-wrapper initialized'])[3]/ul/li[6]/span")).click();
		System.out.println("Admin role is select");
		
		//Select the Status as Enabled
		driver.findElement(By.xpath("(//sf-decorator[@ng-repeat='item in form.items'])[9]/div/div/input")).click();
		driver.findElement(By.xpath("(//sf-decorator[@ng-repeat='item in form.items'])[9]/div/div/ul/li[2]/span")).click();
		System.out.println("enabled selected");
		
		//Enter the Password as "Admin@123"
		driver.findElement(By.xpath("(//input[contains(@class,'ng-pristine ng-untouched ng-valid ng-empty ng-valid-schema-form')])[1]")).sendKeys("Admin@123");
		System.out.println("password done");
		Thread.sleep(3000);
		
		//Enter the Confirm Password as "Admin@123"
		//driver.findElement(By.xpath("(//input[contains(@class,'ng-pristine ng-untouched ng-valid ng-empty ng-valid-schema-form')])[2]")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//*[@id='confirmpassword']")).sendKeys("Admin@123");
		System.out.println("Confirm  password done");
		
		//Click on Save button
		driver.findElement(By.xpath("//a[@id='systemUserSaveBtn']")).click();
		System.out.println("save button clicked");
		
		//Click on All Regions (If Unchecked)
		System.out.println("all regions already clicked");
		Thread.sleep(3000);
		
		//Click on Save button
		driver.findElement(By.cssSelector("a[class='modal-action waves-effect waves-green btn primary-btn']")).click();
		System.out.println("saved");
		Thread.sleep(4000);
		
		//Now Verify the User added or not by clicking on Filter Icon button on top of the page
		driver.findElement(By.xpath("//i[contains(text(),'ohrm_filter')]")).click();
		System.out.println("filter button clicked");
		
		//Enter the above Username value in Username textbox
		driver.findElement(By.cssSelector("#systemuser_uname_filter")).sendKeys(PartialEmployeeName);
		System.out.println("username added in search box");
		
		//Click on Search
		driver.findElement(By.cssSelector("#systemUser_list_search_modal a[class='modal-action modal-close waves-effect btn primary-btn']")).click();
		System.out.println("search button clicked");
		
		// Verify whether added user is available in the Search 
		//Result or not (If not available make test case fail)
		
		
		if (driver.findElement(By.xpath("//tbody[@ng-if='!listData.staticBody']/tr/td[2]/ng-include/span")).isDisplayed())
		{
			System.out.println("username is avilable  "+PartialEmployeeName);
		}else
		{
			
			System.out.println("username is not match so try again...  "+PartialEmployeeName);
			//throw new Exception();
			
		}
		
		//Take a Screenshot with the Name as "<UserName>_Verify_Timestamp"
		
		Date date02= new Date();
		String timestamp02 =st.format(date02);
		
		TakesScreenshot tst02= (TakesScreenshot)driver;
		File source02= tst02.getScreenshotAs(OutputType.FILE);
		File destination02= new File("C:\\Selenium Catalogue\\Documents\\Screenshots\\PartialEmployeeName_"+timestamp +".jpg");
		FileUtils.copyFile(source02, destination02);
		System.out.println("screenshot ");
		
		//Click on Global Manager HR dropdown
		
		driver.findElement(By.cssSelector("#account-job i")).click();
		System.out.println("Global Manager HR dropdown clicked");
		Thread.sleep(3000);
		//Click on Logout link
		driver.findElement(By.cssSelector("#logoutLink")).click();
		System.out.println("log out clicked");
		
		//Now login with the above <UserName data> for UserName
		
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys(PartialEmployeeName);
		System.out.println("username added");
		
		//Enter the password as "Admin@123"
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Admin@123");
		System.out.println("password entered");
		
		//Click on Login
		driver.findElement(By.cssSelector("#btnLogin")).click();
		System.out.println("login button clicked");
		
		//Verify the Employee Name on Home Page
		
		String Username_text= driver.findElement(By.xpath("//a[@id='user-dropdown']/span[1]")).getText();
		System.out.println("username is "+Username_text);
		System.out.println("finalemployeename is "+finalemployeename);
		if (Username_text.equalsIgnoreCase(finalemployeename))
		{
			System.out.println("correct");
		}else
		{
			System.out.println("wrong");
		}
		
		//Close the Browser
		System.out.println("Its working.. no worries... (@ ^ @)");	
		//driver.close();
		
	}

	

}
