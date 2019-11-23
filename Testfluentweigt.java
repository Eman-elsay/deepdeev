package workingwithmultiplelements;

import static org.testng.Assert.assertTrue;

import java.awt.SecondaryLoop;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testfluentweigt {
	public WebDriver driver;
	@BeforeTest
	public void setup()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver=new ChromeDriver();
		
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}
	@Test
	public void testfluent()
	{
		driver.findElement(By.linkText("Page 4")).click();
		Wait<WebDriver> fwait= new FluentWait<WebDriver>(driver);
				WebElement massage= fwait.until(new Function<WebDriver, WebElement>() 
				{
					public WebElement apply(WebDriver d)
					{
						return d.findElement(By.id("page4"));
					}
				}


						);
		assertTrue(massage.getText().contains("Nunc nibh tortor"));
	}




	@AfterTest
	public void teardwon()
	{
		driver.quit();
	}

}
