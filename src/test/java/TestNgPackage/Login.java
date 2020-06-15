package TestNgPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login {

	Logger log=Logger.getLogger(getClass().getSimpleName());
	
	@BeforeSuite
	public void loadProp() throws Exception {
		
		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\TestNgPackage\\log.properties");
		Properties props=new Properties();
		props.load(fi);
		PropertyConfigurator.configure(props);
		
	}
	
	@Test
	public void Login01() {
		System.out.println("Test Login01 ");
		log.info("@TEST LOGIN 1");
		//Assert.assertTrue(1==3);
		SoftAssert verify=new SoftAssert();
		//System.out.println("end of prog");
				//verify.assertTrue(1==3);
				verify.assertTrue(1==8);
				System.out.println("assert 1");
				//verify.assertTrue(1==1);
				System.out.println("assert 2");
				verify.assertAll();
	}
	
	@Test
	public void Login02() {
		System.out.println("Tesst Login02 ");
		log.info("@TEST:Login02");
	}
	
	@Test
	public void Login03() {
		System.out.println("Test Login03");
		log.info("@TEST:Login03");
	}
	
	@Test
	public void Login04() {
		System.out.println("Tesst Login04 ");
		log.info("@TEST:Login04");
	}
	
	
}
