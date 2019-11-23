package workingwithmultiplelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScrollPage {
	public WebDriver driver;
	@BeforeTest
	public void setup()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.com");
	
	}
	@Test
	public void testscroll() throws InterruptedException
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,4300)");
		Thread.sleep(2000);
		WebElement amazonlogo= driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[3]/span[1]/div/a/div"));
		Assert.assertTrue(amazonlogo.isDisplayed());
		Thread.sleep(2000);
		
		}
	@AfterTest
	public void teardwon()
	{
		driver.quit();
	}
}
	


