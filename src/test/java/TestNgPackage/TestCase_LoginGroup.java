package TestNgPackage;

import org.testng.annotations.Test;

public class TestCase_LoginGroup {

	@Test (groups="SanityGroup")
	public void Login01() {
		System.out.println("Login01");
	}
	
	@Test (groups="RegrssnGroup")
	public void Login02() {
		System.out.println("Login02");
	}
}
