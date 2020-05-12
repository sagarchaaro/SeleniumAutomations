package learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo
{
 public static void main(String[] args) throws Throwable 
 {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.expedia.com");
		System.out.println("expedia link is open");
		driver.manage().window().maximize();
		System.out.println("maximize screen");
		
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		driver.findElement(By.id("flight-type-one-way-label-hp-flight")).click();
		
		driver.findElement(By.id("flight-origin-hp-flight")).clear();
		driver.findElement(By.id("flight-origin-hp-flight")).sendKeys("Delhi");
		System.out.println("Delhi is entered.");
	 
		WebElement originLocation= driver.findElement(By.id("flight-origin-hp-flight"));
		originLocation.click();
		originLocation.clear();
		originLocation.sendKeys("Delhi");
	 
		WebElement destinationLocation = driver.findElement(By.id("flight-destination-hp-flight"));
		destinationLocation.click();
		destinationLocation.clear();
		destinationLocation.sendKeys("New York");
		System.out.println("New York is entered,");
	 
	 
		WebElement departingDate = driver.findElement(By.id("flight-departing-single-hp-flight"));
		departingDate.click();
		departingDate.clear();
		departingDate.sendKeys("12/12/2020");
		departingDate.sendKeys(Keys.ESCAPE);
		System.out.println("Date is entered.");
		Thread.sleep(1000);
	 
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-flight\"]/div/ul/li/button")).click();
		System.out.println("Travelers button is clicked.");
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-flight\"]/div/ul/li/div/div/div/div[1]/div[4]/button")).click();
		System.out.println("Adult button is clicked.");
		Thread.sleep(2000);
		
		WebElement ax=driver.findElement(By.xpath("(//div[@class='children-wrapper'])[1]/div[1]/div[4]/button/span[2]"));
		
		for (WebElement web: ax)
		{
			web.click();
		System.out.println("Children button is clicked.");
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 System.out.println("Hello\nBhavin\nPatel\nFrom India");

 
 
 
 
 }
}
