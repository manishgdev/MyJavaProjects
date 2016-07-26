import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestOutside {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite Method Executed");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite Method Executed");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test Method Executed");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test method executed");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Class Method Executed");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("After Class Method Executed");
	}
	
	@Test
	public void testMethod() {
		System.out.println("Executing Test Method From outside the Packages");
	}
}
