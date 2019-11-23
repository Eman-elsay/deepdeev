package findelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Findlinksbylinktext {
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
	public void textlinktext()
	{
		WebElement selinumlinky= driver.findElement(By.partialLinkText("Selenium"));
		WebElement selinumlink= driver.findElement(By.linkText("Elemental Selenium"));
		System.out.println(selinumlink.getAttribute("href"));
		System.out.println(selinumlinky.getAttribute("href"));
	}
@AfterTest
public void closedriver()
{
	driver.quit();
}

}
