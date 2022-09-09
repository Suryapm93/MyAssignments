package week4.Day2.Assignment3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CustomerServiceOptions {

	public static void main(String[] args) throws InterruptedException {

		/*Assignments 3.Customer_Service_Options
		====================================
		1. Launch Salesforce application https://login.salesforce.com/
		2. Login with username as ramkumar.ramaiah@testleaf.com and password as Password#123
		3. Click on Learn More link in Mobile Publisher
		4. Click on Products and Mousehover on Service 
		5. Click on Customer Services
		6. Get the names Of Services Available 
		7. Verify the title
		*/
		
		// 1. Launch Salesforce application https://login.salesforce.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		
		// 2. Login with username as ramkumar.ramaiah@testleaf.com and password as Password#123
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.name("pw")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();	
		
		// 3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		Thread.sleep(500);
		
		//Click  On Confirm in new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		// 4. Click on Products and Mousehover on Service 
		// Products is under shadow root dom
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//span[text()='Products']").click();
		Thread.sleep(5000);
		WebElement service = dom.findElementByXPath("//div[text()='Service']");
		Actions builder = new Actions(driver);
		builder.moveToElement(service).perform();
		
		// 5. Click on Customer Services
		dom.findElementByXPath("//a[text()='Customer Service']").click();
		
		// 6. Get the names Of Services Available 
		System.out.println("Names of Available Customer Services: ");
		List<WebElement> customerServicesNames = dom.findElementsByXPath("//ul[@class='page-list page-list-level-2']/li/a");
		System.out.println(customerServicesNames.size());
		for(int i=0;i<customerServicesNames.size();i++) {
			System.out.println(customerServicesNames.get(i).getText());
		}
		
		// 7. Verify the title
		System.out.println("  ");
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("Customer Service")) {
			System.out.println("Title is verified successfully");
		} else
			System.out.println("Title verification is failed");
		
	}

}
