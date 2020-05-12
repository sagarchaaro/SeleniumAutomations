package learningSelenium;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo04 {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com/");

		driver.manage().window().maximize();
		Thread.sleep(2000);
		Actions at= new Actions(driver);
		
		String googalsessionID= driver.getWindowHandle();
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("India");
		element.submit();
		Thread.sleep(2000);
		
		WebElement aa=driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div[1]/a/h3"));
		at.moveToElement(aa);
		at.contextClick(aa);
		at.perform();
		
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		Set<String> windows= driver.getWindowHandles();
		for(String latestwindow: windows)
		{
			driver.switchTo().window(latestwindow);
		}
		Thread.sleep(2000);
		
		driver.switchTo().window(googalsessionID);
		Thread.sleep(2000);
		driver.close();
		
	}

}
