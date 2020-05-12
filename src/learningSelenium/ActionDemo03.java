package learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo03 {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://seleniumprep-trials65101.orangehrmlive.com");

		driver.manage().window().maximize();


		WebElement element=driver.findElement(By.id("txtUsername"));
		Actions at=new Actions(driver);
		at.moveToElement(element);
		at.click(element);
		at.sendKeys("Admin");
		at.perform();
		
		WebElement element2= driver.findElement(By.name("txtPassword"));
		at.moveToElement(element2);
		at.sendKeys(element2, "Admin@123");
		at.perform();
	
		WebElement element3=driver.findElement(By.id("btnLogin"));
		at.moveToElement(element3);
		at.click(element3);
		at.perform();
		Thread.sleep(10000);
	}

}
