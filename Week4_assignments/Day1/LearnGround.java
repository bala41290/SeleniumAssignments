package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnGround {
	
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Set<String> initialWindowHandle = driver.getWindowHandles();
		List<String> initialWindowHandleList= new ArrayList<String>(initialWindowHandle);
		String initialWindowTitle = driver.getTitle();
		
		//Click and Confirm new Window Opens
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> newWindow = driver.getWindowHandles();
		List<String> newWindowList=new ArrayList<String>(newWindow);
		driver.switchTo().window(newWindowList.get(1));
		System.out.println("Title of second window is: "+driver.getTitle());
		System.out.println("Title of first window is: "+initialWindowTitle);
		driver.close();
		driver.switchTo().window(initialWindowHandleList.get(0));
		
		//Find the number of opened tabs
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> noOfTabs = driver.getWindowHandles();
		List<String> noOfTabList=new ArrayList<String>(noOfTabs);
		int noOfTabsOpened = noOfTabList.size();
		System.out.println("Find the number of opened tabs: "+noOfTabsOpened);
		driver.switchTo().window(noOfTabList.get(2));
		driver.close();
		driver.switchTo().window(noOfTabList.get(1));
		driver.close();
		driver.switchTo().window(initialWindowHandleList.get(0));
		
		//Close all windows except Primary
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> closeWindow = driver.getWindowHandles();
		List<String> closeWindowList=new ArrayList<String>(closeWindow);
		System.out.println("Close all windows except Primary: "+closeWindowList.size());
		driver.switchTo().window(closeWindowList.get(3));
		driver.close();
		driver.switchTo().window(closeWindowList.get(2));
		driver.close();
		driver.switchTo().window(closeWindowList.get(1));
		driver.close();
		driver.switchTo().window(initialWindowHandleList.get(0));
		
		//Wait for 2 new tabs to open
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> initialDelay = driver.getWindowHandles();
		List<String> initialDelayList=new ArrayList<String>(initialDelay);
		System.out.println("No of windows immediately after clicking the button: "+initialDelayList.size());
		Set<String> finalDelay = driver.getWindowHandles();
		List<String> finalDelayList=new ArrayList<String>(finalDelay);
		System.out.println("No of windows immediately after clicking the button: "+finalDelayList.size());
		driver.switchTo().window(initialDelayList.get(2));
		driver.close();
		driver.switchTo().window(initialDelayList.get(1));
		driver.close();
		driver.switchTo().window(initialWindowHandleList.get(0));
		driver.quit();

	}

}
