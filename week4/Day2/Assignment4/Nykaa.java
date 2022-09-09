package week4.Day2.Assignment4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
	
		/* 
		 Assignment 4:Nykaa
		 =============
		1) Go to https://www.nykaa.com/
		2) Mouseover on Brands and Search L'Oreal Paris
		3) Click L'Oreal Paris
		4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		5) Click sort By and select customer top rated
		6) Click Category and click Hair->Click haircare->Shampoo
		7) Click->Concern->Color Protection
		8)check whether the Filter is applied with Shampoo
		9) Click on L'Oreal Paris Colour Protect Shampoo
		10) GO to the new window and select size as 175ml
		11) Print the MRP of the product
		12) Click on ADD to BAG
		13) Go to Shopping Bag 
		14) Print the Grand Total amount
		15) Click Proceed
		16) Click on Continue as Guest
		17) Check if this grand total is the same in step 14
		18) Close all windows
		*/
		
		// 1) Go to https://www.nykaa.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// 2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		//Mouseover on Brands
		builder.moveToElement(brands).perform();
		Thread.sleep(2000);
		WebElement brandSearchBox = driver.findElement(By.id("brandSearchBox"));
		brandSearchBox.click();
		//Search L'Oreal Paris
		brandSearchBox.sendKeys("L'Oreal");
		Thread.sleep(3000);
		
		// 3) Click L'Oreal Paris
		driver.findElement(By.xpath("(//a[contains(text(),'real Paris')])[1]")).click();
		Thread.sleep(500);
		
		// 4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		if(title.contains("L'Oreal Paris")) {
			System.out.println("The Title contains L'Oreal Paris");
		} else
			System.out.println("The Title doesn't contain L'Oreal Paris");
		
		// 5) Click sort By and select customer top rated
		//click sort by
		WebElement sortName = driver.findElement(By.xpath("//span[@class='sort-name']/parent::button"));
		sortName.click();
		Thread.sleep(300);
		//select customer top rated
		WebElement customerTopRatedOption = driver.findElement(By.xpath("//span[text()='customer top rated']/parent::div"));
		customerTopRatedOption.click();
		Thread.sleep(2000);
		//verifying whether customer top rated option is selected
		if(sortName.getText().contains("Customer Top Rated")) {
			System.out.println("Sorted Name by Customer Top Rated option");
		} else
			System.out.println("NOT Sorted Name by Customer Top Rated option");
		
		// 6) Click Category and click Hair->Click haircare->Shampoo
		WebElement elementHair = driver.findElement(By.xpath("//a[text()='hair']"));
		//mouse hover on hair
		builder.moveToElement(elementHair).perform();
		Thread.sleep(2000);
		//Click haircare->Shampoo
		WebElement elementShampoo = driver.findElement(By.xpath("//a[text()='Shampoo']"));
		elementShampoo.click();
		Thread.sleep(2000);
		
		//after clicking on shampoo, new window will open so use windowshandler to handle the new window
		Set<String> windowHandles = driver.getWindowHandles();
		//change from SET to LIST
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		// 7) Click->Concern->Color Protection
		WebElement elementConcern = driver.findElement(By.xpath("//span[text()='Concern']/parent::div"));
		elementConcern.click();
		Thread.sleep(300);

		//click on color protection
		WebElement elementColorProtection = driver.findElement(By.xpath("//span[text()='Color Protection']"));
		elementColorProtection.click();
		Thread.sleep(1000);
		
		//8)check whether the Filter is applied with Shampoo
		WebElement elementFiltersApplied = driver.findElement(By.xpath("//span[@class='filter-value']"));
		String filtersText = elementFiltersApplied.getText();
		System.out.println("Filters Applied: " +filtersText);
		if(filtersText.contains("Color Protection")) {
			System.out.println("Filter is applied for shampoo - color protection");
		} else
			System.out.println("Filter is NOT applied for shampoo - color protection");
		
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//a[contains(@href,'l-oreal-paris-color-protect-shampoo')]")).click();
		Thread.sleep(2000);
		
		// 10) GO to the new window and select size as 175ml
		//after Clicking on L'Oreal Paris Colour Protect Shampoo, new window will open so use windowshandler to handle the new window
		Set<String> windowHandles1 = driver.getWindowHandles();
		//change from SET to LIST
		List<String> list1 = new ArrayList<String>(windowHandles1);
		//to go to the new window
		driver.switchTo().window(list1.get(2));
		//select size as 175ml --> use select class
		WebElement DD = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select select = new Select(DD);
		select.selectByVisibleText("175ml");
		
		// 11) Print the MRP of the product
		String productMRP = driver.findElement(By.xpath("(//span[text()='MRP:']/following-sibling::span)[1]")).getText();
		System.out.println("MRP of the Product: " +productMRP );
		
		// 12) Click on ADD to BAG
		driver.findElement(By.xpath("(//span[text()='Add to Bag']/parent::button)[1]")).click();
		Thread.sleep(500);
		
		//13) Go to Shopping Bag 
		driver.findElement(By.xpath("//span[@class='cart-count']/parent::button")).click();
		Thread.sleep(9000);
		
		// 14) Print the Grand Total amount
		//grandtotal is in  frame
		//To get into the frame
		//first find the webelement of the respective frame
		WebElement frameElement = driver.findElement(By.xpath("//iframe[contains(@src,'/mobileCartIframe')]"));
		//using the frame's webelement, get inside the frame
		driver.switchTo().frame(frameElement);
		//capture the text of grandtotal
		String grandTotal = driver.findElement(By.xpath("//div[@class='first-col']/div")).getText();
		System.out.println("Grand Total: " +grandTotal);
				
		// 15) Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		Thread.sleep(2000);
		
		// 16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		// 17) Check if this grand total is the same in step 14
		String finalGrandTotal = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		System.out.println("Final Grand Total: " + finalGrandTotal);
		//verify if this grandtotal and step 14 total is same
		if(finalGrandTotal.contains(grandTotal)){
			System.out.println("This grand total is same as the previous one");
		} else
			System.out.println("This grand total is NOT same as the previous one");
		
		// 18) Close all windows
		driver.quit();
	}

}
