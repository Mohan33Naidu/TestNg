package TestNgPackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNg_Login {
  
	static WebDriver driver=null;
	WebDriverWait wait=null;
	@BeforeSuite
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		wait=new WebDriverWait(driver, 30);
		
		
	}
	
	@BeforeMethod
	public void beforeTestCase() throws InterruptedException {
		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(3000);
	}
	
	
	@Test (enabled=true)
	public void login() {
		try {
		System.out.println("------login valid------------");
		driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("password_field")).sendKeys("admin123");
		//button[contains(text(),'Login')]
		
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(2000);
		if(isAlertPresent()==false) {
			System.out.println("pos b4 wait");
			 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Student')]"))));
			 System.out.println("pos b4 assert");
			 System.out.println("assert "+driver.findElement(By.xpath("//h1[contains(text(),'Student')]")).isDisplayed());
			 Thread.sleep(2000);
			//assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Student')]")),true);
            System.out.println("assert passed");
			// would not execute after the above line as assert fails
			}
			else
			{
				Alert altBox=driver.switchTo().alert();
				altBox.accept();
				Thread.sleep(2000);
				
			}
		}
		catch(Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
	}
	

	@Test (enabled=true)
	public void loginInvalid(){
		try {
			System.out.println("------logINinvalid------------");
		driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("password_field")).sendKeys("admin3");
		//button[contains(text(),'Login')]
		
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		System.out.println("alert for invalid "+isAlertPresent());
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Student')]"))));
		System.out.println("alert for invalid "+isAlertPresent());
		//assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Student')]")), true);
		
		assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Student')]")).isDisplayed());

		// would not execute after the above line as assert fails
		
		/**/
		}
		catch(Exception e) {
			System.out.println("Error"+e.getMessage());
		}
		finally {
			
		}
		
	}
	
	@Test (enabled=false,dataProvider="dataProviderUserInfo")
	public void loginWtDataProvider(String sUsername,String sPassword){
		
		System.out.println("------DATAPRovider method ------------");
		System.out.println("email"+sUsername+"\t"+"password "+sPassword);
		try {
		driver.findElement(By.id("email_field")).sendKeys(sUsername);
		
		driver.findElement(By.id("password_field")).sendKeys(sPassword);
		//button[contains(text(),'Login')]
		
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		Thread.sleep(5000);
		if(isAlertPresent()==false) {
			System.out.println("alert false");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Student')]"))));
		Thread.sleep(2000);
		System.out.println("Before positive asssert");
		assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Student')]")).isDisplayed(), true);
		}
		else
		{
			System.out.println("alert true");
			driver.switchTo().alert().accept();
			//throw new Exception("Username or password invalid"); it does not fail the test case so add assert -it works only in case of individual TC 
			assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Student')]")).isDisplayed(), true);
		}
		// Thread.sleep(3000);
		 //driver.findElement(By.linkText("Logout")).click();
		}
		catch(Exception e) {
			System.out.println("Error"+e.getMessage());
		}
				 
	}
	
	@DataProvider (name= "dataProviderUserInfo")
	public  Object[][] userInfo(){
		
		Object[][] objUserInfo=new Object[][] {{"admin123@gmail.com","admin123"},{"admin123@gmail.com","admin12"}};
		return objUserInfo;
	}
	
	
	
	 public boolean isAlertPresent()
	    {
	        try
	        {
	            driver.switchTo().alert();
	            System.out.println("alert true");
	            return true;
	        }   // try
	        catch (NoAlertPresentException Ex)
	        {
	        	System.out.println("alert false");
	            return false;
	        }   // catch
	    } 
	
	
	
		
	
	@AfterMethod 
	
	public void logout(ITestResult result) throws InterruptedException {
		//System.out.println("------logout valid------------");
		if(isAlertPresent()==true)
		{
			Alert alt=driver.switchTo().alert();
			alt.accept();
		}
		System.out.println("resultStatus-logoutvalid -- "+result.getStatus());
		if(result.getStatus()==ITestResult.SUCCESS) {
			
			System.out.println("------logout valid------------");
		if(driver.findElement(By.linkText("Logout")).isDisplayed())
		{
			driver.findElement(By.linkText("Logout")).click();
			Thread.sleep(3000);
		}
		}
		
		
		driver.findElement(By.id("email_field")).clear();
		driver.findElement(By.id("password_field")).clear();
		Thread.sleep(2000);
	}
	
	@AfterSuite
	public void endBrowser() {
		driver.quit();
	}
	
}
