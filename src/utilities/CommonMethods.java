package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BaseClass;

public class CommonMethods extends BaseClass{
	
	public CommonMethods(WebDriver driver) {
		super(driver);
	}

	public static void orangeHRMLogin(String username, String password){
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);
		Log.info(username+" is entered as Username");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);
		Log.info(password+" is entered as Password");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		Log.info("Login button is clicked");	
	}
	
	public static void orangeHRMLogout() throws Exception{
		WebElement element = driver.findElement(By.xpath("//*[@id='account-job']/i"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='account-job']/i")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Log.info("Employee Name is clicked");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul[@id='user_menu']/li[3]/a")).click();
		Log.info("Logout button is clicked");
	}
	
	public static void selectDropDown(){
		
	}
	
}
