package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.azure.core.util.polling.SyncOperationResourcePollingStrategy;

public class ExcelReaderTestNg {
	
	
	public FileInputStream fis;
	public XSSFWorkbook wb;	
	public XSSFSheet sheet;
	private XSSFRow row;
      Properties prop;
	ConfigReaderTest config;
	public String xlfilePath;
	HashMap<String, Integer> colNames=null;
	
public ExcelReaderTestNg() throws IOException {
	this.config= new ConfigReaderTest();
	this.xlfilePath = config.readConfig().getProperty("path");
	this.fis =new FileInputStream(xlfilePath);
	this.wb= new XSSFWorkbook(fis);
}
// 


//get colName
public void getColName() throws IOException {
	
	 if (colNames == null) { 
	colNames = new HashMap<String, Integer>();
	int colIndex=0;
	sheet= wb.getSheet("TestData");
	row = sheet.getRow(0);
	for (Cell celldata : row) {
		String stringValue = celldata.getStringCellValue().trim();
		colNames.put(stringValue, colIndex);
		colIndex++;
		System.out.println(stringValue+": "+ colIndex);
		
	}	
	 }
}

public int getColNumber(String colName) {
		return colNames.get(colName);
}

public String getcellData(int rowNum, String colName) throws IOException {
	getColName();
	int colNum = getColNumber(colName);
	return getCellDataUsingNumber(rowNum,colNum);
	
	
}

public String getCellDataUsingNumber(int rowNum, int ColNum) throws IOException {

	sheet= wb.getSheet("TestData");
	row = sheet.getRow(rowNum);
	XSSFCell cell = row.getCell(ColNum);
	String ret = cell.getStringCellValue();
	return ret;
	
}

@DataProvider(name="dataPro")
public Object[][] readData() throws IOException {
	List<String> dataList = new ArrayList<>();
	XSSFSheet sheet = wb.getSheet("TestData");
	// Header Row 
	XSSFRow headerRow = sheet.getRow(0); 
    int totalRows = sheet.getLastRowNum(); 
    //assigning the value as we not founding any column as -1 , if we didnt start 0, it may stay at 0 wrong column. 
    int colIndex = -1;    
    for (Cell cell : headerRow) {
    	if(cell.getStringCellValue().trim().equalsIgnoreCase("Valid code")) {
    		colIndex = cell.getColumnIndex();
    		break;
    	}
	}
    if (colIndex == -1) {
    	wb.close();
        throw new IllegalArgumentException("Column  not found in sheet.");
    }
    
 // Start from row 1 (excluding header)
    for (int i = 1; i <= totalRows; i++) {
        XSSFRow row = sheet.getRow(i);
        if (row != null) {
            Cell cell = row.getCell(colIndex);         
            String value = (cell != null) ? cell.toString() : "";
            dataList.add(value);
        }
    }
    wb.close();
    fis.close();
    
    // Convert List<String> to Object[][]
    Object[][] dataArr = new Object[dataList.size()][1];
    for (int i = 0; i < dataList.size(); i++) {
        dataArr[i][0] = dataList.get(i);
    }
	return dataArr;
    
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

//@DataProvider(name="dataPro")
//public String[][] getCellData() throws IOException {	
//	fis = new FileInputStream(path);
//	workbook= new XSSFWorkbook(fis);
//	sheet=workbook.getSheetAt(0);
//	int rowCount = sheet.getPhysicalNumberOfRows();
//	int cellCount = sheet.getRow(0).getLastCellNum();
//	String[][] data = new String[rowCount-1	][cellCount];
//    for(int i=0;i<rowCount-1;i++) {
//	for(int j=0;j<cellCount;j++) {	
//		XSSFCell cellData = sheet.getRow(i+1).getCell(j);
//		DataFormatter df = new DataFormatter();
//		data[i][j] = df.formatCellValue(cellData);
//	}
//	System.out.println();
//}
//	workbook.close();
//	fis.close();
//	return data;	
//}
}
