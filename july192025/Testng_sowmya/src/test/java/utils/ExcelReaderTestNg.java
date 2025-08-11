package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReaderTestNg {
	



//@DataProvider(name= "validlogin")
//public String[][] getvalidData() throws IOException{
//	     File excelfile= new File("./src/test/resources/testData/data.xlsx");
//	   //  System.out.println(excelfile.exists());//check file is exists 
//	     FileInputStream fis=new FileInputStream(excelfile);//read excel
//	     XSSFWorkbook workbook=new XSSFWorkbook(fis);
//	     XSSFSheet sheet=workbook.getSheet("validlogin");
//	   // System.out.println(sheet.getPhysicalNumberOfRows());//along with header 0,1=2.....
//	     int noofRows= sheet.getPhysicalNumberOfRows();
//	     int noofCols= sheet.getRow(0).getLastCellNum();
//	     System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());//1time
//	     
//	     
//	     String[][] data=new String[noofRows-1][noofCols];
//	     for(int i=0; i<noofRows-1;i++) {
//	    	 for(int j=0;j<noofCols;j++) {
//	  //  System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());//full row 
//	 //   System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());//username 3times
//	  //  System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());	//password 3times
//	    		 DataFormatter df=new DataFormatter();
//	    	data[i][j]=	 df.formatCellValue(sheet.getRow(i+1).getCell(j));
//	    	 }
//	   
//	     }
//	    	
//	     workbook.close();
//	    fis.close();
////	    for(String[] dataArr:data) {
////    	System.out.println(Arrays.toString(dataArr)); 	
////}
//	    return data;}

	    
	    
@DataProvider(name= "validlogin")
public String[][] getvalidData() throws IOException{
	     File excelfile= new File("./src/test/resources/testData/data.xlsx");
	     FileInputStream fis=new FileInputStream(excelfile);//read excel
	     XSSFWorkbook workbook=new XSSFWorkbook(fis);
	     XSSFSheet sheet=workbook.getSheet("validlogin");
	  	     DataFormatter df=new DataFormatter();
	 	//String password = df.formatCellValue(sheet.getRow(1).getCell(2));
	  	   String password = df.formatCellValue(sheet.getRow(1).getCell(2));
	 	int row = 1;
	 	int Username=1;
		
		System.out.println(df.formatCellValue(sheet.getRow(row).getCell(Username)));
	String username = df.formatCellValue(sheet.getRow(1).getCell(1));
	 	     String[][] data={ {username,password}};
	     workbook.close();
	    fis.close();
	    return data;
	    }
@DataProvider(name= "invalidlogin1")
public String[][] getinvalidData1() throws IOException{
	     File excelfile= new File("./src/test/resources/testData/data.xlsx");
	     FileInputStream fis=new FileInputStream(excelfile);//read excel
	     XSSFWorkbook workbook=new XSSFWorkbook(fis);
	     XSSFSheet sheet=workbook.getSheet("login");
	  	     DataFormatter df=new DataFormatter();
	 	String password = df.formatCellValue(sheet.getRow(1).getCell(1));
	String username = df.formatCellValue(sheet.getRow(1).getCell(0));
	 	     String[][] data={ {username,password}};
	     workbook.close();
	    fis.close();
	    return data;
	    }


}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
