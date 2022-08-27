package week4.Day1.Assignment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceCustomerService {

	public static void main(String[] args) throws InterruptedException {
		/* Assignment for WindowHandles  
		Salesforce Customer service:
		1.Launch the browser
		2.Load the url as https://login.salesforce.com/
		3.Enter the username as ramkumar.ramaiah@testleaf.com
		4. Enter the password as Password#123
		5.click on the login button
		6.click on the learn more option in the Mobile publisher
		7.Switch to the next window using Windowhandles.
		8.click on the confirm button in the redirecting page
		9.Get the title
		10.Get back to the parent window
		11.close the browser */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Mobile Publisher')]/preceding-sibling::span")).click();
		//Switch to the next window using Windowhandles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		//to get into next window
		driver.switchTo().window(list.get(1));
		//click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println("Title of Current Page: " + title);
		//to get back to the parent window
		driver.switchTo().window(list.get(0));
		Thread.sleep(500);
		System.out.println("Title of the Parent Window: " + driver.getTitle());
		Thread.sleep(1000);
		driver.quit();
	}
}
