package cucumberDemo;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class StepDef1 {
	@And("^Validate the Dahsboard text$")
	public void validateDashboard(){
		
			System.out.println("Dashboard is not present on Homepage");
		
	}
	
	@When("^EmployeeName is clicked and logout link is clicked$")
	public void logout()throws Exception{
		
		System.out.println("Clicked on Employee Name");
		
		Thread.sleep(5000);
		
		System.out.println("logout link is clicked");
		
	}
	
	@And("^Close the Driver$")
	public void closeDriver(){
		
		System.out.println("Driver Object is closed");
	}
}
