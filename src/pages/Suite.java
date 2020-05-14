package pages;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.ExtentManage;
import utilities.Utils;

public class Suite {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static String reportPath;
	@BeforeSuite
	public void setup(){
		reportPath=Utils.createFolder();
		htmlReporter = ExtentManage.getExtentHtmlReport(reportPath);
		report=ExtentManage.getExtentReport(htmlReporter);
	}
}
