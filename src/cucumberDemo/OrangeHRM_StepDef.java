package cucumberDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BaseClass;
import utilities.Log;
import utilities.Utils;

public class OrangeHRM_StepDef {
	WebDriver driver;
	@And("^chrome browser is loaded with OrangeHRM application$")
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://seleniumprep-trials65101.orangehrmlive.com");
		System.out.println("Orange HRM application is loaded");
	}
	
	@And("^Username data is entered$")
	public void setuserName(){
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("UserName is entered");
	}
	
	@Then("^Password data is entered$")
	public void setPassword(){
		driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
		System.out.println("Password is entered");
	}
	
	@Then("^Click on Login button$")
	public void clickOnLogin(){
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("Login button is clicked");
	}
	
	
}
