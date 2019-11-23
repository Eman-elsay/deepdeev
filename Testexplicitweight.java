package workingwithmultiplelements;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testexplicitweight {
	 public WebDriver driver;
		@BeforeTest
		public void setup()
		{
			String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
			System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
			driver=new ChromeDriver();
			driver.navigate().to("https://www.google.com");
			driver.manage().window().maximize();
		}
		@Test
		public void testexplicitiweight()
		{
			WebElement querytxt= driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		querytxt.sendKeys("selenium webdriver");
		querytxt.click();
		WebDriverWait waiting= new WebDriverWait(driver, 20);
		waiting.until(ExpectedConditions.titleContains("selenium webdriver"));
		assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
		
		}
		
		
		@AfterTest
		public void teardwon()
		{
			driver.quit();
		}
		



}
