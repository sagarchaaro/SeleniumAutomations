package seleniumScript;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo01 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 
	
		
		driver.get("https://www.makemytrip.com");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		Actions ac= new Actions(driver);
		WebElement ab=driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chMore']"));
		ac.moveToElement(ab);
		ac.perform();
	
	
	
	
	}

}
