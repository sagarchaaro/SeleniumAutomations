package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.Baseclass;

public class CommonMethods extends Baseclass
{
	
	
	public CommonMethods(WebDriver driver) {
		super(driver);
		
	}
		// Login method
	public static void orangeHRMLogin(String username, String password) throws Exception 
	{
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		System.out.println(username+" is entered as Username.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);
		System.out.println(password+ " is entered as password.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='Submit'] [@class='button']")).click();
		System.out.println("Login button is clicked.");
	}
		// Log out method
	public static void orangeHRMLogout () throws Exception
	{
		WebElement element = driver.findElement(By.xpath("//*[@id='account-job']/i"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("HR Link is clicked");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//ul[@id='user_menu']/li[3]/a")).click();
		System.out.println("Logout button is clicked");


	}


}

