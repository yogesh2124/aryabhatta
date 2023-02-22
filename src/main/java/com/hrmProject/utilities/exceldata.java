package com.hrmProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldata {
	
	public static String getdata(int i,int j) throws Exception {
		
		File file = new File("C:\\Users\\yoges\\Desktop\\aryabhat\\book1.xlsx");
		
		FileInputStream inputStream = new FileInputStream(file);
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=wb.getSheet("sheet1");
		XSSFRow row2=sheet.getRow(i);
		XSSFCell cell = row2.getCell(j);
		String data= cell.getStringCellValue();
		return data;
		
	}
}
