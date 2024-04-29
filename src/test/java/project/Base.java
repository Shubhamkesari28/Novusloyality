package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Base() {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorial\\qa\\config\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) throws InterruptedException {
		
		if(browserName.equals("chrome")){
			driver = new ChromeDriver();	
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}else if(browserName.equals("Firefor")) {
			driver= new FirefoxDriver();
		}else if(browserName.equals("safari")) {
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));			
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='#modal_login']")).click();
		Thread.sleep(3000);	
		
		return driver;
		
		
	}
	

}
