package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderFile {

    private String xlfilePath;

    public ExcelReaderFile() throws IOException {
        ConfigReader config = new ConfigReader();
        this.xlfilePath = config.get_prop_value("path");
    }

    // Method to get cell value using Row Name and Column Name
    public String getCellData(String sheetName, String rowName, String colName) throws IOException {
        FileInputStream fis = new FileInputStream(xlfilePath);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetName);
        DataFormatter df = new DataFormatter();

        int rowIndex = -1;
        int colIndex = -1;

       
        //FINDING COL INDEX FROM HEADER ROW (ROW 0)
        XSSFRow headerRow = sheet.getRow(0);
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            String headerValue = df.formatCellValue(headerRow.getCell(i));
            if (headerValue.equalsIgnoreCase(colName)) {
                colIndex = i;
                break;
            }
        }

        if (colIndex == -1) {
            System.out.println(colName + "not found in sheet");
            wb.close();
            fis.close();
            return "";
        }

      
        //FINDING ROW INDEX FROM FIRST COLUMN
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            String firstColValue = df.formatCellValue(sheet.getRow(i).getCell(0));
            if (firstColValue.equalsIgnoreCase(rowName)) {
                rowIndex = i;
                break;
            }
        }

        if (rowIndex == -1) {
            System.out.println(rowName + " not found in sheet ");
            wb.close();
            fis.close();
            return "";
        }

        // READING CELL VALUE
        XSSFCell cell = sheet.getRow(rowIndex).getCell(colIndex);
        String cellValue = df.formatCellValue(cell);

        wb.close();
        fis.close();
        return cellValue;
    }
}






//package utils;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReaderFile {
//
//	public static FileInputStream fis;
//	public static FileOutputStream fos;
//	public static XSSFWorkbook wb;
//	public static XSSFSheet sheet;
//	public static XSSFRow row;
//	public static XSSFCell cell;
//	ConfigReader config;
//	String xlfilePath;
//
//	public ExcelReaderFile() throws IOException {
//		this.config = new ConfigReader();
//		this.xlfilePath = config.get_prop_value("path");
//	}
//
//	public int rowCount(String sheetName) throws IOException {
//
//		fis = new FileInputStream(xlfilePath);
//		wb = new XSSFWorkbook(fis);
//		sheet = wb.getSheet(sheetName);
//		int rowCount = sheet.getLastRowNum();
//		wb.close();
//		fis.close();
//		return rowCount;
//	}
//
//	public int colCount(String sheetName, int rowNum) throws IOException {
//		fis = new FileInputStream(xlfilePath);
//		wb = new XSSFWorkbook(fis);
//		sheet = wb.getSheet(sheetName);
//		row = sheet.getRow(rowNum);
//		int cellCount = row.getLastCellNum();
//		wb.close();
//		fis.close();
//		return cellCount;
//	}
//
//	// to get the Cell Data
//	public String getData(String sheetName, int rowNum, int cellCount) throws IOException {
//
//		fis = new FileInputStream(xlfilePath);
//		wb = new XSSFWorkbook(fis);
//		sheet = wb.getSheet(sheetName);
//		row = sheet.getRow(rowNum);
//		cell = row.getCell(cellCount);
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
//	public void setCellData(String sheetName, int rowNum, int colnumNum, String cellData) throws IOException {
//		fis = new FileInputStream(xlfilePath);
//		wb = new XSSFWorkbook(fis);
//		sheet = wb.getSheet(sheetName);
//		row = sheet.getRow(rowNum);
//		cell = row.createCell(colnumNum);
//		cell.setCellValue(cellData);
//
//		fos = new FileOutputStream(xlfilePath);
//		wb.write(fos);
//		wb.close();
//		fos.close();
//		fis.close();
//
//	}
//
//}