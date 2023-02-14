package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DeleteLeads {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();																	//Maximize the window
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");										//Entering the username
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");												//Entering the password
		
		driver.findElement(By.className("decorativeSubmit")).click();											//Clicking on the login button
	
		driver.findElement(By.linkText("CRM/SFA")).click();														//Clicking on the CRM SFA link
		
		driver.findElement(By.linkText("Leads")).click();														//Clicking on the lead tab
		
		driver.findElement(By.linkText("Leads")).click();											//Clicking on the lead tab
		
		driver.findElement(By.linkText("Create Lead")).click();									//clicking on create lead
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Wellsfargo");  			//Entering the company name
		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Bala");		  			//Entering the firstname
		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Murugan");		  			//Entering the lastname

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Bala");	  			//Entering the firstname local

		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");		  			//Entering the department
		
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("8056278468");

		driver.findElement(By.name("description")).sendKeys("Create lead automation");		  		//Entering the Description

		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("email@gmail.com");		 //Entering the email address

		//Finding dropdown field by using ID
		WebElement stateElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		//Calling Select class by assigning to the variable
		Select stateDD=new Select(stateElement);
		
		stateDD.selectByVisibleText("New York");													//Clicking on NewYork
		
		Thread.sleep(1000);
		
		driver.findElement(By.className("smallSubmit")).click();									//Clicking on the create lead button
		
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Find Leads")).click();													//Clicking on find leads
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();											//clicking on the phone tab
		
		driver.findElement(By.xpath("//div[contains(@class,'x-plain-body-noborder')]/input[@name='phoneNumber']")).sendKeys("8056278468");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();									//Clicking on find leads
		
		Thread.sleep(3000);
		
		WebElement leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		
		System.out.println(leadID.getText());
		String strLeadID=leadID.getText();
		System.out.println(strLeadID);

		leadID.click();																							//Click on the first lead ID	
				
		Thread.sleep(2000);

		driver.findElement(By.className("subMenuButtonDangerous")).click();										//clicking on delete to delete the leadID
		
		driver.findElement(By.linkText("Find Leads")).click();													//Click on the Find Leads
		
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(strLeadID);							//Enter the delete lead id number
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();									//Clicking on find leads
		
		Thread.sleep(3000);
		
		String noRecords = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		
		if(noRecords.matches("No records to display"))
		{
			System.out.println("Lead ID deleted successfully");
		}
		else
		{
			System.out.println("Lead ID is not deleted successfully");
		}
		
		
		driver.close();
		
	}

}
