package seleniumScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo02 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 
		
		driver.get("https://www.facebook.com");
		
		driver.manage().window().maximize();
		
		By Name =By.name("email");
		WebElement Web1 =driver.findElement(Name);
		Web1.sendKeys("Bhavin@1234"); 
		
		Thread.sleep(3000);
		
		By Password =By.id("pass");
		WebElement Web2 =driver.findElement(Password);
		Web2.sendKeys("123456789");
		
		Thread.sleep(3000);
		
		/*By Key = By.id("u_0_4");
		WebElement Web3 = driver.findElement(Key);
		Web3.click();*/
		driver.findElement(By.id("u_0_b")).click();
		
		Thread.sleep(20000);
		
		driver.close();

	}

}
