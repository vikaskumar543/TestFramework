package com.LearnAutomation.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		File file = new File("./TestData/testdata.xlsx");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel file >> " + e.getMessage());
		}
	}
	
	public String getStringValue(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringValue(int sheetNum, int row, int col) {
		return wb.getSheetAt(sheetNum).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumericValue(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
	
	public double getNumericValue(int sheetNum, int row, int col) {
		return wb.getSheetAt(sheetNum).getRow(row).getCell(col).getNumericCellValue();
	}
}
