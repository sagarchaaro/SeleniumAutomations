package cucumberDemo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			plugin={"pretty", 
			"html:cucumberReports/cucumber-htmlreport",
			"json:cucumberReports/cucumber-report.json",}
)
public class Runner {

}
