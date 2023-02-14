package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationFB {
	
	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Bala");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Murugan");
		
		driver.findElement(By.xpath("//input[contains(@name,'reg_email__')]")).sendKeys("8056278468");

		driver.findElement(By.xpath("//input[contains(@name,'reg_passwd__')]")).sendKeys("8056278468");
		
		WebElement date = driver.findElement(By.id("day"));
		Select birthDay = new Select(date);
		birthDay.selectByVisibleText("4");
		
		WebElement month = driver.findElement(By.id("month"));
		Select birthMonth = new Select(month);
		birthMonth.selectByIndex(11);
		
		WebElement year = driver.findElement(By.id("year"));
		Select birthYear = new Select(year);
		birthYear.selectByValue("1990");
		
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		
		driver.close();
		
	}

}
