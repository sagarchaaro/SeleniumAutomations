package seleniumScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver (); 
	
		driver.get("https://netbanking.hdfcbank.com/netbanking/?_ga=2.115599558.1723591864.1585319972-1188113358.1585319972");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.switchTo().frame("login_page");
		driver.findElement(By.xpath("(//img[@alt='continue'])[1]")).click();
		Thread.sleep(3000);
		
		Alert at=driver.switchTo().alert();
		String s1=at.getText();
		System.out.println("Alert text ....."+s1);
		//at.accept();
		//System.out.println("ok clicked");
		
		if(s1.equalsIgnoreCase("Customer ID  cannot be left blank."))
		{
			at.accept();
		}else
		System.out.println("diffrent alert text");
		
		
		
		System.out.println("It passed!!!");
		
		
		
		
		
		
		
		

	}

}
