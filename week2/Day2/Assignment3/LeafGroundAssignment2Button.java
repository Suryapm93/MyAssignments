package week2.Day2.Assignment3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssignment2Button {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click and Confirm title.
		System.out.println("Click and Confirm title.");
		driver.findElement(By.xpath("(//h5[text()='Click and Confirm title.']/following::button)[1]")).click();
		//Once clicked, navigate back to get the title
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		//Confirm if the button is disabled.
		System.out.println("Confirm if the button is disabled.");
		WebElement elementButton = driver.findElement(By.xpath("(//h5[text()='Confirm if the button is disabled.']/following::button)[1]"));
		if(elementButton.isEnabled()) {
			System.out.println("The button is enabled");
		} else
			System.out.println("The button is disabled");
		
		//Find the position of the Submit button
		System.out.println("Find the position of the Submit button");
		Point positionOfSubmitButton = driver.findElement(By.xpath("(//h5[contains(text(),'position of the Submit button')]/following::button)[1]")).getLocation();
		System.out.println("The position of the Submit button: " + positionOfSubmitButton );
	
		//Find the Save button color
		System.out.println("Find the Save button color");
		String saveButtonColor = driver.findElement(By.xpath("//span[text()='Save']")).getCssValue("color");
		System.out.println(saveButtonColor);
		
		//Find the height and width of this button
		System.out.println("Find the height and width of this button");
		Dimension buttonSize = driver.findElement(By.xpath("//h5[text()='Find the height and width of this button']/following::button[1]")).getSize();
		System.out.println(buttonSize);
		
		//Mouse over and confirm the color changed
		System.out.println("Mouse over and confirm the color changed");
		WebElement successButton = driver.findElement(By.xpath("(//span[text()='Success'])[1]"));
		//first check the color of success button before mouse over
		String colorBeforeMouseHover = successButton.getCssValue("background-color");
		System.out.println("colorBeforeMouseHover: " + colorBeforeMouseHover);
		//use Actions class to mouse hover
		Actions builder = new Actions(driver);
		builder.moveToElement(successButton).perform();
		//now check the color of success button during mouse over
		String colorDuringMouseHover = successButton.getCssValue("background-color");
		System.out.println("colorDuringMouseHover: " +colorDuringMouseHover);
		if(colorBeforeMouseHover.equals(colorDuringMouseHover)) {
			System.out.println("Color not changed");
		} else {
			System.out.println("Color changed");
		}
		
		
		//Click Image Button and Click on any hidden button
		System.out.println("Click Image Button and Click on any hidden button");
		driver.findElement(By.xpath("//span[text()='Image']")).click();
		//find a hidden element and do click
		driver.findElement(By.xpath("//div[@class='card ui-fluid']")).click();
		
		//How many rounded buttons are there?
		System.out.println("How many rounded buttons are there?");
		List<WebElement> roundedButton = driver.findElements(By.xpath("//button[contains(@class,'rounded-button')]"));
		System.out.println("No. Of Rounded Buttons: " +roundedButton.size());
	}

}
