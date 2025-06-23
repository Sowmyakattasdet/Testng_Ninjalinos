package testsuite;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Module2 {
	
	
	@Test
	public void test004(){
		System.out.println("executing test001");
	}
	@Test
	public void test005(){
		System.out.println("executing test002");
	}
	@Test
	public void test006(){
		System.out.println("executing test003");
	}
	@DataProvider
	public Object[][] data001(){
		Object[][] data={{"sowmya","pwsd001"},{"katta","pwsd002"}};
		return data;
	}
	@Test(dataProvider="data001")
	public void login(String username,String pasword) {
		System.out.println(username+" " +pasword);
	}
	
	
	
	
	
	
	
	

}
