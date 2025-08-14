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
	    
	
//---------------------------------------------------------------
////package utils;
////
////import java.io.File;
////import java.io.FileInputStream;
////import java.io.IOException;
////import java.util.Arrays;
////import java.util.Properties;
////
////import org.apache.poi.ss.usermodel.DataFormatter;
////import org.apache.poi.xssf.usermodel.XSSFCell;
////import org.apache.poi.xssf.usermodel.XSSFRow;
////import org.apache.poi.xssf.usermodel.XSSFSheet;
////import org.apache.poi.xssf.usermodel.XSSFWorkbook;
////import org.testng.annotations.DataProvider;
////
////public class ExcelReader {
////	
////
////
////
////@DataProvider(name= "validlogin")
////public String[][] getvalidData() throws IOException{
////	     File excelfile= new File("./src/test/resources/testData/data.xlsx");
////	   //  System.out.println(excelfile.exists());//check file is exists 
////	     FileInputStream fis=new FileInputStream(excelfile);//read excel
////	     XSSFWorkbook workbook=new XSSFWorkbook(fis);
////	     XSSFSheet sheet=workbook.getSheet("validlogin");
////	   // System.out.println(sheet.getPhysicalNumberOfRows());//along with header 0,1=2.....
////	     int noofRows= sheet.getPhysicalNumberOfRows();
////	     int noofCols= sheet.getRow(0).getLastCellNum();
////	     System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());//1time
////	     
////	     
////	     String[][] data=new String[noofRows-1][noofCols];
////	     for(int i=0; i<noofRows-1;i++) {
////	    	 for(int j=0;j<noofCols;j++) {
//	  //  System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());//full row 
//	 //   System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());//username 3times
//	  //  System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());	//password 3times
////	    		 DataFormatter df=new DataFormatter();
////	    	data[i][j]=	 df.formatCellValue(sheet.getRow(i+1).getCell(j));
////	    	 }
////	   
////	     }
////	    	
////	     workbook.close();
////	    fis.close();
////	    for(String[] dataArr:data) {
////    	System.out.println(Arrays.toString(dataArr)); 	
////}
////	    return data;}
////}
//	    
////	    
////@DataProvider(name= "validlogin")
////public String[][] getvalidData() throws IOException{
////	     File excelfile= new File("./src/test/resources/testData/data.xlsx");
////	     FileInputStream fis=new FileInputStream(excelfile);//read excel
////	     XSSFWorkbook workbook=new XSSFWorkbook(fis);
////	     XSSFSheet sheet=workbook.getSheet("validlogin");
////	  	     DataFormatter df=new DataFormatter();
////	 	//String password = df.formatCellValue(sheet.getRow(1).getCell(2));
////	  	   String password = df.formatCellValue(sheet.getRow(1).getCell(2));
////	 	int row = 1;
////	 	int Username=1;
////		
////		System.out.println(df.formatCellValue(sheet.getRow(row).getCell(Username)));
////	String username = df.formatCellValue(sheet.getRow(1).getCell(1));
////	 	     String[][] data={ {username,password}};
////	     workbook.close();
////	    fis.close();
////	    return data;
////	    }
////@DataProvider(name= "invalidlogin1")
////public String[][] getinvalidData1() throws IOException{
////	     File excelfile= new File("./src/test/resources/testData/data.xlsx");
////	     FileInputStream fis=new FileInputStream(excelfile);//read excel
////	     XSSFWorkbook workbook=new XSSFWorkbook(fis);
////	     XSSFSheet sheet=workbook.getSheet("login");
////	  	     DataFormatter df=new DataFormatter();
////	 	String password = df.formatCellValue(sheet.getRow(1).getCell(1));
////	String username = df.formatCellValue(sheet.getRow(1).getCell(0));
////	 	     String[][] data={ {username,password}};
////	     workbook.close();
////	    fis.close();
////	    return data;
////	    }
////
////
////}
////
////	
////	
//	
//
//	
//	
//	
////	
//package utils;
//
//import java.io.FileInputStream;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Iterator;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//	public FileInputStream fis;
//	// public FileOutputStream fos;
//	public XSSFWorkbook wb;
//	public XSSFSheet sheet;
//	public XSSFRow row;
//	public XSSFCell cell;
//	ConfigReader config;
//	String xlfilePath;
//	HashMap<String, Integer> colNums = null;
//
//	public ExcelReader() throws IOException {
//		this.config = new ConfigReader();
//		this.xlfilePath = config.get_prop_value("path");
//		this.fis = new FileInputStream(xlfilePath);
//		this.wb = new XSSFWorkbook(fis);
//
//	}
//
//	public void populateColumNums() {
//		colNums = new HashMap<String, Integer>();
//		int colIndex = 0;
//		row = sheet.getRow(0);
//		Iterator<Cell> cells = row.cellIterator();
//		while (cells.hasNext()) {
//			Cell cell = cells.next();
//			String cellName = cell.getStringCellValue();
//			colNums.put(cellName, colIndex);
//			colIndex++;
//		}
//	}
//
////	public int getColNumber(String cellName) {
////		return colNums.get(cellName);
////	}
//
//	public String getData(String sheetName, int rowNum, String cellName) throws IOException {
//		sheet = wb.getSheet(sheetName);
//		populateColumNums();
//		String cellData = "";
//		//int cellNum = getColNumber(cellName);
//		int cellNum = colNums.get(cellName);
//		cellData = getData_UsingColNum(sheetName, rowNum, cellNum);
//		return cellData;
//
//	}
//
//	public String getData_UsingColNum(String sheetName, int rowNum, int cellNum) throws IOException {
//
//		sheet = wb.getSheet(sheetName);
//
//		row = sheet.getRow(rowNum);
//		cell = row.getCell(cellNum);
//		String cellData;
//		try {
//			DataFormatter df = new DataFormatter();
//			cellData = df.formatCellValue(cell);
//		} catch (Exception e) {
//			cellData = "";
//		}
//		return cellData;
//
//	}
//	
//	public Object[] getCode(String sheetName) throws IOException {
//		sheet = wb.getSheet(sheetName);
//		Object[] data = new Object[sheet.getLastRowNum()];
//		for(int i=0; i<sheet.getLastRowNum(); i++) {
//			data[i]= sheet.getRow(i+1).getCell(0).toString();
//		}
//		
//        return data;
//	}
//
//}	
//	
		@DataProvider(name= "validlogin")
		public String[][] getlogvalidData() throws IOException{
			Map<String, String> testData = ExcelReader.readExcelRow("Valid credential", "Sheet1");
		  	   String username = testData.get("UserName");
		  	   String password = testData.get("Password");
		  	  
		  	 // String expsuccessmsg = testData.get("ExpectedMsg");
		  	 //System.out.println(expsuccessmsg);
//		  	   Map<String, String> testData1 = ExcelReader.readExcelRow("ValidInput", "Sheet1");
//		  	 String username1 = testData1.get("Input");
//		  	
//		  	   String password1 = testData1.get("Output");
		 	   String[][] data={ {username,password}};
		 	                             // {username1,password1}};
		    return data;
		    }
		@DataProvider(name= "invalidlogin")
		public String[][] getloginvalidData() throws IOException{
			Map<String, String> testData1 = ExcelReader.readExcelRow("Login1", "Sheet1");
		  	   String username1 = testData1.get("UserName");
		  	   String password1 = testData1.get("Password");
		  	   
	  	   Map<String, String> testData2 = ExcelReader.readExcelRow("Login2", "Sheet1");
	  	 String username2 = testData2.get("UserName");
	  	 String password2 = testData2.get("Password");
	  	 
	  	  Map<String, String> testData3 = ExcelReader.readExcelRow("Login3", "Sheet1");
		  	 String username3 = testData3.get("UserName");
		  	 String password3 = testData3.get("Password");
		  	 
		  	 Map<String, String> testData4 = ExcelReader.readExcelRow("Login4", "Sheet1");
		  	 String username4 = testData4.get("UserName");
		  	 String password4 = testData4.get("Password");
	  	 
		 	   String[][] data={ {username1,password1},
		 	                              {username2,password2},
		 	                             {username3,password3},
		 	                            {username4,password4}};
		    return data;
		    }
}

