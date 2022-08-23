package week2.Day2.Assignment3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssignment4CheckBox {

	public static void main(String[] args) throws InterruptedException {

		//Launch Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Basic Checkbox
		System.out.println("Basic Checkbox");
		driver.findElement(By.xpath("(//span[text()='Basic']/preceding-sibling::div)[2]")).click();
		
		//Notification
		System.out.println("Notification");
		//click check box
		driver.findElement(By.xpath("(//span[text()='Ajax']/preceding-sibling::div)[2]")).click();
		Thread.sleep(400);
		String notificationAfterClickingCheckBox = driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText();
		if(notificationAfterClickingCheckBox.contains("Checked")) {
			System.out.println("After clicking on checkbox, Notification is popped up");
		}else
			System.out.println("Notification doesn't pop up");
		//uncheck the checkbox
		driver.findElement(By.xpath("(//span[text()='Ajax']/preceding-sibling::div)[2]")).click();
		Thread.sleep(4000);
		String notificationAfterUncheck = driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText();
		System.out.println(notificationAfterUncheck);
		if(notificationAfterUncheck.contains("Unchecked")) {
			System.out.println("After uncheck the checkbox, Notification is popped up");
		}else
			System.out.println("Notification doesn't pop up");
		
		//Choose your favorite language(s)
		System.out.println("Choose your favorite language(s)");
		driver.findElement(By.xpath("//label[text()='Java']/preceding-sibling::div/div/following-sibling::div")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//label[text()='Python']/preceding-sibling::div/div/following-sibling::div")).click();
		Thread.sleep(4000);
		
		//Tri State Checkbox ---first check
		System.out.println("Tri State Checkbox");
		driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']")).click();
		Thread.sleep(100);
		//capturing first state changed text from pop up
		String textStateChanged1 = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span")).getText();
		String textState1 = driver.findElement(By.xpath("//div[@class='ui-growl-message']/p")).getText();
		System.out.println("State1: " + textStateChanged1 +  textState1);
		Thread.sleep(6000);
		
		//Tri State Checkbox ---- uncheck now
		driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']")).click();
		Thread.sleep(100);
		//capturing second state changed text from pop up
		String textStateChanged2 = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span")).getText();
		String textState2 = driver.findElement(By.xpath("//div[@class='ui-growl-message']/p")).getText();
		System.out.println("State2: " + textStateChanged2 +  textState2);
		
		//Tri State Checkbox ---- check now
		driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']")).click();
		Thread.sleep(100);
		//capturing 0 state changed text from pop up
		String textStateChanged0 = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span")).getText();
		String textState0 = driver.findElement(By.xpath("//div[@class='ui-growl-message']/p")).getText();
		System.out.println("State0: " + textStateChanged0 +  textState0);
		
		//Toggle Switch
		System.out.println("Toggle Switch");
		driver.findElement(By.xpath("(//div[contains(@class,'ui-toggleswitch')])[1]")).click();
		//verifying whether Toogle Switch is on
		WebElement toogleSwitch = driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']"));
		if(toogleSwitch.isEnabled()) {
			System.out.println("Toogle Switch is on");
		} else
			System.out.println("Toogle Switch is off");
		
		//Verify if check box is disabled
		System.out.println("Verify if check box is disabled");
		WebElement checkBox = driver.findElement(By.xpath("//div[contains(@class,'ui-state-disabled')]/span"));
		if(checkBox.isEnabled()) {
			System.out.println("Checkbox is enabled");
		}else 
			System.out.println("Checkbox is disabled");
		
		//Select Multiple
		System.out.println("Select Multiple");
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='London']/preceding-sibling::div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[text()='Paris']/preceding-sibling::div")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
