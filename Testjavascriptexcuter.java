package workingwithmultiplelements;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Return;

public class Testjavascriptexcuter {
	public WebDriver driver;
	@BeforeTest
	public void setup()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver=new ChromeDriver();

		driver.navigate().to("https://www.google.com");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}
	@Test
	public void javascript()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title= (String)js.executeScript("return document.title");
		assertEquals("Google", title);
		System.out.println(title);
		long links = (Long) js
				.executeScript("var links = document.getElementsByTagName('A'); return links.length");
		System.out.println(links);
		assertEquals(19,links);
	}
	@AfterTest
	public void teardwon()
	{
		driver.quit();
	}

}
