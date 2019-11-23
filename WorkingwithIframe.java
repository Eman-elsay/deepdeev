package workingwithmultiplelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class WorkingwithIframe {
	 public WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
		driver.manage().window().maximize();
	}
	@Test
	public void testframeswithidorname()
	{
		driver.switchTo().frame("left");
	WebElement mesage=driver.findElement(By.tagName("p"))	;
	Assert.assertEquals("This is Left Frame", mesage.getText());
	System.out.println(mesage.getText());
	driver.switchTo().defaultContent();
	driver.switchTo().frame("right");
	WebElement mass=driver.findElement(By.tagName("p"));
	Assert.assertEquals("This is Right Frame",mass.getText());
	System.out.println(mass.getText());
	driver.switchTo().defaultContent();
	driver.switchTo().frame(1);
	WebElement mass2=driver.findElement(By.tagName("p"));
	Assert.assertEquals("This Frame doesn't have id or name",mass2.getText());
	System.out.println(mass2.getText());
	driver.switchTo().defaultContent();
	}
	@AfterTest
	public void teardwon()
	{
		driver.quit();
	}
	

}
