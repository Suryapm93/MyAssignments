package week4.Day1.Assignment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		/* 		 
		* //Pseudo Code 		 
		* 		 
		* 1. Launch URL "http://leaftaps.com/opentaps/control/login" 		 
		* 		 
		* 2. Enter UserName and Password Using Id Locator 		 
		* 		 
		* 3. Click on Login Button using Class Locator 		 
		* 		 
		* 4. Click on CRM/SFA Link 		 
		* 		 
		* 5. Click on contacts Button 		 
		* 	 		 
		* 6. Click on Merge Contacts using Xpath Locator 		 
		* 		 
		* 7. Click on Widget of From Contact 		 
		* 		 
		* 8. Click on First Resulting Contact 		 
		* 		 
		* 9. Click on Widget of To Contact 		 
		* 		 
		* 10. Click on Second Resulting Contact 		 
		* 		 
		* 11. Click on Merge button using Xpath Locator 		 
		* 		 
		* 12. Accept the Alert 		 
		* 		 
		* 13. Verify the title of the page 		 
		*/ 
		
		//to add browser driver to our code
		WebDriverManager.chromedriver().setup();
				
		//to open chrome browser
		ChromeDriver driver = new ChromeDriver();
				
		//to load url in the chrome browser
		driver.get("http://leaftaps.com/opentaps/control/login");
				
		//to maximize the browser window
		driver.manage().window().maximize();
				
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//span[text()='From Contact']/following::a/img")).click();
		//Window Handling
		//driver.getWindowHandle();
		
		//to get unique id of 2 windows
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		//converting SET to LIST to get into new window by using unique id (eg:list.get(1))of windows
		List<String> list = new ArrayList<String>(windowHandles);
		
		//switch to new window: 0 means basewindow, 1 means new window
		driver.switchTo().window(list.get(1));
		
		// to confirm, im currently in new window.. juz printing the title of my new window
		System.out.println(driver.getTitle()); 
		
		//Click on First Resulting Contact 
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-row')]/table/tbody/tr/td[1]/div/a")).click();
		Thread.sleep(300);
		
		// to get back to base window
		driver.switchTo().window(list.get(0));
		
		driver.findElement(By.xpath("//span[text()='To Contact']/following::a/img")).click();
		Thread.sleep(300);
		
		//Again to get unique id of 2 windows
		Set<String> windowHandles1 = driver.getWindowHandles();
				System.out.println(windowHandles1);
				
		//converting SET to LIST to get into new window by using unique id (eg:list.get(1))of windows
		List<String> list1 = new ArrayList<String>(windowHandles1);
		
		//to get into new window
		driver.switchTo().window(list1.get(1));
		Thread.sleep(3000);
		//click on 2nd resulting contact
		driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-col-partyId')])[2]/a")).click();
		Thread.sleep(3000);
		
		// to get back to base window
		driver.switchTo().window(list.get(0));
		
		//Click on Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(300);
		
		//Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		
		//Verify the title of the page
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("View Contact")) {
			System.out.println("Contacts Merged successfully");
		} else
			System.out.println("Contacts Not Merged successfully");
		
		driver.close();
	}

}
