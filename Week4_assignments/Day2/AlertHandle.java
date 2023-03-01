package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class AlertHandle {

	public static void main(String[] args) throws InterruptedException {
		
		//1. Load https://buythevalue.in/
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://buythevalue.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("com-hextom-smartpushmarketing-modal-close-modal")).click();
		
		//2. Click on first product (eg: Hamdard Hing - 50GM)
		driver.findElement(By.name("q")).sendKeys("Hamdard Hing - 50GM");
		driver.findElement(By.xpath("//ul[@class='search-results']//ancestor::span")).click();
		
		//3. Close chat widget
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//button[contains(@class,'CloseButton')]")).click();
		
		//4. Enter the pincode 
		driver.switchTo().defaultContent();
		driver.findElement(By.id("wk_zipcode")).sendKeys("600001");
		
		//5. Click on Check
		driver.findElement(By.xpath("//input[@class='btn']")).click();
		
		//6. Click on ADD TO CART
		driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
		
		
		//7. Click on View
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='View Cart']")).click();
		
		
		//8. Click on CHECK OUT
		driver.findElement(By.id("checkout")).click();
		
		//9. Accept the alert
		Alert termsAlert = driver.switchTo().alert();
		termsAlert.accept();
		
		driver.quit();

	}

}
