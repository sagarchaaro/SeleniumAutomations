package learningSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumprep-trials65101.orangehrmlive.com");
		Thread.sleep(2000);
		
		String url=driver.getCurrentUrl();
		System.out.println("url:"+url);
		
		String title= driver.getTitle();
		System.out.println(title);
		if (title.equalsIgnoreCase("ABCDE"))
		{
			System.out.println("Title is match");
		}else
		{
			System.out.println("title is not match.");
		}
		
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("back:"+ driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println("for:"+ driver.getCurrentUrl());

		//String page= driver.getPageSource();
		//System.out.println(page);
		
		//driver.close();
		driver.quit();
		System.out.println("Succesful");
	}

}
 