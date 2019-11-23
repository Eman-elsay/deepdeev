package workingwithelements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Confirmalert {
	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html"); 
	}
	
	@Test (priority = 1)
	public void confirmalert() throws InterruptedException
	{
		WebElement btntry= driver.findElement(By.id("confirm"));
		btntry.click();
		Alert alert= driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		WebElement message= driver.findElement(By.id("demo"));
		Assert.assertEquals("You Accepted Alert!", message.getText());
		Thread.sleep(2000);
		
	}
	@Test (priority = 2)
	public void cancelalert() throws InterruptedException
	{
		WebElement btntry= driver.findElement(By.id("confirm"));
		btntry.click();
		Thread.sleep(2000);
Alert alert=driver.switchTo().alert();
		alert.dismiss();
		WebElement message2= driver.findElement(By.id("demo"));
		Assert.assertEquals("You Dismissed Alert!", message2.getText());
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}

}
