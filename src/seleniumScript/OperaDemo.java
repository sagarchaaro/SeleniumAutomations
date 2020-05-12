package seleniumScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;


public class OperaDemo {

	public static void main(String[] args) 
	{

		System.setProperty("webdriver.opera.driver", "C:\\Selenium Catalogue\\Drivers\\Opera\\operadriver_win64\\operadriver_win64\\operadriver.exe");
		
		WebDriver driver = new OperaDriver(); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("covid19");

	}

}
