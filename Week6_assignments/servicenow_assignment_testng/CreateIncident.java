package org.servicenow.incident;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateIncident extends PreAndPostCondition {
	
	@BeforeTest
	public void outputToExcel()
	{
		excelFileName="testData_servicenow";
	}
	
	
	@Test(groups = "Prerequestie")
	public void createIncident() throws IOException {
		
		String incidentNumber;
		
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incidents");
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		
		//4. Click on Create new option and fill the manadatory fields
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.id("incident.short_description")).sendKeys("Servicenow test case automation");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		
		//5. Verify the newly created incident ( copy the incident number and paste it in search field and enter then verify the instance number created or not)
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNumber,Keys.ENTER);
		String verification = driver.findElement(By.xpath("//a[text()='"+incidentNumber+"']")).getText();
		
		Assert.assertEquals(incidentNumber, verification);
		
		
		File file = new File("./testData/"+excelFileName+".xlsx");
		FileInputStream input=new FileInputStream(file);
		XSSFWorkbook workBook=new XSSFWorkbook(input);
		XSSFSheet sheet = workBook.getSheetAt(0);
		XSSFRow newRow = sheet.createRow(1);
		newRow.createCell(0).setCellValue(incidentNumber);
		
		FileOutputStream output=new FileOutputStream("./testData/"+excelFileName+".xlsx");
		workBook.write(output);
		workBook.close();
		
	}

}
