package workingwithelements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingwithPromptAlertWithJava {
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
	public void testpromptalert() throws InterruptedException
	{
		WebElement btntry=driver.findElement(By.id("prompt"));
		btntry.click();
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("emankhalid");
		alert.accept();
		Thread.sleep(2000);
		WebElement message=driver.findElement(By.id("prompt_demo"));
		Assert.assertEquals("Hello eman! How are you today?",message.getText());
	}
	
	@AfterTest
	public void closedriver()
	{
	//	driver.quit();
	}

}
