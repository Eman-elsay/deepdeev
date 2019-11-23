package workingwithmultiplelements;

import static org.testng.Assert.assertEquals;

import java.awt.image.TileObserver;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithMultipleWindow {

	public WebDriver driver;

	@BeforeTest
	public void setup()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
		driver.manage().window().maximize();
	}
	@Test
	public void Testmultiplewindow() throws InterruptedException
	{
		String currentwindowid= driver.getWindowHandle();
		WebElement visitbtn= driver.findElement(By.id("visitbutton"));
		visitbtn.click();
		Thread.sleep(2000);
		for(String windowid:driver.getWindowHandles())
		{
			String title=driver.switchTo().window(windowid).getTitle();
			if(title.equals("Visit Us"))
			{
			assertEquals("Visit Us", driver.getTitle());
			driver.close();
			break;
			}
		}
		
		driver.switchTo().window(currentwindowid);
		
	}
@Test
public void testmultiplewindowbyname() throws InterruptedException
{
	String currentwindowid= driver.getWindowHandle();
	WebElement helpbtn= driver.findElement(By.id("helpbutton"));
	helpbtn.click();
	Thread.sleep(2000);
	assertEquals("Help", driver.getTitle());
	System.out.println(driver.getTitle());
	driver.switchTo().window(currentwindowid);
	
	}


	@AfterTest
	public void teardwon()
	{
		driver.quit();
	}



}
