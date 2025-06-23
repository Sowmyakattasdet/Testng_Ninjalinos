package testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Module1 {

	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("beforemethod");
	} 
	@Test
	public void test001(){
		System.out.println("executing test001");
	}
	@Test
	public void test002(){
		System.out.println("executing test002");
	}
	@Test (groups = {"smoke"})
	public void test003(){
		System.out.println("executing test003");
	}
		
		@AfterMethod
		public void aftermethod()
		{
			System.out.println("aftermethod");
		}
	}
	


