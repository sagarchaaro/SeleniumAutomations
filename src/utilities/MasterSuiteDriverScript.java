package utilities;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class MasterSuiteDriverScript {
	
	public static Method[] method;
	public static int iTestCase;
	public static int iTestLastCase;
	public static String sTestName;
	public static String iTestNumber;
	public static String sTestID;
	public static String sRunMode;
	
	public static int count=0,pos=0;
	public static int[] TestPosition=new int[10];
	public static boolean isSkipfalse;

	public static void main(String args[]) throws Exception{
		String projectPath=System.getProperty("user.dir");
		Log.info("Project Path is :"+projectPath);
		
		ExcelConfig.setExcelFile(projectPath+"\\test-resources\\TestData.xlsx");
		MasterSuiteDriverScript startEngine=new MasterSuiteDriverScript();
		startEngine.execute_TestCase();
	}
	
	public void execute_TestCase() throws Exception{
		String projectPath=System.getProperty("user.dir");
		Log.info("Project Path is :"+projectPath);
		
		int iTotalTestCases=ExcelConfig.getRowUsed("TestCases");
		XmlSuite suite=new XmlSuite();
		try{
			File file=new File(projectPath+"\\test-resources\\MasterSuite.xml");
			file.delete();
			Log.info("Test results for previous cycle were removed from the directory");
		}catch(Exception e){
			Log.info("No Previous test results are available. "+e);
		}
		for(int iTestCase=1;iTestCase<=iTotalTestCases;iTestCase++){
			sTestName=ExcelConfig.getCellData(iTestCase, Constant.col_testcaseName, "TestCases");
			sTestID=ExcelConfig.getCellData(iTestCase, Constant.col_testcaseID, "TestCases");
			iTestNumber=ExcelConfig.getCellData(iTestCase, Constant.col_sno, "TestCases");
			sRunMode=ExcelConfig.getCellData(iTestCase, Constant.col_RunMode,"TestCases");
			if(sRunMode.equalsIgnoreCase("Yes")){
				iTestCase=ExcelConfig.getRowContains(sTestID, Constant.col_testcaseID, "TestCases");
				suite.setName("OrangeHRM_Regression_Suite");
				XmlTest test=new XmlTest(suite);
				test.setName(sTestName+"-"+sTestID);
				Map<String, String> parameters=new HashMap<String, String>();
				parameters.put("testID",sTestID);
				test.setParameters(parameters);
				List<XmlClass> classes=new ArrayList<XmlClass>();
				classes.add(new XmlClass("testcases."+sTestName));
				test.setXmlClasses(classes);
			}
		}
		FileWriter writer=new FileWriter(new File(projectPath+"\\test-resources","MasterSuite.xml"));
		writer.write(suite.toXml());
		writer.flush();
		writer.close();
		Log.info("MasterSuite.xml file is generated");
	}
	

}