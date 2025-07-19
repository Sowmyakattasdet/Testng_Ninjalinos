package Utilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_utils {

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	

	public static int rowCount(String xlfilePath, String sheetName) throws IOException {

		fis = new FileInputStream(xlfilePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}

	public static int colCount(String xfilePath, String sheetName, int rowNum) throws IOException {
		fis = new FileInputStream(xfilePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
		
	}
//to get the Cell Data
	public static String getData(String xfilePath, String sheetName, int rowNum, int cellCount) throws IOException {
		
		fis = new FileInputStream(xfilePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellCount);
		String cellData;
		try {
		DataFormatter df = new DataFormatter();
		cellData = df.formatCellValue(cell);
		}
		catch (Exception e) {
			cellData = "";
		}
		wb.close();
		fis.close();
		return cellData;

	}

	public static void setCellData(String xfilepath, String sheetName, int rowNum, int colnumNum, String cellData)
			throws IOException {
		fis = new FileInputStream(xfilepath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.createCell(colnumNum);
		cell.setCellValue(cellData);

		fos = new FileOutputStream(xfilepath);
		wb.write(fos);
		wb.close();
		fos.close();
		fis.close();
		
		
		
	}

}