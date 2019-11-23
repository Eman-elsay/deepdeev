package workingwithmultiplelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFileWithFirefoxOption {
	

public 	FirefoxDriver driver ;
	public static	String downloadpath = System.getProperty("user.dir")+"\\download";
	public static FirefoxOptions options()
	{
		FirefoxOptions option =new FirefoxOptions();
	 option.addPreference("browser.download.folderList", 2);
	 option.addPreference("browser.download.dir", downloadpath);
	 option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
	 option.addPreference("browser.download.manager.showWhenStarting", false );
	 return option;
	}
	@BeforeTest
	public void OpenURL()
	{
		String firefoxpath = System.getProperty("user.dir")+"\\resources\\geckodriver.exe";
		//System.out.println(firefoxpath );
		System.setProperty("WebDriver.gecko.driver", firefoxpath);
	driver  = new FirefoxDriver(options());
		driver.navigate().to("https://the-internet.herokuapp.com/download"); 
	}
	@Test
	public void testdownloadfile() throws InterruptedException
	{
		 WebElement btn= driver.findElement(By.xpath("/html/body/div[2]/div/div/a[15]"));
		btn.click();
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void teardwon()
	{
		driver.quit();
	}
	
}
