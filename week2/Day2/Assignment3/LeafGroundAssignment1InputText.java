package week2.Day2.Assignment3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssignment1InputText {

	public static void main(String[] args) throws InterruptedException {
		//Launch Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0tmb2389go0xlxjvuy66xu9p668024.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Type your name
		System.out.println("Type your name");
		driver.findElement(By.xpath("//input[@placeholder='Babu Manickam']")).sendKeys("SuryaP");
		String typedNameInsideInputField = driver.findElement(By.xpath("//input[@placeholder='Babu Manickam']")).getAttribute("value");
		if(typedNameInsideInputField.equals("SuryaP")) {
			System.out.println("The typed value " +typedNameInsideInputField+  " is correct");
		}else
			System.out.println("The typed value is incorrect");
		
		//Append Country to this City.
		System.out.println("Append Country to this City.");
		driver.findElement(By.xpath("//input[@value='Chennai']")).sendKeys("India");
		//verifying whether country name is appended to city name
		String attributeCityCountryName = driver.findElement(By.xpath("//input[@value='Chennai']")).getAttribute("value");
		System.out.println("After Appending the name is : " + attributeCityCountryName);
		if(attributeCityCountryName.contains("India")) {
			System.out.println("Country name is appeneded to City name successfully");
		}else
			System.out.println("Country name is not appended");
		
		
		//Verify if text box is disabled
		System.out.println("Verify if text box is disabled");
		WebElement textBox = driver.findElement(By.xpath("//input[@disabled='disabled']"));
		if(textBox.isEnabled()) {
			System.out.println("The Textbox is Enabled. Return: " + textBox.isEnabled());
		} else
			System.out.println("The Textbox is Disabled. Return: " + textBox.isEnabled());
		
		//Clear the typed text.
		System.out.println("Clear the typed text.");
		driver.findElement(By.xpath("//input[contains(@value,'Can you clear me')]")).clear();
		//Verifying whether the type text is cleared
		String textinsideInputField = driver.findElement(By.xpath("//input[contains(@value,'Can you clear me')]")).getAttribute("value");
		if(textinsideInputField.isEmpty()) {
			System.out.println("Typed text is cleared successfully");
		}else
			System.out.println("Typed text is not cleared successfully");
		
		//Retrieve the typed text.
		System.out.println("Retrieve the typed text.");
		String retrieveTypedText = driver.findElement(By.xpath("//input[contains(@value,'My learning')]")).getAttribute("value");
		//verifying retrieved text
		if(retrieveTypedText.contentEquals("My learning is superb so far.")) {
			System.out.println("Retrieved Text: " +retrieveTypedText );
			System.out.println("Typed text is retrieved successfully");
		}else
			System.out.println("Typed text is not retrieved successfully");
		
		//Type email and Tab. Confirm control moved to next element.
		System.out.println("Type email and Tab. Confirm control moved to next element.");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Your email and tab')]")).sendKeys("suryaaa@gmail.com",Keys.TAB);
		WebElement activeElement = driver.switchTo().activeElement();
		String text = activeElement.getText();
		if(text.isEmpty()) {
			System.out.println("Control moved to next element");
		}else
			System.out.println("Control not moved to next element");
				
		//Type about yourself
		System.out.println("Type about yourself");
		driver.findElement(By.xpath("//h5[contains(text(),'Type about yourself')]/following::textarea")).sendKeys("I'm Surya. Currently working in Temenos");
		
		//Text Editor
		System.out.println("Text Editor");
		driver.findElement(By.xpath("(//div[contains(@class,'ql-editor')])[1]")).sendKeys("Doing WeekEnd Assignments");
		
		//Just Press Enter and confirm error message
		System.out.println("Just Press Enter and confirm error message");
		driver.findElement(By.xpath("//h5[contains(text(),'Press Enter and confirm error')]/following::input[2]")).sendKeys(Keys.ENTER);
		String errorMessage = driver.findElement(By.xpath("//span[contains(@class,'message-error-detail')]")).getText();
		if(errorMessage.contains("Age is mandatory")) {
			System.out.println("Confirmed error message");
		}else
			System.out.println("Not Confirmed error message");
		
		//Click and Confirm Label Position Changes
		System.out.println("Click and Confirm Label Position Changes");
		Point labelPositionBeforeClick = driver.findElement(By.xpath("//label[text()='Username']")).getLocation();
		System.out.println("Before Clicking, Label Position:  " + labelPositionBeforeClick);
		driver.findElement(By.xpath("//h5[contains(text(),'Click and Confirm Label Posi')]/following::input[1]")).click();
		Point labelPositionAfterClick = driver.findElement(By.xpath("//label[text()='Username']")).getLocation();
		System.out.println("After Clicking, Label Position:  " + labelPositionAfterClick);
		if(!labelPositionBeforeClick.equals(labelPositionAfterClick)) {
			System.out.println("Label Position Changed");
		}
		else
			System.out.println("Label Position Not Changed");
		
		//Type your name and choose the third option
		System.out.println("Type your name and choose the third option");
		Thread.sleep(200);
		WebElement typeName = driver.findElement(By.xpath("//h5[contains(text(),'choose the third option')]/following::input[@placeholder='Search']"));
		typeName.sendKeys("Surya");
		Thread.sleep(300);
		//use action class to mouse hover & choose 3rd option
		WebElement elementName = driver.findElement(By.xpath("//span[@class='ui-autocomplete-query'][1]"));
		System.out.println(driver.findElement(By.xpath("//span[@class='ui-autocomplete-query'][1]")).getText());
		Actions builder = new Actions(driver);
		builder.moveToElement(elementName).perform();
		Thread.sleep(200);
		//after mouse hover give down arrow 3 times in order to click it // give inside for loop in order to click 3rd one
		for (int i=0; i<2; i++) {
			typeName.sendKeys(Keys.DOWN);
		}
		typeName.sendKeys(Keys.ENTER);
		
		//Type your DOB (mm/dd/yyyy) and confirm date chosen
		System.out.println("Type your DOB (mm/dd/yyyy) and confirm date chosen");
		driver.findElement(By.xpath("//span[contains(@class,'p-datepicker')]/input")).sendKeys("02/18/1993");
		String calendarMonthYear = driver.findElement(By.xpath("//div[contains(@class,'datepicker-title')]")).getText();
		System.out.println(calendarMonthYear);
		String calendarDate = driver.findElement(By.xpath("(//div[contains(@class,'datepicker-calendar-container')]/table/tbody/tr)[3]/td[5]")).getText();
		System.out.println(calendarDate);
		if((calendarMonthYear.contains("February 1993")) && (calendarDate.contains("18"))) {
			System.out.println("Typed DOB got selected in the calendar correctly");
		} else
			System.out.println("Typed DOB didn't get selected in the calendar");
		
		//Type number and spin to confirm value changed
		System.out.println("Type number and spin to confirm value changed");
		driver.findElement(By.xpath("//span[contains(@class,'ui-spinner')]/input")).sendKeys("10");
		String inputValue = driver.findElement(By.xpath("//input[contains(@class,'ui-spinner-input')]")).getAttribute("value");
		//spin up
		driver.findElement(By.xpath("//a[contains(@class,'ui-spinner-up')]")).click();
		Thread.sleep(200);
		//getting value after spinned up
		String valueAfterSpinUp = driver.findElement(By.xpath("//input[contains(@class,'ui-spinner-input')]")).getAttribute("value");
		//spin down
		driver.findElement(By.xpath("//a[contains(@class,'ui-spinner-down')]")).click();
		Thread.sleep(200);
		//getting value after spinned down
		String valueAfterSpinDown = driver.findElement(By.xpath("//input[contains(@class,'ui-spinner-input')]")).getAttribute("value");	
		System.out.println("InputValue: " + inputValue + "valueAfterSpinUp: " + valueAfterSpinUp + "valueAfterSpinDown: "  + valueAfterSpinDown );
		if((inputValue.equals(valueAfterSpinUp))&&(valueAfterSpinUp.equals(valueAfterSpinDown))) {
			System.out.println("Value NOT changed after spinning");
		} else
			System.out.println("Value changed after spinning");
	
		//Type random number (1-100) and confirm slider moves correctly
		System.out.println("Type random number (1-100) and confirm slider moves correctly");
		//get inital position of slider icon
		Point sliderInitialPosition = driver.findElement(By.xpath("//span[contains(@class,'ui-slider')]")).getLocation();
		System.out.println(sliderInitialPosition);
		//Type random value
		driver.findElement(By.xpath("//input[contains(@id,'slider')]")).sendKeys("55");
		//now get current position of slider icon
		Point sliderPositionAfterTypedValue = driver.findElement(By.xpath("//span[contains(@class,'ui-slider')]")).getLocation();
		//verify both the location
		if(sliderInitialPosition.equals(sliderPositionAfterTypedValue)) {
			System.out.println("Slider Not moved correctly");
		} else
			System.out.println("Slider moved correctly");
		
		
		//Click and Confirm Keyboard appears
		System.out.println("Click and Confirm Keyboard appears");
		driver.findElement(By.xpath("//input[contains(@class,'keyboard-input')]")).click();
		boolean isKeyboardDisplayed = driver.findElement(By.xpath("//div[contains(@class,'keypad-popup')]")).isDisplayed();
		if(isKeyboardDisplayed==true) {
			System.out.println("Keyboard displayed");
		} else
			System.out.println("Keyboard not displayed");
		
		//Custom Toolbar
		System.out.println("Custom Toolbar");
		driver.findElement(By.xpath("//div[contains(@data-placeholder,'Enter your content')]")).sendKeys("TestLeaf Assignments");
	}
	
	
		
}
