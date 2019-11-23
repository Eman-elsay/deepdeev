package workingwithmultiplelements;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TakingScrenShoots {
	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("https://www.amazon.com"); 
	}

	@Test
	public void testtakingscreenshotsnfailure()
	{
		WebElement searchtxt= driver.findElement(By.id("twotabsearchtextbox2"));
		searchtxt.sendKeys("selenium webdriver book");
		searchtxt.submit();
		assertTrue(driver.getTitle().contains("selenium webdriver book"));

	}
	@AfterMethod
	public void takescreenshot(ITestResult result ) throws IOException
	{
		if (ITestResult.FAILURE==result.getStatus())
		{
			// create reference to take screen shoot 
			TakesScreenshot ts= (TakesScreenshot)  driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("/.screenshots/"+result.getName()+".png"));


		}
	}


	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}


}
