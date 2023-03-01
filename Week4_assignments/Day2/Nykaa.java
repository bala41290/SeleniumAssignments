package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		//1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brandElement = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions scrollAndHover= new Actions(driver);
		scrollAndHover.moveToElement(brandElement).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		
		
		//3) Click L'Oreal Paris
		driver.findElement(By.xpath("//a[contains(text(),'Paris')]")).click();
		
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String lorealTitle = driver.getTitle();
		if(lorealTitle.contains("Buy L'Oreal Paris products online at best price on Nykaa | Nykaa"))
		{
			System.out.println("L'Oreal Paris product search was successful: "+lorealTitle);
		}
		else
		{
			System.out.println("L'Oreal Paris product search was not successful: "+lorealTitle);
		}
				
		//5) Click sort By and select customer top rated
		WebElement sortName = driver.findElement(By.xpath("//span[@class='sort-name']"));
		scrollAndHover.scrollToElement(sortName).perform();
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']/following::div[@class='control-indicator radio ']")).click();
		
		//6) Click Category and click Hair->Click haircare->Shampoo
		WebElement formulationFilter = driver.findElement(By.xpath("//span[text()='Formulation']"));
		scrollAndHover.scrollToElement(formulationFilter).perform();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//ul[@id='custom-scroll']//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		
		
		//7) Click->Concern->Color Protection
		scrollAndHover.scrollToElement(formulationFilter).perform();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		//8)check whether the Filter is applied with Shampoo
		String filterName = driver.findElement(By.className("filter-value")).getText();
		if(filterName.equals("Shampoo"))
		{
			System.out.println("Correct filter is applied: "+filterName);
		}
		else
		{
			System.out.println("Correct filter is not applied: "+filterName);
		}
		
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
		
		//10) GO to the new window and select size as 175ml
		Set<String> multipleWindow = driver.getWindowHandles();
		List<String> windowList=new ArrayList<String>(multipleWindow);
		driver.switchTo().window(windowList.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		
		//11) Print the MRP of the product
		String mrp = driver.findElement(By.xpath("//span[text()='MRP:']/following::span")).getText();
		System.out.println("MRP of the product is: "+mrp.replaceAll("[^0-9]", ""));
		
		//12) Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		
		//13) Go to Shopping Bag 
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		
		//14) Print the Grand Total amount
		driver.switchTo().frame(0);
		String grandTotal = driver.findElement(By.xpath("//p[text()='You Pay']/following::p")).getText();
		System.out.println("Grand total of the product is: "+grandTotal.replaceAll("[^0-9]", ""));
		
		
		//15) Click Proceed
		Thread.sleep(3000);
		WebDriverWait eWait=new WebDriverWait(driver, Duration.ofSeconds(20));
		eWait.until(ExpectedConditions.textToBe(By.xpath("//span[text()='Proceed']"), "Proceed"));
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.switchTo().defaultContent();
		
		
		//16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
		//17) Check if this grand total is the same in step 14
		driver.findElement(By.xpath("//p[text()='New Address']/preceding::img[contains(@src,'Clear')]")).click();
		eWait.until(ExpectedConditions.textToBe(By.xpath("//p[text()='Price Details']"), "Price Details"));
		String finalTotal = driver.findElement(By.xpath("//p[text()='Price Details']/following::p")).getText();
		if(finalTotal.equals(grandTotal))
		{
			System.out.println("Total remains the same: "+finalTotal.replaceAll("[^0-9]", ""));
		}
		else
		{
			System.out.println("Total doesn't remains the same: "+finalTotal.replaceAll("[^0-9]", ""));
		}
		
		//18) Close all windows
		
		driver.quit();
		

		

		

	}

}
