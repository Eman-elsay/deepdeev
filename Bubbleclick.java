package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Bubbleclick {

	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	}
	@Test
public void dubbleclicktest() throws InterruptedException
{
		WebElement message= driver.findElement(By.id("message"));
		System.out.println(message.getCssValue("background-color"));
		Assert.assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color"));
		Actions builder=new Actions(driver);
		builder.doubleClick(message).perform();
		System.out.println(message.getCssValue("background-color"));
		Thread.sleep(2000);
		}
	
	
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}


}
