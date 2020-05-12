package seleniumScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo01 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 
		driver.get("https://seleniumtesters-trials6562.orangehrmlive.com/auth/login");
		String t1 =driver.getTitle();
		System.out.println("Title is ...."+t1);
		if (t1.equalsIgnoreCase("OrangeHRM"))
		{
			System.out.println("Title is matched");
		}else
		{
			System.out.println("Title is not matched.");
		}
		
		driver.manage().window().maximize();
		
		By username =By.id("txtUsername");
		WebElement W1 = driver.findElement(username);
		W1.sendKeys("Admin");
		
		 //driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		/*By Key =By.name("txtPassword");
		WebElement W2 =driver.findElement(Key);
		W2.sendKeys("Admin@123"); */
		
		driver.findElement(By.name("txtPassword")).sendKeys("Admin@123");
		
		By SignIn = By.className("button");
		WebElement W3 = driver.findElement(SignIn);
		W3.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("PIM")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Add Employee")).click();
		
		Thread.sleep(12000);
		
		//driver.findElement(By.name("newEmployeeForm")).click();
		//driver.findElement(By.className("ng-pristine ng-valid ng-empty ng-valid-schema-form ng-touched")).sendKeys("Selenium");
		//driver.findElement(By.id("firstName")).sendKeys("Selenium");
		//driver.findElement(By.className("active")).sendKeys("Selenium");
		
	}

}
