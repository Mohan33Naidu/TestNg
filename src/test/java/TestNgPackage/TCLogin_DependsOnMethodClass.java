package TestNgPackage;

import org.testng.annotations.Test;

public class TCLogin_DependsOnMethodClass {

	@Test (groups="Group1")
	public void Login01() throws Exception {
		System.out.println("Login01");
		//throw new Exception("Error in login 01");
	}
	
	@Test (dependsOnMethods="Login01")
	public void Login02() {
	
		System.out.println("Login02");
	}
	
	@Test (groups="Group1")
	public void Login03() throws Exception {
		System.out.println("Login03");
		throw new Exception();
	}
	@Test(dependsOnGroups="Group1")
	public void Login04() {
		System.out.println("Login04");
	}
}
