package loyality;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class improve {
	@Test
	public void openurl() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://equinox.equitasbank.com/");
		driver.findElement(By.xpath("//a[@id='login-redirect-path']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='modal_login']/div[1]/div[1]/div[1]/div[1]/form[1]/ul[1]/li[2]/a[1]")).click();
		driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys("639392");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Shubham@1");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
		List<WebElement> abc=driver.findElements(By.tagName("a"));
		Thread.sleep(3000);
		for (WebElement link : abc) {
			String url = link.getAttribute("href");
			verifyLink(url);
			}
	}

	private void verifyLink(String url) throws IOException {
		try {
		URL link = new URL(url);
		HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
		httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
		httpURLConnection.connect();
		
		if (httpURLConnection.getResponseCode() == 200) {
			System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			} else {
			System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
			} catch (Exception e) {
			System.out.println(url + " - " + "is a broken link");
			}
	}

}
