package TestNgPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

public class DataProviderAspose {

	@Test (dataProvider="AsposeData")
	public void ReadExcel(String Name,String Position,String email) {
		System.out.println(Name+"\t"+Position+"\t"+email);
	}
	
	@DataProvider (name="AsposeData")
	public Object[][] ReadExcelFile() throws Exception {
		String sFilePath=System.getProperty("user.dir")+"\\src\\test\\java\\TestNgPackage\\Data.xls";
		return ReadExcelData(sFilePath);
	}

	public Object[][] ReadExcelData(String sFilePath) throws Exception {
		
		FileInputStream fi=new FileInputStream(sFilePath);
		Workbook wb=new Workbook(fi);
		
		Worksheet sheet=wb.getWorksheets().get(0);
		//Worksheet worksheet = workbook.getWorksheets().get(0);
		Object[][] dataTable = sheet.getCells().exportArray(0,0,3,3);
		fi.close();
		return dataTable;
		
		//return null;
	}
}
