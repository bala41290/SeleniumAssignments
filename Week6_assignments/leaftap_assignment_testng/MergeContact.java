package week6.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MergeContact extends PreAndPostCondition{
	
	@Test
	public void mergeContact() {
		
		driver.findElement(By.linkText("Contacts")).click();
		
		// 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following::img")).click();
		
		//8. Click on First Resulting Contact
		Set<String> fromWindow = driver.getWindowHandles();
		List<String> fromList=new ArrayList<String>(fromWindow);
		driver.switchTo().window(fromList.get(1));
		driver.findElement(By.xpath("(//td[contains(@class,'partyId')]/div/a)[2]")).click();
		driver.switchTo().window(fromList.get(0));
		
		//9. Click on Widget of To Contact
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following::img")).click();


		//10. Click on Second Resulting Contact
		Set<String> toWindow = driver.getWindowHandles();
		List<String> toList = new ArrayList<String>(toWindow);
		driver.switchTo().window(toList.get(1));
		driver.findElement(By.xpath("(//td[contains(@class,'partyId')]/div/a)[3]")).click();
		driver.switchTo().window(toList.get(0));
		
		//11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//12. Accept the Alert
		Alert alertWindow = driver.switchTo().alert();
		alertWindow.accept();
		
		//13. Verify the title of the page
		String titleAfterMerge = driver.getTitle();
		System.out.println("Title of the webpage after merging the contacts: "+titleAfterMerge);
		
	}

}
