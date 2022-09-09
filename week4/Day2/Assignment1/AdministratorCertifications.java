package week4.Day2.Assignment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args) throws InterruptedException {
		
		/*	1. Launch Salesforce application https://login.salesforce.com/
			2. Login with username as ramkumar.ramaiah@testleaf.com and password as Password#123
			3. Click on Learn More link in Mobile Publisher
			4. Click confirm on Confirm redirect
			5. Click Resources and mouse hover on Learning On Trailhead
			6. Click on Salesforce Certifications
			7. Click on Ceritification Administrator
			8. Navigate to Certification - Administrator Overview window
			9. Verify the Certifications available for Administrator Certifications should be displayed  
		*/
		
		// 1. Launch Salesforce application https://login.salesforce.com/		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// 2. Login with username as ramkumar.ramaiah@testleaf.com and password as Password#123
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(500);
		
		// 3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[contains(text(),': Mobile Publisher')]/parent::button[@title='Learn More']")).click();
		Thread.sleep(1000);
		
		// 4. Click confirm on Confirm redirect
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
				
		// 5. Click Resources and mouse hover on Learning On Trailhead
		driver.findElement(By.linkText("Resources")).click();
		Thread.sleep(500);
		
		//the element "Learning" is in shadow root dom. so we have to add shadow dom dependency and hv to instantiate the shadow class
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
		Thread.sleep(5000);
		
		//mouse hover on Learning On Trailhead 
		WebElement learningOnTrailhead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder = new Actions(driver);
		builder.moveToElement(learningOnTrailhead).perform();
		
		// 6. Click on Salesforce Certifications
		WebElement elementSFCertifications = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		//scrolldown to Salesforce Certifications element ----> we can use like below line no. 73
		builder.moveToElement(elementSFCertifications).click().perform();
		
		// 7. Click on Ceritification Administrator
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		
		// 8. Navigate to Certification - Administrator Overview window
		driver.navigate().back();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Certification - Administrator Overview")) {
			System.out.println("Navigated to Certification - Administrator Overview window successfully");
		} else
			System.out.println("Navigated NOT happened");
		
		// 9. Verify the Certifications available for Administrator Certifications should be displayed 
		//So again Click on Ceritification Administrator
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		Thread.sleep(3000);
		System.out.println("The below certifications are available under Administrator Certifications");
		System.out.println(" ");
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='trailMix-card-body_title']/a"));
		for(WebElement certification : findElements ) {
			System.out.println(certification.getText());
		}

	}
}
