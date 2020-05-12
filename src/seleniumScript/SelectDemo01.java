package seleniumScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

	// Drop down

public class SelectDemo01 
{

	public static void main(String[] args) throws InterruptedException 
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver ();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement s1 = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		
		Select sc= new Select(s1);
		sc.selectByIndex(10);
		System.out.println("Select month is ..10");
		Thread.sleep(3000);
		
		sc.selectByValue("4");
		System.out.println("April is selected");
		Thread.sleep(3000);
		
		
		sc.selectByVisibleText("Jul");
		System.out.println("July is selected");
		Thread.sleep(3000);
		
		
		driver.close();
	}

}
