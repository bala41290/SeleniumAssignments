package org.servicenow.incident;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateIncident extends PreAndPostCondition {
	
	@BeforeTest
	public void inputToExcel()
	{
		excelFileName="testData_servicenow";
	}
	
	@Test(dataProvider="inputIncidentNumber", dependsOnGroups = {"Prerequestie"})
	public void updateIncident(String incidentNumber) 
	{
	
	//3. Enter Incident in filter navigator and press enter"
	driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incidents");
	driver.findElement(By.xpath("//div[text()='Incidents']")).click();
	
	//4. Search for the existing incident and click on the incident
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incidentNumber,Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='"+incidentNumber+"']")).click();
	
	//5. Update the incidents with Urgency as High and State as In Progress
	Select urgencyDD=new Select(driver.findElement(By.id("incident.urgency")));
	urgencyDD.selectByValue("1");
	
	Select stateDD=new Select(driver.findElement(By.id("incident.state")));
	stateDD.selectByVisibleText("In Progress");
	
	driver.findElement(By.id("sysverb_update")).click();
	
	driver.findElement(By.xpath("//a[text()='"+incidentNumber+"']")).click();
	
	//6. Verify the priority and state 
	String incidentUrgency = driver.findElement(By.xpath("//span[text()='Incident state']/following::span")).getText();
	String incidentState = driver.findElement(By.xpath("//span[text()='Priority']/following::span")).getText();

	
	Assert.assertEquals(incidentUrgency, "In ProgresswasNew");
	Assert.assertEquals(incidentState, "3 - Moderatewas5 - Planning");
	
	}
}
