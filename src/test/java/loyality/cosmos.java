package loyality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cosmos {
	@Test
	public void cosmoslogin() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rewards.cosmosbank.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@href='#modal_login'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys("639392");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shubham@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		}

}
