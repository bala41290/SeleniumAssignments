package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {
	
	public static void main(String[] args) throws InterruptedException {
		
		String companyName= new String("Amazon");
		String firstName= new String("Bala");
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();																	//Maximize the window
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");										//Entering the username
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");												//Entering the password
		
		driver.findElement(By.className("decorativeSubmit")).click();											//Clicking on the login button
	
		driver.findElement(By.linkText("CRM/SFA")).click();														//Clicking on the CRM SFA link
		
		driver.findElement(By.linkText("Leads")).click();														//Clicking on the lead tab
		
		driver.findElement(By.linkText("Find Leads")).click();													//Clicking on find leads
		
		driver.findElement(By.xpath("//input[@name='id']/following::input[@name='firstName']")).sendKeys(firstName); //Entering the firstname to search
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();									//Clicking on the Find leads button
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();	   //Clicking on firstname from the search result

		driver.findElement(By.linkText("Edit")).click();														//clicking on edit button
		
		driver.findElement(By.id("updateLeadForm_companyName")).clear();										//Clearing the existing data
		
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);								//Updating the company name
		
		driver.findElement(By.className("smallSubmit")).click();												//Clicking on update button
		
		WebElement cName = driver.findElement(By.id("viewLead_companyName_sp"));

		String strCName= cName.getText().trim().substring(0, 6);
		
		System.out.println("Updated company name is: "+strCName);
		
		if(strCName.equals(companyName))
			
		{
			System.out.println("Company name got updated correctly");
		}
		else
		{
			System.out.println("Company name is not updated correctly");
		}
		
		Thread.sleep(1000);
		
		driver.close();
		
	}

}
