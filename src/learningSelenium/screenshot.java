package learningSelenium;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://seleniumprep-trials65101.orangehrmlive.com");

		driver.manage().window().maximize();
		
		SimpleDateFormat sf= new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date date= new Date();
		String timestamp=sf.format(date);
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src1= ts.getScreenshotAs(OutputType.FILE);
		File dest1= new File("C:\\Selenium Catalogue\\Documents\\Screenshots\\MainPage_"+timestamp+".jpg");
		FileUtils.copyFile(src1, dest1);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.name("txtPassword")).sendKeys("Admin@123");
		
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(10000);
		
		
		File src2= ts.getScreenshotAs(OutputType.FILE);
		String timestamp2 = sf.format(date);
		File dest2= new File("C:\\Selenium Catalogue\\Documents\\Screenshots\\HomePage_"+timestamp2+".jpg");
		FileUtils.copyFile(src2, dest2);
		System.out.println("perfect");
	
	
	
	
	}

}
