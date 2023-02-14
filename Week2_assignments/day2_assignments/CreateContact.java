package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {
	
	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();																	//Maximize the window
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");										//Entering the username
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");												//Entering the password
		
		driver.findElement(By.className("decorativeSubmit")).click();											//Clicking on the login button
	
		driver.findElement(By.linkText("CRM/SFA")).click();														//Clicking on the CRM SFA link
		
		driver.findElement(By.linkText("Contacts")).click();													//Clicking on contacts

		driver.findElement(By.linkText("Create Contact")).click();												//Clicking on create contact
		
		driver.findElement(By.id("firstNameField")).sendKeys("Bala");											//Entering the firstname
		
		driver.findElement(By.id("lastNameField")).sendKeys("Murugan");											//Entering the lastname

		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Bala");							//Entering the first name local

		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Murugan");						//Entering the last name local

		driver.findElement(By.name("departmentName")).sendKeys("IT");											//Entering the department
		
		driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("Testing");	//Entering the description
		
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("balamurugan@gmail.com"); //Entering the email id
		
		WebElement stateDropDown = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		
		Select dropDown=new Select(stateDropDown);
		dropDown.selectByValue("NY");																			//Selecting NewYork from dropdown
		
		driver.findElement(By.className("smallSubmit")).click();												//clicking on create contact
		
		driver.findElement(By.linkText("Edit")).click();														//Clicking on edit button
		
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();				//Deleting the data in the description section
		
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Updated notes after editing");	//Entering data in important note section
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();										//Clicking on update
		
		
		if(driver.getTitle().contains("View Contact | opentaps CRM"))
		{
			System.out.println("Actual and Expected Result are met");
		}
		else
		{
			System.out.println("Actual and Expected Result are not met");
		}
		
		driver.close();
		
	}

}
