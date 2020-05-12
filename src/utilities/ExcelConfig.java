package utilities;

import static org.testng.Assert.assertThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig 
{
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelSheet;
	private static XSSFCell cell;
	private static XSSFRow row;
	
	// for set file mode
	public static void setExcelFile(String path) throws Exception 
	{
		try {
		FileInputStream ExcelFile= new FileInputStream(path);
		XSSFWorkbook ExcelWBook= new XSSFWorkbook(ExcelFile);
		}catch (Exception e)
		{
			System.out.println("class ExcelConfig | method setExcelFile | Exception desc: "+e.getMessage());
			throw (e);
		}
		
	}
	
	// read data  
	public static String getCellData(int rownumber, int colounumber, String sheetname )
	{
		XSSFSheet ExcelSheet=ExcelWBook.getSheet(sheetname);
		try {
			XSSFCell cell = ExcelSheet.getRow(rownumber).getCell(colounumber);
			String cellvalue= cell.getStringCellValue().trim();
		
		return cellvalue;
		}catch (Exception e)
		{
			System.out.println("class ExcelConfig | method getCellData | Exception desc:"+e.getMessage());
			return " ";
		}
		
	}
	
	// write data
	public static void setCellData (String result, int rownumber, int coloumnumber, String sheetname) throws Exception
	{
		ExcelSheet=ExcelWBook.getSheet(sheetname);
		try {
			XSSFRow row= ExcelSheet.getRow(rownumber);
			XSSFCell cell=row.createCell(coloumnumber);
			cell.setCellValue(result);
			String projectpath= System.getProperty("user.div");
			FileOutputStream writtenFile= new FileOutputStream(projectpath+"\\test-resources\\TestData01.xlsx");
			ExcelWBook.write(writtenFile);
			writtenFile.close();
			ExcelWBook=new XSSFWorkbook(new FileInputStream(projectpath+"\\test-resources\\TestData01.xlsx"));
		}catch (Exception e)
		{
			System.out.println("class ExcelConfig |method setCellData |Exception  desc:"+e.getMessage());
			throw (e);
		}
	
	}
	
	//row contains
	public static int getRowContains(String testName,int coloumnumber, String sheetname )
	{
		ExcelSheet=ExcelWBook.getSheet(sheetname);
		int i;
		try
		{ int row_count=ExcelConfig.getRowUsed(sheetname);
			for ( i=0; i<row_count; i++)
			{
				if (ExcelConfig.getCellData(i, coloumnumber, sheetname).equalsIgnoreCase(testName))
				{
					break;
				}
			}
			return i;
		}catch (Exception  e)
		{
			System.out.println("class ExcelConfig | method getRowContains | exception desc:"+e.getMessage());
			throw (e);
		}
		
	}
	
	//getting last row number
	
	public static int getRowUsed (String sheetname)
	{	ExcelSheet= ExcelWBook.getSheet(sheetname);
		try {
		int row_count=	ExcelSheet.getLastRowNum();
		return row_count;
		
			}catch (Exception e)
				{
					System.out.println("class ExcelConfig|method getRowUsed |exception desc: "+e.getMessage());
					throw (e);
				}
			
			
		
	}
	
	
		
}
