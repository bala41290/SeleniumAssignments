package week3.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ListImplementation {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Launch the URL https://www.ajio.com/
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//In the search box, type as "bags" and press enter
		driver.findElement(By.name("searchVal")).sendKeys("Bags",Keys.ENTER);
		
		//To the left  of the screen under " Gender" click the "Men"
		driver.findElement(By.xpath("//input[@id='Men']/following::label[contains(text(),'Men')]")).click();
		
		Thread.sleep(2000);
		
		//Under "Category" click "Fashion Bags"
		driver.findElement(By.xpath("//input[@id='Men - Fashion Bags']/following::label[contains(text(),'Fashion Bags')]")).click();
		
		Thread.sleep(2000);
		
		//Print the count of the items Found
		String itemsFound = driver.findElement(By.xpath("//div[@class=' filter-container']//div[@class='length']")).getText();
		String totalItemsFound = itemsFound.replaceAll("[^0-9]", "");
		System.out.println("Count of the items Found: "+totalItemsFound);
		
		//Get the list of brand of the products displayed in the page and print the list
		List<WebElement> brands = driver.findElements(By.xpath("//div[@class='contentHolder']/div[@class='brand']"));
		List<String> brandList=new ArrayList<String>();
		for(int i=0;i<brands.size();i++)
		{
			String brandsFound = brands.get(i).getText();
			brandList.add(brandsFound);
		}
		Collections.sort(brandList);
		System.out.println(brandList);
		
		//Get the list of names of the bags and print it
		List<WebElement> bName = driver.findElements(By.xpath("//div[@class='contentHolder']/div[@class='nameCls']"));
		List<String> bagList=new ArrayList<String>();
		for (WebElement bagName : bName) {
			String bagsName = bagName.getText();
			bagList.add(bagsName);
		}
		Collections.sort(bagList);
		System.out.println(bagList);
		

	}

}
