package findelements;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByElements {
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
	public void FindElements()
	{
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		Assert.assertEquals(45,links.size());
		for (WebElement link : links) {
			System.out.println(link.getAttribute("href"));
		}
	}
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}
	
}
