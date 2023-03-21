package week6.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLead extends PreAndPostCondition {
	@BeforeTest
	public void inputFromExcel()
	{
		excelFileName="testData_leaftap";
	}
	
	@Test(dataProvider = "testData")
	public void deleteLead(String cName, String fName, String lName, String eMail, String dName, String pNumber) throws InterruptedException {
		
		//Clicking on the lead tab

		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();													//Clicking on find leads
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();											//clicking on the phone tab
		
		driver.findElement(By.xpath("//div[contains(@class,'x-plain-body-noborder')]/input[@name='phoneNumber']")).sendKeys(pNumber);
		
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
		
		
	}

}
