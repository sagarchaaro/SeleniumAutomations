package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_04_Addvacancy {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium Catalogue\\Drivers\\Chrome\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://seleniumtesters-trials6562.orangehrmlive.com/auth/login");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println("Title of website is .." + title);
		if (title.equalsIgnoreCase("OrangeHRM")) {
			System.out.println("Title is a correct.");
		} else {
			System.out.println("Title is a Wrong.");
		}

		// username

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		System.out.println("Username is entered.");

		// password
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Admin@123");
		System.out.println("Password is entered.");

		// login
		driver.findElement(By.xpath("//input[@name='Submit'] [@class='button']")).click();
		System.out.println("Login is clicked.");

		// Click on Recruitment link
		driver.findElement(By.xpath("//div[@id='menu-content']/ul/li[6]/a")).click();
		System.out.println("Recruitment link is clicked.");

		// Click on + button (Add or Import Vacancy);-

		driver.switchTo().frame("noncoreIframe");
		Actions add_action = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//a[@id='addItemBtn']/i"));
		add_action.moveToElement(target).perform();
		System.out.println("Add Vacancy button is clicked.");

		// Click on + button (Add new vacancy)

		driver.findElement(By.xpath("//a[@id='addItemBtn']/../ul/li[2]/a/i")).click();
		System.out.println("Add new Vacancy button is clicked.");
		Thread.sleep(1000);

		// Enter the Vacancy as "Testing_<Some Name>"
		RandomStringUtils add_name = new RandomStringUtils();
		String given_name = add_name.randomAlphabetic(6);

		driver.findElement(By.xpath("(//div[@id='addVacancyFormDiv']/div[2]/form/div/div/input)[1]"))
				.sendKeys(given_name);
		System.out.println("Vacancy name is added.");

		// Select the Job Title as "Account & cleark"
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//form[@id='addJobVacancyForm']/div[1]/div/label)[2]/../div")));
		driver.findElement(By.xpath("(//form[@id='addJobVacancyForm']/div[1]/div/label)[2]/../div")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='searchObjectA'])[1]/p")));
		driver.findElement(By.xpath("(//a[@class='searchObjectA'])[1]/p")).click();
		System.out.println("Account & cleark is printed");

		// Select the Location as "UnitedBrjhxF"
		driver.findElement(By.xpath("//div[@data-id='addJobVacancy_location']")).click();

		driver.findElement(By.xpath("//ul[contains(@class,'dropdown-content dropdownObjectSearch ')]/div/li[13]/a/p"))
				.click();
		System.out.println("UnitedBrjhxF printed");

		// Select the Subunit as "QA Team"
		driver.findElement(By
				.xpath("//div[contains(@data-id,'addJobVacancy_sub_unit')]/div[@id='textarea_addJobVacancy_sub_unit']"))
				.click();
		driver.findElement(By.xpath("//div[contains(@data-id,'addJobVacancy_sub_unit')]/../div/ul/div/li[2]/a/p"))
				.click();
		System.out.println("QA team silected");

		// Select the Hiring Manager as "Aaliya Haq"

		// List<WebElement>
		// list_manger=driver.findElements(By.xpath("(//div[@class='employee-choices'])[1]/li/a/p"));

		driver.findElement(By.xpath("//div[@id='textarea_addJobVacancy_hiringManagers']")).click();
		driver.findElement(By.xpath("//div[@id='textarea_addJobVacancy_hiringManagers']/../ul/div/li[1]/a/p")).click();
		System.out.println("Aaliya Haq selected");

		// enter no of position
		driver.findElement(By.xpath("//input[@id='addJobVacancy_noOfPositions']")).sendKeys("5");
		System.out.println("no 5 added");

		// click on save button
		driver.findElement(By.xpath("//a[@id='saveVacancy']")).click();
		System.out.println("saved");
		Thread.sleep(2000);

		// Click on Global Manager HR Link
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='material-icons mdi-navigation-menu']")));
		driver.findElement(By.xpath("//i[@class='material-icons mdi-navigation-menu']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='meterialize-menu'])[1]/a")));
		driver.findElement(By.xpath("(//li[@class='meterialize-menu'])[1]/a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='material-icons']")));
		driver.findElement(By.xpath("//i[@class='material-icons']")).click();
		System.out.println("Global Manager HR Link clicked");
		Thread.sleep(1000);

		// Click on Logout link

		driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
		System.out.println("Click on Logout linked");

		// Close the Browser
		driver.close();
		System.out.println("Its working.. no worries... (@ ^ @)");

	}

}
