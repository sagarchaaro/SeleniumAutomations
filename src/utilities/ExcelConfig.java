package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;
	
	public static void setExcelFile(String path) throws Exception{
		try{
			FileInputStream ExcelFile=new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
		}
		catch(Exception e){
			Log.info("class ExcelConfig | Method setExcelFile | Exception desc: "+e.getMessage());
			throw(e);
		}
	}
	
	public static String getCellData(int iRowNum, int iColNum, String sSheetName) throws Exception{
		ExcelWSheet=ExcelWBook.getSheet(sSheetName);
		try{
			String cellData=ExcelWSheet.getRow(iRowNum).getCell(iColNum).getStringCellValue().trim();
			return cellData;
		}catch(Exception e){
			Log.info("class ExcelConfig|Method getCellData| Exception desc:"+e.getMessage());
			return "";
		}		
		
	}
	
	public static void setCellData(String sResult, int iRowNum, int iColNum, String sSheetName) throws Exception{
		ExcelWSheet=ExcelWBook.getSheet(sSheetName);
		try{
			row=ExcelWSheet.getRow(iRowNum);
			cell=row.createCell(iColNum);
			cell.setCellValue(sResult);
			String projectPath=System.getProperty("user.dir");
			FileOutputStream fileOut=new FileOutputStream(projectPath+"\\test-resources\\TestData.xlsx");
			ExcelWBook.write(fileOut);
			Log.info(sResult+" is updated in Excel Sheet in RowNumber :"+iRowNum+" ColumnNumber :"+iColNum+" of sheet :"+sSheetName);
			fileOut.close();
		}catch(Exception e){
			Log.info("class ExcelConfig| Method setCellData |Exception desc: " +e.getMessage());
			throw(e);
		}
	}
	public static int getRowContains(String sTestName, int iColNum, String sSheetName) throws Exception{
		int i;
		ExcelWSheet=ExcelWBook.getSheet(sSheetName);
		try{
			int iRowCount=getRowUsed(sSheetName);
			for(i=0;i<iRowCount;i++){
				String excelData=ExcelConfig.getCellData(i, iColNum, sSheetName);
				if(excelData.equalsIgnoreCase(sTestName)){
					break;
				}
			}
			return i;
		}catch(Exception e){			
			Log.info("Class ExcelConfig | Method getRowContains |Exception desc:"+e.getMessage());
			throw(e);
		}
	}
	public static int getRowUsed(String sSheetName) throws Exception{
		ExcelWSheet=ExcelWBook.getSheet(sSheetName);
		try{
			int iRowCount=ExcelWSheet.getLastRowNum();
			return iRowCount;
		}catch(Exception e){
			Log.info("Class ExcelConfig | Method getRowUsed | Exception desc: "+e.getMessage());
			throw(e);
		}
	}


}