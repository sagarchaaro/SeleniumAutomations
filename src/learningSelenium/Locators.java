package learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://seleniumprep-trials65101.orangehrmlive.com");

		driver.manage().window().maximize();
		
		By username= By.id("txtUsername");
		WebElement element= driver.findElement(username);
		element.sendKeys("Admin");
		
		//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		By password= By.name("txtPassword");
		WebElement element02= driver.findElement(password);
		element02.sendKeys("Admin@123");
		
		//driver.findElement(By.name("txtPassword")).sendKeys("Admin@123");
		
		By signIn= By.id("btnLogin");
		WebElement element03= driver.findElement(signIn);
		element03.click();
		Thread.sleep(5000);
		//driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.linkText("PIM")).click();
		System.out.println("PIM is clicked.");
		Thread.sleep(2000);
		
		driver.findElement(By.partialLinkText("Add Employ")).click();
		System.out.println("Add Employee is clicked.");
		
		driver.close();
		System.out.println("Succesful");
	
	}

}
