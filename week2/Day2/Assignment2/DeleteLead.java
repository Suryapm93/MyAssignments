package week2.Day2.Assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
	
		/*http://leaftaps.com/opentaps/control/main		 		
			Delete Lead:		
			1	Launch the browser		
			2	Enter the username		
			3	Enter the password		
			4	Click Login		
			5	Click crm/sfa link		
			6	Click Leads link		
			7	Click Find leads		
			8	Click on Phone		
			9	Enter phone number		
			10	Click find leads button		
			11	Capture lead ID of First Resulting lead		
			12	Click First Resulting lead		
			13	Click Delete		
			14	Click Find leads		
			15	Enter captured lead ID		
			16	Click find leads button		
			17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion	
			18	Close the browser (Do not log out)*/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'rativeSub')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Capturing lead ID of First Resulting lead
		String firstResultingLeadID = driver.findElement(By.xpath("(//div[contains(@class,'grid3-row')]/table/tbody)[1]/tr[1]/td[1]/div/a")).getText();
		System.out.println("First Resulting Lead ID: " + firstResultingLeadID);
		
		//Viewing 1st Resulting Lead
		driver.findElement(By.xpath("(//div[contains(@class,'grid3-row')]/table/tbody)[1]/tr[1]/td[1]/div/a")).click();
		
		//Deletion of 1st Resulting Lead
		driver.findElement(By.linkText("Delete")).click();
		
		//Validation of Lead Deletion by entering captured Lead ID
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstResultingLeadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Verification of Lead Deletion Message
		String message = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).getText();
		if(message.contains("No records")) {
			System.out.println("Lead Deletion is Sucessful");
		}
		else {
			System.out.println("Lead Deletion is Not Successful");
		}
		driver.close();
	}

}
