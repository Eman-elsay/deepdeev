package findelements;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBrowserCommands {
	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");

	}
	@Test
	public void testbrowsercommads()
	{
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}
}
