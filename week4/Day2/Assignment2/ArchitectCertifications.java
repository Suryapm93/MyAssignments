package week4.Day2.Assignment2;

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

public class ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException {

		/*Assignments 2. Architect Certifications
		==========================
		1. Launch Salesforce application https://login.salesforce.com/
		2. Login with username as ramkumar.ramaiah@testleaf.com and password as Password#123
		3. Click on Learn More link in Mobile Publisher
		4. Click  On Resources
		5. Select SalesForce Certification Under Learnings
		6. Choose Your Role as Salesforce Architect
		7. Get the Text(Summary) of Salesforce Architect 
		8. Get the List of Salesforce Architect Certifications Available
		9. Click on Application Architect 
		10.Get the List of Certifications available
		 */

		// 1. Launch Salesforce application https://login.salesforce.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

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

		// 4. Click  On Resources
		//Resouces is under shadow dom
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//a[text()='Resources']").click();

		// 5. Select SalesForce Certification Under Learnings
		dom.findElementByXPath("//span[text()='Learning']").click();
		Thread.sleep(1000);
		//mouse hover on Learning on Trailhead
		Actions builder = new Actions(driver);
		WebElement learningOnTrailhead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		builder.moveToElement(learningOnTrailhead).click().perform();
		WebElement salesForceCertification = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		builder.moveToElement(salesForceCertification).click().perform();

		// 6. Choose Your Role as Salesforce Architect
		WebElement salesforceArchitectRole = driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']/parent::a"));
		salesforceArchitectRole.click();
		Thread.sleep(3000);

		// 7. Get the Text(Summary) of Salesforce Architect 
		WebElement summaryOfSalesArchitect = driver.findElement(By.xpath("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']"));
		System.out.println("Summary Of Salesforce architect: " + summaryOfSalesArchitect.getText());

		// 8. Get the List of Salesforce Architect Certifications Available
		System.out.println("   ");
		System.out.println("List of Salesforce Architect Certifications Available:");
		System.out.println("   ");
		List<WebElement> listOfSalesCertificate = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for(int i=0;i<listOfSalesCertificate.size();i++) {
			System.out.println(listOfSalesCertificate.get(i).getText());
		}

		// 9. Click on Application Architect 
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();

		// 10.Get the List of Certifications available
		System.out.println(" ");
		System.out.println("List of Application Architect Certifications available: ");
		List<WebElement> appArchitectCertifications = driver.findElements(By.xpath("//div[@class='trailMix-card-body_title']"));
		for(int i=0;i<appArchitectCertifications.size();i++) {
			System.out.println(appArchitectCertifications.get(i).getText());
		}		
	}
}