package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();																	//Maximize the window
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");										//Entering the username
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");												//Entering the password
		
		driver.findElement(By.className("decorativeSubmit")).click();											//Clicking on the login button
	
		driver.findElement(By.linkText("CRM/SFA")).click();														//Clicking on the CRM SFA link
		
		driver.findElement(By.linkText("Leads")).click();														//Clicking on the lead tab
		
		driver.findElement(By.linkText("Find Leads")).click();													//Clicking on find leads
		
		WebElement firstName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		String strName=firstName.getText();
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();		//Clicking the first name user
		
		driver.findElement(By.linkText("Duplicate Lead")).click();												//Clicking on the duplicate lead
		
		//Verifying the webpage title
		if(driver.getTitle().contentEquals("Duplicate Lead | opentaps CRM"))
		{
			System.out.println("Web page title is displayed as expected");
		}
		else
		{
			System.out.println("Web page title is not displayed as expected");
		}
		
		//Verifying the section title
		String title = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
				
		if(title.matches("Duplicate Lead"))
		{
			System.out.println("Section title is displayed as expected");
		}
		else
		{
			System.out.println("Section title is not displayed as expected");
		}
		
		
		driver.findElement(By.className("smallSubmit")).click();												//Clicking on create lead

		
		String fName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Name of the contact in the first row is: "+strName);								//Getting the name from the first in the lead table
		System.out.println("Name of the newly created lead is: "+fName);										//Getting the name of the newly created lead
		
		//Verifying the lead name
		if(fName.equals(strName))
		{
			System.out.println("First Name is Matching");
		}
		else
		{
			System.out.println("First Name is not Matching");
		}
		
		driver.close();
		
	}

}
