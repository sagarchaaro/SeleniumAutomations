/**
 * 
 */
package seleniumScript;

import java.io.ObjectInputStream.GetField;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// getAllSelectedOptions..

public class SelectDemo04 
{

	public static void main(String[] args) throws InterruptedException 
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver ();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		WebElement s4=driver.findElement(By.xpath("//select[@name='cars']"));
		Select sc4= new Select(s4);
		
		sc4.selectByIndex(2);
		System.out.println("Opel selected ...");
		Thread.sleep(3000);
		
		sc4.selectByIndex(1);
		System.out.println("Saab selected ...");
		Thread.sleep(3000);
		
		List<WebElement> web= sc4.getAllSelectedOptions();
		for (WebElement We:web) 
		{
			System.out.println(We.getText());
		}
	}
	

}
