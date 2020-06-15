package TestNgPackage;

import org.testng.annotations.Test;

public class TestCase_HomeGroup {

	@Test (groups="SanityGroup")
	public void Home01() {
		System.out.println("Home01");
	}
	
	@Test (groups="RegrssnGroup")
	public void Home02() {
		System.out.println("Home02");
	}
	
	@Test (groups= {"SanityGroup","RegrssnGroup"})
	public void Home03() {
		System.out.println("Home03");
		/*try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
		
	
}
