package org.servicenow.incident;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class DeleteIncident extends PreAndPostCondition {
		
		@BeforeTest
		public void inputToExcel()
		{
			excelFileName="testData_servicenow";
		}
		
		@Test(dataProvider="inputIncidentNumber", dependsOnGroups = {"Prerequestie"})
		public void updateIncident(String incidentNumber) 
		{
		//3. Enter Incident in filter navigator and press enter"
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		
		//4. Search for the existing incident and click on the incident
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNumber,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='"+incidentNumber+"']")).click();
		
//		//5. Delete the incident
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		
		//6. Verify the deleted incident
		boolean deleteIncident = driver.findElement(By.xpath("//td[text()='No records to display']")).isDisplayed();
		
		Assert.assertEquals(deleteIncident, true);


		}
}
