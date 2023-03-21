package org.servicenow.incident;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	
	public static String[][] readDataFromExcel(String excelFileName) throws IOException {
		
		
		//Accessing the workbook
		XSSFWorkbook workBook=new XSSFWorkbook("./testData/"+excelFileName+".xlsx");
		
		//Accessing the sheet
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		//Accessing the row
		int totalRow = sheet.getLastRowNum();
		
		//Accessing the column
		short totalColumn = sheet.getRow(0).getLastCellNum();
		
		//Creating multi dimenstional Array
		String[][] data=new String[totalRow][totalColumn];
		
		for(int i=1;i<=totalRow;i++)
		{
			XSSFRow rowValue = sheet.getRow(i);
			
			for(int j=0;j<totalColumn;j++)
			{
				XSSFCell column = rowValue.getCell(j);
				String stringCellValue = column.getStringCellValue();
				data[i-1][j]=stringCellValue;
			}
		}
		workBook.close();
		return data;
	}

}
