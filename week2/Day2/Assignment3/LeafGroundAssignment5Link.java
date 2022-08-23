package week2.Day2.Assignment3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssignment5Link {

	public static void main(String[] args) throws InterruptedException {
		//Launch Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Take me to dashboard
		System.out.println("Take me to dashboard");
		driver.findElement(By.linkText("Go to Dashboard")).click();
		Thread.sleep(500);
		String dashboardTitle = driver.getTitle();
		//Verify whether dashboard page is loaded
		if(dashboardTitle.contains("Dashboard")) {
			System.out.println("Dashboard page is loaded");
		} else
			System.out.println("Dashboard page is not loaded");
		
		//go back to previous page
		driver.navigate().back();
		
		//Find my destination
		System.out.println("Find my destination");
		//we have to find the destination of the given link without clicking on it. so we can use getAttribute
		String destinationURL = driver.findElement(By.xpath("//a[text()='Find the URL without clicking me.']")).getAttribute("href");
		Thread.sleep(500);
		System.out.println("Destination of the given URL is: " + destinationURL);
		
		//Am I broken link?
		System.out.println("Am I broken link?");
		driver.findElement(By.xpath("//a[text()='Broken?']")).click();
		Thread.sleep(500);
		String brokenLinkTitle = driver.getTitle();
		System.out.println(brokenLinkTitle);
		if(brokenLinkTitle.contains("404")) {
			System.out.println("This is the broken link");
		} else
			System.out.println("This is not the broken link");
		
		//go back to previous page
		driver.navigate().back();
		
		//Duplicate Link
		System.out.println("Duplicate Link");
		driver.findElement(By.xpath("//a[text()='Go to Dashboard']")).click();
		String dashboradTitle1 = driver.getTitle();
		//comparing this link with previously loaded dashboard link (//Take me to dashboard)
		if(dashboardTitle.contains(dashboradTitle1)) {
			System.out.println("This is duplicate link");
		} else
			System.out.println("This is not the duplicate link");
		
		//go back to previous page
		driver.navigate().back();
		
		//Count Links
		System.out.println("Count Links");
		driver.findElement(By.xpath("//a[text()='How many links in this page?']")).click();
		Thread.sleep(500);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int numOfLinks = links.size();
		System.out.println("Number of links inside the given link is " + numOfLinks);
	}

}
