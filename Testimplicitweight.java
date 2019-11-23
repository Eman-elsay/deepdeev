package workingwithmultiplelements;

import static org.testng.Assert.assertTrue;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testimplicitweight {
	 public WebDriver driver;
		@BeforeTest
		public void setup()
		{
			String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
			System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
			driver=new ChromeDriver();
			driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
			driver.manage().window().maximize();
		}
		@Test
		public void testimplictiweight()
		{driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Page 4")).click();
			WebElement massage=driver.findElement(By.id("page4"));
		assertTrue(massage.getText().contains("Nunc"));
		}
		
		
		@AfterTest
		public void teardwon()
		{
			driver.quit();
		}
		


}
