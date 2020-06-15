package TestNgPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSample {

	
	
	@Test(dataProvider="Data_Userdetails")
	public void login01(String sUsername,String sPwd) {
		System.out.println(sUsername+"\t"+sPwd);
	}
	
	
	@DataProvider (name="Data_Userdetails")
	public Object[][] userDetails()
	{
		Object[][] oUserDetails=new Object [][]{{"admin123@gmail.com","admin123"},{"admin123@gmail.com","ad123"}};
		return oUserDetails;
		
	}
}
