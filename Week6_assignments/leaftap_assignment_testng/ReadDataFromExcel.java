package week6.day1.assignment;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	public static String[][] readData(String excelFileName) throws IOException {
		
		//Accessing the workbook
		XSSFWorkbook workBook=new XSSFWorkbook("./testData/"+excelFileName+".xlsx");
		
		//Accessing the sheet in the workbook
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		
		//Checking no of active rows in the sheet
		int totalRow = sheet.getLastRowNum();
		
		//Checking no of columns in the workbook
		short totalColumn = sheet.getRow(0).getLastCellNum();
		
		//creating Array
		String[][] data= new String[totalRow][totalColumn];
		
		for(int i=1;i<=totalRow;i++)
		{
			XSSFRow rowValue = sheet.getRow(i);
			
			for(int j=0;j<totalColumn;j++)
			{
				
				XSSFCell column = rowValue.getCell(j);
				String columnValue = column.getStringCellValue();
				data[i-1][j]=columnValue;
			}
			
		}
		workBook.close();
		return data;
	
	}

}
