package loyality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class check {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://reward.bankofmaharashtra.in/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='#modal_login']")).click();
		Thread.sleep(3000);	
		driver.findElement(By.xpath("(//input[@name='customer_id'])[1]")).sendKeys("639392");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shubham@1234");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Product Catalogue")).click();		
		driver.findElement(By.xpath("(//div[@class='card'])[36]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='card'])[56]")).click();
		Thread.sleep(3000);
		List WebElement = driver.findElements(By.xpath("//div[@class='card']"));
		int a= WebElement.size();
		System.out.println(a);
		

	}

}
