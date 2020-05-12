package seleniumScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDemo 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		  WebDriver driver = new ChromeDriver();//chrome browser will be launched
		  
		  driver.get("https://www.facebook.com");//google website will be loaded
		  
		  driver.manage().window().maximize();//To maximize the browser window


	}

}
