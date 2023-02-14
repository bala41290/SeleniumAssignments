package week2.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver cDriver = new ChromeDriver();
		
		cDriver.get("http://leaftaps.com/opentaps/control/login");  										//Launching the application
		
		cDriver.manage().window().maximize();																//Maximize the window
		
		cDriver.findElement(By.id("username")).sendKeys("Demosalesmanager");								//Entering the username
		
		cDriver.findElement(By.id("password")).sendKeys("crmsfa");											//Entering the password
		
		cDriver.findElement(By.className("decorativeSubmit")).click();										//Clicking on the login button

		cDriver.findElement(By.linkText("CRM/SFA")).click();												//Clicking on the CRM SFA link
		
		cDriver.findElement(By.linkText("Leads")).click();													//Clicking on the lead tab
		
		cDriver.findElement(By.linkText("Create Lead")).click();											//clicking on create lead
		
		cDriver.findElement(By.id("createLeadForm_companyName")).sendKeys("Wellsfargo");  					//Entering the company name
		
		cDriver.findElement(By.id("createLeadForm_firstName")).sendKeys("Bala");		  					//Entering the firstname
		
		cDriver.findElement(By.id("createLeadForm_lastName")).sendKeys("Murugan");		  					//Entering the lastname

		cDriver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Bala");	  					//Entering the firstname local

		cDriver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");		  					//Entering the department

		cDriver.findElement(By.name("description")).sendKeys("Create lead automation");		  				//Entering the Description

		cDriver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("email@gmail.com");		  		//Entering the email address

		
		//Finding dropdown field by using ID
		WebElement stateElement = cDriver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		//Calling Select class by assigning to the variable
		Select stateDD=new Select(stateElement);
		
		stateDD.selectByVisibleText("New York");															//Clicking on NewYork
		
		Thread.sleep(1000);
		
		cDriver.findElement(By.className("smallSubmit")).click();											//Clicking on the create lead button
		
		Thread.sleep(5000);
		
		if(cDriver.getTitle().contains("View Lead | opentaps CRM"))
		{
			System.out.println("Expected and Actual Results are met after creating new lead");
		}
		else
			System.out.println("Expected and Actual Results are not met after creating new lead");

		cDriver.findElement(By.linkText("Duplicate Lead")).click();                                         //Clicking on the duplicate lead button
		
		cDriver.findElement(By.id("createLeadForm_companyName")).clear();									//Clearing the company name field
		
		cDriver.findElement(By.id("createLeadForm_companyName")).sendKeys("Google");						//Entering new company name
		
		cDriver.findElement(By.id("createLeadForm_firstName")).clear();										//Clearing the first name
		
		cDriver.findElement(By.id("createLeadForm_firstName")).sendKeys("B");								//Entering new first name
		
		cDriver.findElement(By.className("smallSubmit")).click();											//Clicking on the create lead button
		
		Thread.sleep(5000);

		//Getting the title of the result page
		
		if(cDriver.getTitle().contains("View Lead | opentaps CRM"))
		{
			System.out.println("Expected and Actual Results are met after creating new lead by using duplicate option");
		}
		else
			System.out.println("Expected and Actual Results are not met after creating new lead by using duplicate option");
		
		cDriver.close();

	}
}