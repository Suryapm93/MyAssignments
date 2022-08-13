package week2.Day1.Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Temenos");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Surya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("PS");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("SuryaP");
		driver.findElement(By.name("departmentName")).sendKeys("Technology");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Lead Creation");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("suryapm93@gmail.com");
		WebElement elementDD = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd1 = new Select(elementDD);
		dd1.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("View Lead"))
		{
			System.out.println("Lead Creation is successful");
		}
		else
			System.out.println("Lead Creation is failed");
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HCL");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("RiyaF");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("View Lead | opentaps CRM"))
		{
			System.out.println("Lead Duplication is successful");
		}
		else
			System.out.println("Lead Duplication is failed");
	}
}