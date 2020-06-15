package TestNgPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class annotation_priority {

	@BeforeSuite
	public void methBF1() {
		System.out.println("before suite methBF1");
	}
	
	@BeforeClass
	public void methclass()
	{System.out.println("before class");}
	@BeforeSuite
	public void meth1BF2(){
		System.out.println("before suite meth1BF2");
	}
	
	@AfterSuite
	public void methAFSuite(){
		System.out.println("After Suite");
	}
	
	@AfterTest
	public void methAfTest() {
		System.out.println("After test");
	}
	
	@BeforeTest
	public void methBFTest() {
		System.out.println("Before Test");
	}
	
	@BeforeMethod
	public void methBFMethod() {
		System.out.println("before method");
	}
	
	@AfterMethod
	public void methAFMethod() {
		System.out.println("after method");
	}
	@Test (priority=-1)
	public void meth1() {
		System.out.println("@Test meth1");
	}
	
	@Test 
	public void meth2() {
		System.out.println("@Test meth2");
	}
	
	@Test
	public void Meth1() {
		System.out.println("@Test Meth1");
			
	}
	
	@Test
	public void ameth1() {
		System.out.println("@Test ameth1");
	}
	
	@Test
	public void a1meth1() {
		System.out.println("@Test a1meth1");
	}
	
	@Test (enabled=false)
	public void a1meth2() {
		System.out.println("@Test a1meth2");
	}
	
	@Test (priority=10)
	public void A1M1() {
		System.out.println("@Test A1M1");
	}
	
	@AfterClass
	public void methclass2() {
		System.out.println("after class");
	}
}
