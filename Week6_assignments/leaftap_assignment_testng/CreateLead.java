package week6.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends PreAndPostCondition {
	
	@BeforeTest
	public void inputFromExcel()
	{
		excelFileName="testData_leaftap";
	}
	
	@Test(dataProvider = "testData")
	public void createLead(String cName, String fName, String lName, String eMail, String dName, String pNumber) throws InterruptedException {
		

		driver.findElement(By.linkText("Create Lead")).click();									//clicking on create lead
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);  			//Entering the company name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);		  			//Entering the firstname
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);		  			//Entering the lastname
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(eMail);		 //Entering the email address
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fName);	  			//Entering the firstname local
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(dName);		  			//Entering the department
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pNumber);
		driver.findElement(By.name("description")).sendKeys("Create lead automation");		  		//Entering the Description

		//Finding dropdown field by using ID
		WebElement stateElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		//Calling Select class by assigning to the variable
		Select stateDD=new Select(stateElement);
		
		stateDD.selectByVisibleText("New York");													//Clicking on NewYork
		
		Thread.sleep(1000);
		
		driver.findElement(By.className("smallSubmit")).click();									//Clicking on the create lead button
		
		Thread.sleep(5000);
		
		System.out.println(driver.getTitle());														//Getting the title of the result page
		
		if(driver.getTitle().contains("View Lead | opentaps CRM"))
		{
			System.out.println("Expected and Actual Results are met after creating new lead");
		}
		else
			System.out.println("Expected and Actual Results are not met after creating new lead");
		

	}

}
