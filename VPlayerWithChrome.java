package workingwithmultiplelements;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VPlayerWithChrome {
	ChromeDriver driver ;
	private int  invalidcount;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/html5video.html"); 
	}
	
	@Test
	public void htmlvideoplayer() throws InterruptedException, IOException
	{
		WebElement vplayer= driver.findElement(By.id("vplayer"));
		JavascriptExecutor js=  (JavascriptExecutor)driver;
		String source= (String) js.executeScript("return arguments[0].currentsrc", vplayer);
		System.out.println(vplayer);
		long duration =(Long) js.executeScript("return arguments[0].duration", vplayer);
		assertEquals(25, duration);
		assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
		assertEquals(25, duration);
		js.executeScript("context.resume()", vplayer);
		js.executeScript("return arguments[0].play()", vplayer);
		Thread.sleep(6000);
		js.executeScript("return arguments[0].pause()", vplayer);
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void takescreenshot(ITestResult result ) throws IOException
	{
		if (ITestResult.FAILURE==result.getStatus())
		{TakesScreenshot ts= (TakesScreenshot)  driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("./screenshots/vplaye.png"));}
		}

	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}
}
