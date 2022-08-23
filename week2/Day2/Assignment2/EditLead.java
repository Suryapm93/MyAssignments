package week2.Day2.Assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		/*http://leaftaps.com/opentaps/control/main 			 			
		* 1	Launch the browser 			
		* 2	Enter the username 			
		* 3	Enter the password 			
		* 4	Click Login 			
		* 5	Click crm/sfa link 			
		* 6	Click Leads link 			
		* 7	Click Find leads 			
		* 8	Enter first name 			
		* 9	Click Find leads button 			
		* 10 Click on first resulting lead 			
		* 11 Verify title of the page 			
		* 12 Click Edit 			
		* 13 Change the company name 			
		* 14 Click Update 			
		* 15 Confirm the changed name appears 			
		* 16 Close the browser (Do not log out) 
		*/ 	
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Surya");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//div[contains(@class,'firstName')])[2]/a")).click();
		
		//Verifying title of the page
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("Title of the page contains View Lead");
		}
		else {
			System.out.println("Title of the page doesn't contain View Lead ");
		}		
		String beforeEditingCompanyName = driver.findElement(By.xpath("//span[contains(@id,'viewLead_companyName')]")).getText();
		System.out.println("Before Editing, Lead Company Name: " +beforeEditingCompanyName );
		
		//Editing the Lead by changing the company name
		driver.findElement(By.xpath("//div/a[text()='Edit']")).click();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Infy");
		
		//Updating the edited Lead Page
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//Validating the changed company name
		String aftereditingCompanyName = driver.findElement(By.xpath("//span[contains(text(),'Company Name')]/following::span[contains(@id,'companyName')]")).getText();
		System.out.println("After Editing, Lead Company Name: " + aftereditingCompanyName);
		if(aftereditingCompanyName.contains("Infy")) {
			System.out.println("The changed company name appears");
		} else
			System.out.println("The changed company name doesn't appear");
	}

}
