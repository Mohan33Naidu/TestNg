package TestNgPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcel {

	@Test(dataProvider="ExcelInfo")
	public void ReadExcel(String sName,String sDesignation,String sEmail) {
		System.out.println("name:"+sName+"\t"+"Des:"+sDesignation+"\t"+"Email:"+sEmail);
	}
	
	@DataProvider (name="ExcelInfo")
	public Object[][] ReadExcelFile() throws IOException{
		
		String sFilePath=System.getProperty("user.dir")+"\\src\\test\\java\\TestNgPackage\\Data.xls";
		
		return ReadExcelInfo(sFilePath);
		
	}
	
	public Object[][] ReadExcelInfo(String sFilePath){
		Object[][] objExcelData=null;
		try {
		FileInputStream fi=new FileInputStream(sFilePath);
		HSSFWorkbook workbook=new HSSFWorkbook(fi);
		
		HSSFSheet sheet=workbook.getSheetAt(0);
		int iRowCount=sheet.getPhysicalNumberOfRows();
		int iColCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(iRowCount +"--\t---"+iColCount);
		
		objExcelData=new Object[iRowCount][iColCount];
		String temp=null;
		for(int irow=0;irow<iRowCount;irow++)
		{
			
			for(int iCol=0;iCol<iColCount;iCol++) {
				
				HSSFRow rowTemp=sheet.getRow(irow);
 			    temp=rowTemp.getCell(iCol).getStringCellValue();
 			    
 			   objExcelData[irow][iCol]=temp;
			}
			
		}
		
		
		}
		 catch (Exception e) {
			System.out.println("Error:"+e.getMessage());
		}
		return objExcelData;
		
	}
}
