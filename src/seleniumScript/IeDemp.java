package seleniumScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IeDemp {

	public static void main(String[] args) 
	{

		System.setProperty("webdriver.ie.driver", "C:\\Selenium Catalogue\\Drivers\\IE\\IEDriverServer_Win32_3.141.59\\IEDriverServer.exe");
		
		
		WebDriver driver = new InternetExplorerDriver(); 
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("USA");


	}

}
