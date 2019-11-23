package workingwithmultiplelements;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import findelements.FindElementsByID;

public class TestCanvasHtm5 {

	FirefoxDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//geckodriver.exe" ;
		System.setProperty("WebDriver.gecko.driver",System.getProperty("user.dir")+chromepath);
		driver= new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/html5canvasdraw.html"); 
	}
	@Test
public void Testcanvas() throws InterruptedException, IOException
{
		WebElement drawlist= driver.findElement(By.id("dtool"));
		WebElement canvas= driver.findElement(By.id("imageTemp"));
		Select drawtool= new Select(drawlist);
		drawtool.selectByValue("pencil");
		Actions builder= new Actions(driver);
		builder.clickAndHold(canvas).moveByOffset(10, 50).moveByOffset(50, 10)
		.moveByOffset(-10, -50).moveByOffset(-50, -10).release().perform();
		Thread.sleep(3000);
		TakesScreenshot ts= (TakesScreenshot)  driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("./screenshots/canvas.png"));
}
@AfterTest
	public void closedriver()
	{
		driver.quit();
	}
}
