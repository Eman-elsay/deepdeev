package workingwithmultiplelements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHtml5VideoPlayer {

	FirefoxDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//geckodriver.exe" ;
		System.setProperty("WebDriver.gecko.driver",System.getProperty("user.dir")+chromepath);
		driver= new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/html5video.html"); 
	}
	@Test
	public void htmlvideoplayer() throws InterruptedException
	{
		WebElement vplayer= driver.findElement(By.id("vplayer"));
		JavascriptExecutor js=  (JavascriptExecutor)driver;
		String source= (String) js.executeScript("return arguments[0].currentsrc", vplayer);
		long duration =(Long) js.executeScript("return arguments[0].duration", vplayer);
		//assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
		assertEquals(25, duration);
		js.executeScript("return arguments[0].play()", vplayer);
		Thread.sleep(6000);
		js.executeScript("return arguments[0].pause()", vplayer);
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}
}
