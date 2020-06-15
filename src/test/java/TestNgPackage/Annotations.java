package TestNgPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	@Test
	public void methodTest() {
		System.out.println("method 1 output");
	}
	@BeforeSuite
	public void methodBS()
	{
		System.out.println("before suite");
	}
	
	@BeforeTest
	public void methodBT() {
		System.out.println("method before test");
	}
	
	@BeforeClass
	public void methodBC() {
		System.out.println("method before class");
	}
	
	@BeforeGroups
	public void methodBG()
	{
		System.out.println("method before group");
	}
	
	@BeforeMethod
	public void methodBM(){
		System.out.println("before method");
	}
	@AfterMethod
	public void methodAM() {
		System.out.println("after method");
	}
	
	@AfterGroups
	public void methodAG() {
		System.out.println("after group");
	}
	
	@AfterClass
	public void methodAC() {
		System.out.println("after class");
	}
	
	@AfterTest
	public void methodAT() {
		System.out.println("after test");
	}
	
	@AfterSuite
	public void methodAS() {
		System.out.println("after suite");
	}
}
	