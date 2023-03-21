package org.servicenow.incident;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class PreAndPostCondition {
	
	public RemoteWebDriver driver;
	public String excelFileName;
	
	@Parameters({"username", "password"})
	@BeforeMethod
	public void launchBrowser(String username, String password)
	{
		//1. Launch ServiceNow application
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://dev116867.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		//2. Login with valid credentials 
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
	}
	
	
	@DataProvider
	public String[][] inputIncidentNumber() throws IOException
	{
		String[][] inputIncidentID = ReadDataFromExcel.readDataFromExcel(excelFileName);
		return inputIncidentID;
	}
	
	@AfterMethod
	public void exitBrowser()
	{
		driver.close();
	}

}
