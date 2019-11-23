package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithSubmitMethod {
	ChromeDriver driver ;
	WebElement txtsearch;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("https://www.google.com");

	}
	@Test
	public void testsubmit()
	{
		txtsearch= driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		txtsearch.clear();
		txtsearch.sendKeys("facebook");
		txtsearch.submit();
		driver.navigate().back();
		txtsearch= driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		txtsearch.clear();
		txtsearch.sendKeys("selinum webdriver");
		txtsearch.submit();
	}
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}

}
