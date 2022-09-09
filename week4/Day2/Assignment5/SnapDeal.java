package week4.Day2.Assignment5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		/*	Assignment 5:SnapDeal
		============
		1. Launch https://www.snapdeal.com/
		2. Go to Mens Fashion
		3. Go to Sports Shoes
		4. Get the count of the sports shoes
		5. Click Training shoes
		6. Sort by Low to High
		7. Check if the items displayed are sorted correctly
		8.Select the price range (900-1200)
		9.Filter with color Navy 
		10 verify the all applied filters 
		11. Mouse Hover on first resulting Training shoes
		12. click QuickView button
		13. Print the cost and the discount percentage
		14. Take the snapshot of the shoes.
		15. Close the current window
		16. Close the main window */

		// 1. Launch https://www.snapdeal.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2. Go to Mens Fashion
		WebElement elementMensFashion = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]/ancestor::li"));
		//mouse hover on men's fashion
		Actions builder = new Actions(driver);
		builder.moveToElement(elementMensFashion).perform();
		Thread.sleep(7000);

		// 3. Go to Sports Shoes
		driver.findElement(By.xpath("(//span[text()='Sports Shoes']/parent::a)[1]")).click();

		// 4. Get the count of the sports shoes
		String sportsShoesCount = driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div")).getText();
		System.out.println("Sports Shoes Count: " + sportsShoesCount);

		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(500);

		//6. Sort by Low to High
		driver.findElement(By.xpath("//div[contains(@class,'sorting-sec')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		Thread.sleep(500);

		// 7. Check if the items displayed are sorted correctly
		List<WebElement> productsPrice = driver.findElements(By.xpath("//span[contains(@class,'product-price')]"));
		System.out.println("Number Of Products: " +productsPrice.size());
		System.out.println("      ");
		List<String> listobj = new ArrayList<String>();
		List<String> priceNumOly = new ArrayList<String>();
		System.out.println("Sorted Prices from low to high - as a String: ");
		for(int i=0;i<productsPrice.size();i++) {
			listobj.add(productsPrice.get(i).getText());
			System.out.println(listobj.get(i));//it will list out all the prices as a string (with RS.) Eg: Rs. 499
			String replaceAll = listobj.get(i).replaceAll("[^0-9]",""); //replace all with "" except numbers Eg:Rs. 499 --> 499
			System.out.println(replaceAll);//it will list out all the prices as a string (without RS.) Eg: 499

			priceNumOly.add(replaceAll); //printNumOly list object already created above to store prices(numOnly)
		}

		System.out.println("Sorted Prices after replaceAll:");
		for (int i=0;i<productsPrice.size();i++) {
			System.out.println(priceNumOly.get(i)); //it will print prices (Eg.499) as a string
		}

		//first convert string list into integer list
		//int parseInt = Integer.parseInt(priceNumOly.get(i)); ----> syntax for converting string into integer list
		System.out.println("Sorted Prices from low to high - as an Integer: ");
		for (int k=0;k<productsPrice.size();k++) {		
			int parseInt = Integer.parseInt(priceNumOly.get(k));
			System.out.println(parseInt); //it will print prices (Eg.499) as an Integer
		}
			//checking whether the items are sorted correctly
		for (int i=0;i<productsPrice.size();i++) {
			for(int j=i+1;j<productsPrice.size();j++) {
				int parseInt = Integer.parseInt(priceNumOly.get(i));
				int parseInt1 = Integer.parseInt(priceNumOly.get(j));
				if(parseInt <= parseInt1) {
					System.out.println("Items are sorted correctly by price low to high");
				} else
					System.out.println("Items are NOT sorted correctly by price low to high");
					break;
				}
			}
			
			
		// 8.Select the price range (500-1200)
		//input lowest price value as 500
		WebElement fromValue = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromValue.clear();
		fromValue.sendKeys("500");
		//input highest price value as 1200
		WebElement toValue = driver.findElement(By.xpath("//input[@name='toVal']"));
		toValue.clear();
		toValue.sendKeys("1200");
		//click GO button
		WebElement goElement = driver.findElement(By.xpath("//div[contains(text(),'GO')]"));
		builder.moveToElement(goElement).click().perform();
		Thread.sleep(5000);
		
		// 9.Filter with color Navy
		WebElement navy = driver.findElement(By.xpath("//a[contains(text(),'Navy')]"));
		builder.moveToElement(navy).click().perform();
		Thread.sleep(3000);
		
		
		// 10 verify the all applied filters
		String priceFilterText = driver.findElement(By.xpath("//a[@class='clear-filter-pill']")).getText();
		String colorFilterPrice = driver.findElement(By.xpath("//a[@data-value='Navy']")).getText();
		if((priceFilterText.contains("500"))&&(priceFilterText.contains("1200"))) {
			System.out.println("Price Range Filter is verified successfully");
		}else
			System.out.println("Price Range Filter is NOT verified successfully");
		
		if(colorFilterPrice.contains("Navy")) {
			System.out.println("Color Filter is verified successfully");
		}else
			System.out.println("Color Filter is NOT verified successfully");
		
		// 11. Mouse Hover on first resulting Training shoes
		WebElement firstResultingTrainingShoes = driver.findElement(By.xpath("(//source[contains(@title,'Training Shoes')])[1]"));
		builder.moveToElement(firstResultingTrainingShoes).perform();
		Thread.sleep(800);
		
		// 12. click QuickView button
		WebElement quickViewButton = driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"));
		quickViewButton.click();
		Thread.sleep(4000);
		
		// 13. Print the cost and the discount percentage
		String cost = driver.findElement(By.xpath("(//div[contains(@class,'product-price')]/span)[1]")).getText();
		System.out.println(cost);
		String replaceAll = cost.replaceAll("[^0-9]","");
		System.out.println("Cost of Training Shoes: " +replaceAll);
		
		String discount = driver.findElement(By.xpath("(//div[contains(@class,'product-price')]/span)[2]")).getText();
		System.out.println(discount);
		String replaceAll1 = discount.replaceAll("[a-zA-Z]","");
		System.out.println("Discount of Training Shoes: " +replaceAll1);
		
		// 14. Take the snapshot of the shoes.
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE); //method to take screenshot
		File targetFile = new File ("./snapshot/shoesimg1.png"); //creating an empty file to store screenshot
		FileUtils.copyFile(screenshotAs, targetFile);//copying snapshot into image file
		System.out.println("Snapshot of the Shoes taken");
		
		//15. Close the current window
		driver.close();
		
		// 16. Close the main window 
		driver.quit();
	}
}
