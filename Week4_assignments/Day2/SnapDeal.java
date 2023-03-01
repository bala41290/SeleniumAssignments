package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SnapDeal {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//1. Launch https://www.snapdeal.com/
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Go to Mens Fashion
		Actions hover=new Actions(driver);
		WebElement menFashion = driver.findElement(By.xpath("//span[@class='catText']"));
		hover.moveToElement(menFashion).perform();
				
		//3. Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		//4. Get the count of the sports shoes
		String countOfSportShoes = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText();
		System.out.println("Count of sport shoes: "+countOfSportShoes.replaceAll("[^0-9]", ""));
		
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//6. Sort by Low to High
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		
		//7. Check if the items displayed are sorted correctly
		String sortSelected = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		if(sortSelected.equals("Price Low To High"))
		{
			System.out.println("Sort applied correctly from: "+sortSelected);
		}
		else
		{
			System.out.println("Sort not applied correctly: "+sortSelected);
		}
		
		//8.Select the price range (900-1200)
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("550");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("650",Keys.ENTER);
		
		//9.Filter with color Navy 
		WebElement scrollDown = driver.findElement(By.xpath("//div[@data-displayname='Size']"));
		hover.scrollToElement(scrollDown).perform();
		driver.findElement(By.xpath("//input[@id='Color_s-Navy']/following-sibling::label[1]")).click();
		
		//10 verify the all applied filters
		Thread.sleep(2000);
		String filtersApplied = driver.findElement(By.className("filters")).getText();
		System.out.println("Filters Applied: "+filtersApplied);
		
		//11. Mouse Hover on first resulting Training shoes
		//WebElement mouseHover = driver.findElement(By.xpath("//section[@data-dpwlbl='Product Grid']/div"));
		WebElement mouseHover = driver.findElement(By.className("product-tuple-description"));
		hover.moveToElement(mouseHover).perform();
		
		//12. click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'View')]")).click();
		
		//13. Print the cost and the discount percentage
		Thread.sleep(1000);
		String productDiscount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Product discount is: "+productDiscount);
		String productPrice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Product price is: "+productPrice);
		
		//14. Take the snapshot of the shoes.
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File targetPath= new File("D:\\Maven\\MavenProject\\target\\snapdeal.png");
		FileUtils.copyFile(screenshot, targetPath);
		
		//15. Close the current window
		driver.findElement(By.xpath("//div[contains(@class,'close')]/i")).click();
		
		//16. Close the main window
		driver.quit();

	}

}
