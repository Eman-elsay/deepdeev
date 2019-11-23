package workingwithmultiplelements;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownloadWithChromeOption {
	public 	ChromeDriver driver ;
	public static	String downloadpath = System.getProperty("user.dir")+"\\download";
	public static ChromeOptions chromeoption()
	{
		ChromeOptions options=new ChromeOptions();
		
		HashMap<String, Object>chromeprefs= new HashMap<String, Object>();
		chromeprefs.put("profile.default.content_settings.popups", 0);
		chromeprefs.put("download.default.directory",downloadpath);
		options.setExperimentalOption("prefs", chromeprefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}


	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.gecko.driver", chromepath);
		driver  = new ChromeDriver(chromeoption());
		driver.navigate().to("https://the-internet.herokuapp.com/download"); 
	}

	@Test
	public void testdownloadfile() throws InterruptedException
	{
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void teardwon()
	{
		driver.quit();
	}


}
