package seleniumScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathExe02
{

	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 
		
		driver.get("https://accounts.google.com/ServiceLogin/signinchooser?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.id("identifierId")).sendKeys("Bhavin123");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class= 'RveJvd snByac']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@class= 'whsOnd zHQkBf']")).sendKeys("Bhavin@123456");
		
		//driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Bhavin123456789S");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class= 'RveJvd snByac']")).click();
		Thread.sleep(2000);
		
		driver.close();
	}
	

}
