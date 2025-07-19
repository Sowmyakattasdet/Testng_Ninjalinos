package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Logininvalid {

	static String path="C:\\Users\\rahul\\eclipse-workspace\\dsalgo\\testdata\\data.xlsx";
	
	public void readExcel() throws IOException {
	
		// TODO Auto-generated method stub
		
		FileInputStream file=new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int totalRows=sheet.getLastRowNum();
		System.out.println(totalRows);
	}

}
