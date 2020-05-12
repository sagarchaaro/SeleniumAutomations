package seleniumScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Script04 
{

	public static void main(String[] args) throws InterruptedException 
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
	Thread.sleep(2000);
			
	//password
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Admin@123");
	Thread.sleep(2000);
			
	//login
	driver.findElement(By.xpath("//input[@name='Submit'] [@class='button']")).click();
	Thread.sleep(2000);
	
	//Click on Recruitment link
	driver.findElement(By.xpath("//div[@id='menu-content']/ul/li[6]/a")).click();
	Thread.sleep(6000);
	
	//Click on + button (Add or Import Vacancy);-
	
	driver.switchTo().frame("noncoreIframe");
	Actions  at= new Actions(driver);
	WebElement target =driver.findElement(By.xpath("//a[@id='addItemBtn']/i"));
	at.moveToElement(target).perform();
	Thread.sleep(2000);
	
	
	//Click on + button (Add new vacancy)
	
	driver.findElement(By.xpath("//a[@id='addItemBtn']/../ul/li[2]/a/i")).click();
	
	//Enter the Vacancy as "Testing_<Some Name>"
	
	driver.findElement(By.xpath("(//div[@id='addVacancyFormDiv']/div[2]/form/div/div/input)[1]")).sendKeys("BP01");
	Thread.sleep(5000);
	
	//Select the Job Title as "Software Engineer"
	driver.findElement(By.xpath("(//form[@id='addJobVacancyForm']/div[1]/div/label)[2]")).click();
	driver.findElement(By.xpath("//form[@id='addJobVacancyForm']/div[1]/div[2]/div/ul/li/a/input")).click();
	driver.findElement(By.xpath("//form[@id='addJobVacancyForm']/div[1]/div[2]/div/ul/div/li[42]/a/p")).click();
	Thread.sleep(9000);
	
	//Select the Location as "Indian Development Center"
	driver.findElement(By.xpath("//div[@data-id='addJobVacancy_location']")).click();
	//driver.findElement(By.xpath("(//p[contains(text(),'India')])[1]")).click();
	//driver.findElement(By.xpath("(//ul[@class='dropdown-content dropdownObjectSearch'])[2]/div/li[2]/a/p")).click();
	driver.findElement(By.xpath("//ul[contains(@class,'dropdown-content dropdownObjectSearch ')]/div/li[13]/a/p")).click();
	System.out.println("UnitedBrjhxF printed");
	//driver.findElement(By.xpath("//ul[@id='dropdownObjectSearch_qDWHZ']/div/li[12]/a/p")).click();
	//driver.findElement(By.xpath("(//input[@class='employee-search validate'])[2]")).click();
	//driver.findElement(By.xpath("//ul[@id='dropdownObjectSearch_uFucs']/li/a/input")).click();
	//driver.findElement(By.xpath("//ul[@id='dropdownObjectSearch_uFucs']/div/li[12]/a/p")).click();
	Thread.sleep(5000);
	
	//Select the Subunit as "QA Team"
	driver.findElement(By.xpath("//div[contains(@data-id,'addJobVacancy_sub_unit')]/div[@id='textarea_addJobVacancy_sub_unit']")).click();
	driver.findElement(By.xpath("//div[contains(@data-id,'addJobVacancy_sub_unit')]/../div/ul/div/li[2]/a/p")).click();
	//driver.findElement(By.xpath("(//ul[@class='dropdown-content dropdownObjectSearch'])[2]/div/li[2]/a/p")).click();
	System.out.println("QA team silected");
	Thread.sleep(3000);
	
	//Select the Hiring Manager as "Aaliya Haq"
	
	driver.findElement(By.xpath("//div[@id='textarea_addJobVacancy_hiringManagers']")).click();
	driver.findElement(By.xpath("//div[@id='textarea_addJobVacancy_hiringManagers']/../ul/div/li[1]/a/p")).click();
	//driver.findElement(By.xpath("//div[contains(@id,'materializeWidgetEmployeeMultySelect_container_Hlnxy')]/div")).click();
	//driver.findElement(By.xpath("//div[contains(@id,'materializeWidgetEmployeeMultySelect_container_Hlnxy')]/ul/div/li[1]/a/p")).click();
	System.out.println("Aaliya Haq selected");
	
	
	// enter no of position
	driver.findElement(By.xpath("//input[@id='addJobVacancy_noOfPositions']")).sendKeys("5");
	System.out.println("no 5 added");
	
	// click on save button
	driver.findElement(By.xpath("//a[@id='saveVacancy']")).click();
	System.out.println("saved");
	Thread.sleep(5000);
	
	//Click on Global Manager HR Link
	driver.findElement(By.xpath("//i[@class='material-icons mdi-navigation-menu']")).click();
	driver.findElement(By.xpath("(//li[@class='meterialize-menu'])[1]/a")).click();
	driver.findElement(By.xpath("//i[@class='material-icons']")).click();
	System.out.println("Global Manager HR Link clicked");
	Thread.sleep(3000);
	
	//Click on Logout link
	
	driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
	System.out.println("Click on Logout linked");
	Thread.sleep(3000);
	
	
	//Close the Browser
	
	System.out.println("Its working.. no worries... (@ ^ @)");	
	driver.close();
	
	
	
	}

}
