package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		
		//1.Load the URL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2.search as oneplus 9 pro
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);

		//3.Get the price of the first product
		String mobilePrice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Price of the first product from the search: "+mobilePrice.replaceAll("[^0-9]", ""));
		
		//4. Print the number of customer ratings for the first displayed product
		String mobileRating = driver.findElement(By.xpath("//span[@class='a-size-base']")).getText();
		System.out.println("Rating of the first product from the search: "+mobileRating);
		
		//5. Click the first text link of the first image
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		
		//6. Take a screen shot of the product displayed
		Set<String> productWindow = driver.getWindowHandles();
		List<String> productWindowList=new ArrayList<String>(productWindow);
		driver.switchTo().window(productWindowList.get(1));
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File targetPath= new File("D:\\Maven\\MavenProject\\target\\amazon.png");
		FileUtils.copyFile(screenshot, targetPath);
		
		String productName = driver.findElement(By.id("productTitle")).getText();
		if(productName.contains("Samsung"))
		{
			//7. Click 'Add to Cart' button
			driver.findElement(By.id("add-to-cart-button")).click();
			//8. Get the cart subtotal and verify if it is correct.
			String cartTotal = driver.findElement(By.xpath("//b[text()='Cart subtotal']//following::span" )).getText();
			System.out.println("Price after adding to the cart: "+cartTotal.replaceAll(".00", "").replaceAll("[^0-9]", ""));
				if(cartTotal.contains(mobilePrice))
				{
					System.out.println("Price is matching");
				}
				else
				{
				System.out.println("Price is not matching");
				}
		}
		else
		{
			//7. Click 'Add to Cart' button
			driver.findElement(By.id("add-to-cart-button")).click();
			//8. Get the cart subtotal and verify if it is correct.
			String cartTotal = driver.findElement(By.xpath("//span[@class='a-price-whole']" )).getText();
			System.out.println("Price after adding to the cart: "+cartTotal);
				if(cartTotal.equals(mobilePrice))
				{
					System.out.println("Price is matching");
				}
				else
				{
				System.out.println("Price is not matching");
				}
		}

		
		
		//9.close the browser
		driver.quit();
		

	}

}
