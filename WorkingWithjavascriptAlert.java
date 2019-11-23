package workingwithelements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithjavascriptAlert {
	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
	}
	@Test
	public void testalert() throws InterruptedException
	{
		WebElement Bbtnalert=driver.findElement(By.id("simple"));
		Bbtnalert.click();
		Alert alert=driver.switchTo().alert();
		String alerttext= alert.getText();
		
		Assert.assertEquals("Hello! I am an alert box!", alerttext);
		alert.accept();
		Thread.sleep(2000);
	}
	
	
	
	
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}

}
