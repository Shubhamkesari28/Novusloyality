package loyality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import project.Base;
public class Login extends Base {
	WebDriver driver;
	public Login() {
		super();
	}
		
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyloginWithValidCredentials() throws InterruptedException {
	
		driver.findElement(By.xpath("(//input[@name='customer_id'])[1]")).sendKeys("639392");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shubham@1234");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='btn btn-tertiary']")).isDisplayed(),"Edit your account information");
		Thread.sleep(5000);
	
	}
	@Test(priority = 5)
	private void verifyloginWithinValidCredentials() throws InterruptedException {
	
		driver.findElement(By.xpath("(//input[@name='customer_id'])[1]")).sendKeys("6393920");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shubham@12340");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();	
		Thread.sleep(3000);
		String actualWarningmessage =driver.findElement(By.xpath("//form[@id='login_form']//div[@id='flash_msg']")).getText();
		System.out.println(actualWarningmessage);
		String expectedWarningmessage ="Customer Does Not Exists";
		Assert.assertTrue(actualWarningmessage.contains(expectedWarningmessage),"expected warning message is not displayed");
		
		
	}
	@Test(priority = 3)
	private void verifyloginWithinValididAndInValidPassword() throws InterruptedException {
	  
		driver.findElement(By.xpath("(//input[@name='customer_id'])[1]")).sendKeys("639392");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shubham@12340");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
		String actualWarningmessage =driver.findElement(By.xpath("//form[@id='login_form']//div[@id='flash_msg']")).getText();
		System.out.println(actualWarningmessage);
		String expectedWarningmessage ="Credentials do not match";
		Assert.assertTrue(actualWarningmessage.contains(expectedWarningmessage),"expected warning message is not displayed");
		
		
	}
	@Test(priority = 4)
	private void verifyloginWithinValidPasswordAndInValidId() throws InterruptedException {

		driver.findElement(By.xpath("(//input[@name='customer_id'])[1]")).sendKeys("6393920");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shubham@1234");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();	
		Thread.sleep(3000);
		String actualWarningmessage =driver.findElement(By.xpath("//form[@id='login_form']//div[@id='flash_msg']")).getText();
		System.out.println(actualWarningmessage);
		String expectedWarningmessage ="Customer Does Not Exists";
		Assert.assertTrue(actualWarningmessage.contains(expectedWarningmessage),"expected warning message is not displayed");
	
		
	}
	@Test(priority = 2)
	private void verifyloginWithnulldata() throws InterruptedException {

		driver.findElement(By.xpath("(//input[@name='customer_id'])[1]")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(" ");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();	
		Thread.sleep(3000);
		String actualWarningmessage =driver.findElement(By.xpath("//label[@id='customer_id-error']")).getText();
		System.out.println(actualWarningmessage);
		String expectedWarningmessage ="This field is required.";
		Assert.assertTrue(actualWarningmessage.contains(expectedWarningmessage),"expected warning message is not displayed");
		
	
	}
}
