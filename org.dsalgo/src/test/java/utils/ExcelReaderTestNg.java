package utils;

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
	
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public int rows;
	public int cols;
	public XSSFCell cell;
	
      Properties prop;
	ConfigReaderTest config;
	
public ExcelReaderTestNg() throws IOException {
	this.config= new ConfigReaderTest();
	this.path= config.readConfig().getProperty("path");
}
// to get row count 

public int row_Count(String sheetName) throws IOException {
	fis = new FileInputStream(path);
	workbook= new XSSFWorkbook(fis);
	sheet = workbook.getSheet(sheetName);
	rows = sheet.getPhysicalNumberOfRows();
	workbook.close();
	fis.close();
	return rows;
}

public int col_Count(String sheetName, int row) throws IOException {
	
	fis = new FileInputStream(path);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheet(sheetName);
	cols = sheet.getRow(row).getLastCellNum();
	return cols;
		
}

//@DataProvider(name="dataPro")
//public String[][] getCellData(String sheetName, int row, int col) throws IOException {	
//	fis = new FileInputStream(path);
//	workbook= new XSSFWorkbook(fis);
//	sheet=workbook.getSheet(sheetName);
//	int rowCount = sheet.getPhysicalNumberOfRows();
//	int cellCount = sheet.getRow(0).getLastCellNum();
//	String[][] data = new String[rowCount-1	][cellCount];
//    for(int i=0;i<rowCount-1;i++) {
//	for(int j=0;j<cellCount;j++) {	
//		XSSFCell cellData = sheet.getRow(i+1).getCell(j);
//		DataFormatter df = new DataFormatter();
//		data[i][j] = df.formatCellValue(cellData);
//		
//	}
//	System.out.println();
//}
//	workbook.close();
//	fis.close();
//	
//	return data;
//	
//}

@DataProvider(name="dataPro")
public String[][] getCellData() throws IOException {	
	fis = new FileInputStream(path);
	workbook= new XSSFWorkbook(fis);
	sheet=workbook.getSheetAt(0);
	int rowCount = sheet.getPhysicalNumberOfRows();
	int cellCount = sheet.getRow(0).getLastCellNum();
	String[][] data = new String[rowCount-1	][cellCount];
    for(int i=0;i<rowCount-1;i++) {
	for(int j=0;j<cellCount;j++) {	
		XSSFCell cellData = sheet.getRow(i+1).getCell(j);
		DataFormatter df = new DataFormatter();
		data[i][j] = df.formatCellValue(cellData);
		
	}
	System.out.println();
}
	workbook.close();
	fis.close();
	
	return data;
	
}



}
