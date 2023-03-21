package org.servicenow.incident;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AssignIncident extends PreAndPostCondition {
	
	@BeforeTest
	public void inputToExcel()
	{
		excelFileName="testData_servicenow";
	}
	
	
	@Test(dataProvider="inputIncidentNumber", dependsOnGroups = {"Prerequestie"})
	public void assignIncident(String incidentNumber) 
	{	
	//3. Enter Incident in filter navigator and press enter"
	driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
	driver.findElement(By.xpath("//div[text()='Open - Unassigned']")).click();
	
	//4. Search for the existing incident and click on the incident
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNumber,Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='"+incidentNumber+"']")).click();

	
	//5. Assign the incident to  Software group
	driver.findElement(By.id("lookup.incident.assignment_group")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> windowList = new ArrayList<String>(windowHandles);

	driver.switchTo().window(windowList.get(1));
	driver.findElement(By.id("sys_user_group_table_header_search_control")).sendKeys("software",Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='Software']")).click();
	driver.switchTo().window(windowList.get(0));
	
	//6. Update the incident with Work Notes
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.id("activity-stream-textarea")).sendKeys("Updated the incident");
	
	//7. Verify the Assignment group and Assigned for the incident
	driver.findElement(By.id("sysverb_update")).click();
	driver.findElement(By.xpath("//a[text()='"+incidentNumber+"']")).click();
	String assignmentGroup = driver.findElement(By.id("sys_display.incident.assignment_group")).getAttribute("Value");

	Assert.assertEquals(assignmentGroup, "Software");
	
	String workNotes = driver.findElement(By.xpath("//span[text()='Updated the incident']")).getText();
	
	Assert.assertEquals(workNotes,"Updated the incident");

	}
	
}
