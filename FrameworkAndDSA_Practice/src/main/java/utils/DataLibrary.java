package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class DataLibrary {
	
	@Test
	public void test() {
		
		try {
			//XSSFWorkbook wb = new XSSFWorkbook("./data/testDataFile.xlsx");
			
			@SuppressWarnings("resource")
			XSSFSheet ws = new XSSFWorkbook("./data/testDataFile.xlsx").getSheet("Sheet1");
			
			int lastRowNum = ws.getLastRowNum();
			System.out.println(lastRowNum);
			short lastCellNum = ws.getRow(1).getLastCellNum();
			
			for (int i = 1; i <= lastRowNum; i++) {
				for (int j = 0; j < lastCellNum; j++) {
					String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
					System.out.println(cellValue);
				}
				System.out.println("***************");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
