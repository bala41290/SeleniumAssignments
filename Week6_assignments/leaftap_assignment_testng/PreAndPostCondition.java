package week6.day1.assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week6.day2.ReadDataFromExcel;

public class PreAndPostCondition {
	
	public RemoteWebDriver driver;
	public String excelFileName;
	
	@Parameters({"url","browser","username","password"})
	@BeforeMethod
	public void launchBrowserAndLogin(String url, String browser, String username, String password)
	{
		switch (browser) {
		case "chrome":
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		break;

		case "edge":
		driver = new EdgeDriver();
		break;
		
		case "firefox":
		driver = new FirefoxDriver();
		break;
			
		default:
		break;
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		

	}
	
	@AfterMethod
	public void exitBrowser()
	{
		
		driver.quit();
	}
	
	@DataProvider
	public String[][] testData() throws IOException
	{
		
		String[][] inputData = ReadDataFromExcel.readData(excelFileName);
		return inputData;
		
	}

}
