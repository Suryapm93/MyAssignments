package week4.Day1.Assignment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String titleOfCurrentWindow = driver.getTitle();
		System.out.println("Title of Current Window: " + titleOfCurrentWindow);		
		//1. Click and Confirm new Window Opens
		System.out.println("Click and Confirm new Window Opens");
		//Click button to open new window
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Thread.sleep(2000);
		//to get into new window
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		String titleOfNewWindow = driver.getTitle();
		System.out.println("Title of New Window: " + titleOfNewWindow);
		if(!titleOfCurrentWindow.equals(titleOfNewWindow)) {
			System.out.println("New Window Opened");
		} else
			System.out.println("New Window NOT Opened");
		//to close currently opened browser tab
		driver.close();
		Thread.sleep(5000);
		//to get back to base window
		driver.switchTo().window(list.get(0));
		
		//2. Find the number of opened tabs
		System.out.println("Find the number of opened tabs");
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		//to get into new window
		Set<String> windowHandles1 = driver.getWindowHandles();
		System.out.println(windowHandles1);
		List<String> list1 = new ArrayList<String>(windowHandles1);
		Thread.sleep(1000);
		//list1.size()-1; -1 means excluding base window
		int numOfOpenedTabs = list1.size()-1;
		System.out.println("Number of Opened tabs: " +numOfOpenedTabs);
		//to close all the opened tabs except base window
		for(int i=numOfOpenedTabs; i>0 ;i--) {
			driver.switchTo().window(list1.get(i)).close();
		}
		Thread.sleep(1000);
		
		//3. Close all windows except Primary
		System.out.println("Close all windows except Primary");
		//to get back to base window
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Thread.sleep(1000);
		//to get into new window
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> list2 = new ArrayList<String>(windowHandles2);
		int size = list2.size()-1;
		System.out.println("No. of Opened windows: " + size);
		//to close all the windows except primary
		for(int i=size; i>0 ;i--) {
			driver.switchTo().window(list2.get(i)).close();
		}
		Thread.sleep(1000);
		// to check whether the primary window is not closed
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getTitle());
		
		//4. Wait for 2 new tabs to open
		System.out.println("Wait for 2 new tabs to open");
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Thread.sleep(10000);
		Set<String> windowHandles3 = driver.getWindowHandles();
		System.out.println(windowHandles3);
		List<String> list3 = new ArrayList<String>(windowHandles3);
		int size2 = list3.size()-1;
		for(int i=size2;i>0;i--) {
			driver.switchTo().window(list3.get(i));
			Thread.sleep(500);
			System.out.println(driver.getTitle());
		}	
		driver.quit();
	}
}
