package week2.Day2.Assignment3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssignment3SelectDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Which is your favorite UI Automation tool?
		System.out.println("Which is your favorite UI Automation tool?");
		WebElement automationToolDropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select select = new Select(automationToolDropdown);
		select.selectByIndex(1);
		String favAutomationTool = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']")).getAttribute("value");
		System.out.println("Favorite UI Automation tool: " + favAutomationTool);
		
		//Choose your preferred country.
		System.out.println("Choose your preferred country.");
		//this is not a normal select dropdown so we need to click the dropdown first and then select value
		driver.findElement(By.xpath("//label[contains(@id,'country_label')]")).click();
		Thread.sleep(300);
		System.out.println(driver.findElement(By.xpath("//li[@id='j_idt87:country_1']")).getText());
		driver.findElement(By.xpath("//li[@id='j_idt87:country_1']")).click();
		Thread.sleep(300);
		
		
		//Confirm Cities belongs to Country is loaded
		System.out.println("Confirm Cities belongs to Country is loaded");
		driver.findElement(By.xpath("//label[contains(@id,'city_label')]")).click();
		Thread.sleep(300);
		WebElement City1 = driver.findElement(By.xpath("//li[@id='j_idt87:city_1']"));
		String textCity1= City1.getText();
		City1.click();
		Thread.sleep(300);
		System.out.println(textCity1);
		//now change the country and confirm cities are belonging to the loaded country
		driver.findElement(By.xpath("//label[contains(@id,'country_label')]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//li[@id='j_idt87:country_3']")).click();//Country "India" will get selected
		Thread.sleep(300);
		//Confirm city belongs to Loaded Country (india)
		driver.findElement(By.xpath("//label[contains(@id,'city_label')]")).click();
		Thread.sleep(300);
		WebElement City2 = driver.findElement(By.xpath("//li[@id='j_idt87:city_1']"));
		String textCity2= City2.getText();
		City2.click();
		Thread.sleep(300);
		System.out.println(textCity2);
		//Verify whether the cities are loaded correctly for the selected country recently
		if(!textCity1.equals(textCity2)) {
			System.out.println("Cities are loaded correctly");
		} else
			System.out.println("Cities are not loaded correctly");
		
		
		//Choose the Course
		System.out.println("Choose the Course");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")).click();
		Thread.sleep(300);
		System.out.println(driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).getText());
		driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
		Thread.sleep(400);
		driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")).click();
		Thread.sleep(400);
		System.out.println(driver.findElement(By.xpath("//li[text()='AWS']")).getText());
		driver.findElement(By.xpath("//li[text()='AWS']")).click();
		Thread.sleep(400);
		
		//Choose language randomly
		System.out.println("Choose language randomly");
		driver.findElement(By.xpath("//label[@id='j_idt87:lang_label']")).click();
		Thread.sleep(300);
		System.out.println(driver.findElement(By.xpath("//li[@id='j_idt87:lang_1']")).getText());
		driver.findElement(By.xpath("//li[@id='j_idt87:lang_1']")).click();
		Thread.sleep(300);
		
		
		//Select 'Two' irrespective of the language chosen
		System.out.println("Select 'Two' irrespective of the language chosen");
		driver.findElement(By.xpath("//label[@id='j_idt87:value_label']")).click();
		Thread.sleep(300);
		System.out.println(driver.findElement(By.xpath("//li[@id='j_idt87:value_3']")).getText());
		Thread.sleep(300);
		driver.findElement(By.xpath("//li[@id='j_idt87:value_3']")).click();
	}

}
