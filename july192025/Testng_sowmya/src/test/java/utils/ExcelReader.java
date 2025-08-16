package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {
	
		private static final String STRING = null;
		public static String filePath = "./src/test/resources/testdata/TestNG_data.xlsx";
		


		public static Map<String, String> readExcelRow(String ScenarioName, String sheetName) {
		    Map<String, String> testData = new HashMap<>();
		    DataFormatter formatter = new DataFormatter();

		    try (FileInputStream fis = new FileInputStream(filePath);
		         Workbook workbook = new XSSFWorkbook(fis)) {

		        Sheet sheet = workbook.getSheet(sheetName);
		        Row header = sheet.getRow(0);

		        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		            Row row = sheet.getRow(i);
		            String scenario = formatter.formatCellValue(row.getCell(0)).trim();

		            if (scenario.equalsIgnoreCase(ScenarioName.trim())) {
		                for (int j = 1; j < row.getLastCellNum(); j++) {
		                    String key = formatter.formatCellValue(header.getCell(j)).trim();
		                    String value = formatter.formatCellValue(row.getCell(j)).trim();
		                    testData.put(key, value);
		                }
		                break; 
		            }
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return testData;
		}
	    
		
		@DataProvider(name= "validRegister")
		public String[][] getvalidregister() throws IOException{
			Map<String, String> testData = ExcelReader.readExcelRow("validRegister", "Sheet1");
		  	   String username = testData.get("UserName");
		  	   String password = testData.get("Password");
		  	 String confirmpassword = testData.get("Confirmpassword");
		  	 //  System.out.println( testData.get("ErrorMessage"));
		 	   String[][] data={ {username,password,confirmpassword}};
		 	                             
		    return data;
		    }
		@DataProvider(name= "validinvalidRegister")
		public String[][] getinvalidregister() throws IOException{
			Map<String, String> testData = ExcelReader.readExcelRow("validRegister", "Sheet1");
		  	   String username = testData.get("UserName");
		  	   String password = testData.get("Password");
		  	 String confirmpassword = testData.get("Confirmpassword");
			
			Map<String, String> testData1 = ExcelReader.readExcelRow("Register1", "Sheet1");
		  	   String username1 = testData1.get("UserName");
		  	   String password1 = testData1.get("Password");
		  	 String confirmpassword1 = testData1.get("Confirmpassword");
		  	 
		  	Map<String, String> testData2 = ExcelReader.readExcelRow("Register2", "Sheet1");
		  	   String username2 = testData2.get("UserName");
		  	   String password2 = testData2.get("Password");
		  	 String confirmpassword2 = testData2.get("Confirmpassword");
		  	 
		  	Map<String, String> testData3 = ExcelReader.readExcelRow("Register3", "Sheet1");
		  	   String username3 = testData3.get("UserName");
		  	   String password3 = testData3.get("Password");
		  	 String confirmpassword3 = testData3.get("Confirmpassword");
		  	 
		  	Map<String, String> testData4 = ExcelReader.readExcelRow("Register4", "Sheet1");
		  	   String username4 = testData4.get("UserName");
		  	   String password4 = testData4.get("Password");
		  	 String confirmpassword4 = testData4.get("Confirmpassword");
		  	 
		  	Map<String, String> testData5 = ExcelReader.readExcelRow("Register5", "Sheet1");
		  	   String username5 = testData5.get("UserName");
		  	   String password5 = testData5.get("Password");
		  	 String confirmpassword5 = testData5.get("Confirmpassword");
		  	   
		 	   String[][] data={{username,password,confirmpassword},
		 			   {username1,password1,confirmpassword1}
//		 			  {username2,password2,confirmpassword2},
//		 			 {username3,password3,confirmpassword3},
//		 			 {username4,password4,confirmpassword4},
//		 			{username5,password5,confirmpassword5}
		 	   };
		 	                             
		    return data;
		    }
		
		
		
		
		
		
		
}

