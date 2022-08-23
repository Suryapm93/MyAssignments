package week2.Day2.Assignment1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("SuryaTL");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("SelvamTL");
		driver.findElement(By.xpath("(//input[contains(@name,'reg_email')])[1]")).sendKeys("surya@gamil.com");
		driver.findElement(By.xpath("//input[contains(@name,'email_confirm')]")).sendKeys("surya@gamil.com");
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("Surya@1993");
		WebElement elementDateDropdown = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateDropdown = new Select(elementDateDropdown);
		dateDropdown.selectByIndex(17);
		WebElement elementMonthDropdown = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthDropdown = new Select(elementMonthDropdown);
		monthDropdown.selectByValue("2");
		WebElement elementYearDropdown = driver.findElement(By.xpath("//select[contains(@name,'thday_ye')]"));
		Select yearDropdown = new Select(elementYearDropdown);
		yearDropdown.selectByVisibleText("1993");
		driver.findElement(By.xpath("//span[contains(@data-name,'gender')]/span/label[text()='Female']")).click();
	}
	
}
