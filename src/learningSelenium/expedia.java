package learningSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class expedia {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		driver.get("https://www.expedia.com");
		driver.manage().window().maximize();
		System.out.println("maximize screen");
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		driver.findElement(By.id("flight-type-one-way-label-hp-flight")).click();
		
		driver.findElement(By.id("flight-origin-hp-flight")).clear();
		driver.findElement(By.id("flight-origin-hp-flight")).sendKeys("Delhi");
		
		WebElement originLocation= driver.findElement(By.id("flight-origin-hp-flight"));
		originLocation.click();
		originLocation.clear();
		originLocation.sendKeys("Delhi");
		
		WebElement destinationLocation = driver.findElement(By.id("flight-destination-hp-flight"));
		destinationLocation.click();
		destinationLocation.clear();
		destinationLocation.sendKeys("New York");
		
		WebElement departingDate = driver.findElement(By.id("flight-departing-single-hp-flight"));
		departingDate.click();
		departingDate.clear();
		departingDate.sendKeys("12/12/2020");
		departingDate.sendKeys(Keys.ESCAPE);
		Thread.sleep(1000);
		
		//add travelers
				driver.findElement(By.id("traveler-selector-hp-flight")).click();
				String aXpath = "//*[@class = 'uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized']";
				
				
				String ActualAdults= driver.findElement(By.xpath(aXpath + "//*[@class='uitk-step-input-value']")).getText();
					
				int iAdults = 2;
				
				while(Integer.parseInt(ActualAdults) != iAdults) {
					
					if(Integer.parseInt(ActualAdults) > iAdults)
						driver.findElement(By.xpath(aXpath + "//*[@class='uitk-step-input-button uitk-step-input-minus']")).click();
					else
						driver.findElement(By.xpath(aXpath + "//*[@class='uitk-step-input-button uitk-step-input-plus']")).click();
					
					Thread.sleep(1000);
					
					ActualAdults = driver.findElement(By.xpath(aXpath + "//*[@class='uitk-step-input-value']")).getText();
					
					// child
					//	String cpath = "//*[uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized']";
						//String Actualchilds= driver.findElement(By.xpath(cpath + "//*[@class='uitk-step-input-value']")).getText();
				
					int ichilds = 2;
					
					while(Integer.parseInt(ActualAdults) != ichilds)
					{
						if(Integer.parseInt(ActualAdults) >= ichilds) {
							
							WebElement newage = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-flight\"]/div/ul/li/div/div/div/div[2]/div[1]/div[4]/button/span[1]/svg"));
							//Select age = new Select(driver.findElement(By.id("flight-age-select-1-hp-flight")));
							Select age = new Select(newage);
							
							age.selectByVisibleText("Child 1 age");
							age.selectByIndex(1);
							
							age.selectByVisibleText("Child 2 age");
							age.selectByIndex(2);
							
							//driver.findElement(By.xpath(aXpath + "//*[@class='uitk-step-input-button uitk-step-input-minus']")).click();
													
						}
						else
							driver.findElement(By.xpath(aXpath + "//*[@class='uitk-step-input-button uitk-step-input-plus']")).click();
					
						Thread.sleep(1000);	
							String Actualchilds = driver.findElement(By.xpath(aXpath + "//*[@class='uitk-step-input-input']")).getText();
						
					}
					
				}
		
		driver.findElement(By.xpath("//*[@class='btn-primary btn-action gcw-submit']")).click();
		
		
		
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test-id='listing-price-dollars']")));
		
		List<WebElement> prices = driver.findElements(By.xpath("//*[@data-test-id='listing-price-dollars']"));
		
		if(prices.size()>0)
		System.out.println(prices.get(0).getText());
		
		WebElement price = driver.findElement(By.xpath("//*[@data-test-id='listing-price-dollars']"));
		System.out.println(price.getText());
		
		
		//String price=driver.findElement(By.xpath("//*[@data-test-id='listing-price-dollars']")).getText();
		
//		for(WebElement price : prices)
//		{
//			String p1 = price.getText().replace('$' , ' ');
//			String p2 = p1.replace(',' , ' ');						
//		
//		if(Integer.parseInt(p2.trim()) > 600  &&  Integer.parseInt(p2.trim()) < 900)
//		System.out.println(p2);
//		
//		}
	}
	
	public void SearchFastestFlight() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new  ChromeDriver();
		driver.get("https://www.expedia.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		driver.findElement(By.id("flight-type-one-way-label-hp-flight")).click();
		
		driver.findElement(By.id("flight-origin-hp-flight")).clear();
		driver.findElement(By.id("flight-origin-hp-flight")).sendKeys("Delhi");
		
		WebElement originLocation= driver.findElement(By.id("flight-origin-hp-flight"));
		originLocation.click();
		originLocation.clear();
		originLocation.sendKeys("Delhi");
		
		WebElement destinationLocation = driver.findElement(By.id("flight-destination-hp-flight"));
		destinationLocation.click();
		destinationLocation.clear();
		destinationLocation.sendKeys("New York");
		
		WebElement departingDate = driver.findElement(By.id("flight-departing-single-hp-flight"));
		departingDate.click();
		departingDate.clear();
		departingDate.sendKeys("12/13/2020");
		departingDate.sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
		
		//add travelers
		driver.findElement(By.id("traveler-selector-hp-flight")).click();
		String aXpath = "//*[@class = 'uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized']";
		
		
		String ActualAdults= driver.findElement(By.xpath(aXpath + "//*[@class='uitk-step-input-value']")).getText();
			
		int iAdults = 5;
		
		while(Integer.parseInt(ActualAdults) != iAdults) {
			
			if(Integer.parseInt(ActualAdults) > iAdults)
				driver.findElement(By.xpath(aXpath + "//*[@class='uitk-step-input-button uitk-step-input-minus']")).click();
			else
				driver.findElement(By.xpath(aXpath + "//*[@class='uitk-step-input-button uitk-step-input-plus']")).click();
			
			Thread.sleep(1000);
			
			ActualAdults = driver.findElement(By.xpath(aXpath + "//*[@class='uitk-step-input-value']")).getText();
		}
		
		driver.findElement(By.xpath("//*[@class='btn-primary btn-action gcw-submit']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test-id='listing-price-dollars']")));
		
		List<WebElement> prices = driver.findElements(By.xpath("//*[@data-test-id='listing-price-dollars']"));
		
		if(prices.size()>0)
		System.out.println(prices.get(0).getText());
		
		WebElement price = driver.findElement(By.xpath("//*[@data-test-id='listing-price-dollars']"));
		System.out.println(price.getText());
		Select selectSorting  = new Select(driver.findElement(By.id("sortDropdown")));
		selectSorting.selectByVisibleText("Duration (Shortest)");
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test-id='listing-price-dollars']")));
		Thread.sleep(2000);
		WebElement price2 = driver.findElement(By.xpath("//*[@data-test-id='listing-price-dollars']"));
		System.out.println(price2.getText());

	}
	



	}


