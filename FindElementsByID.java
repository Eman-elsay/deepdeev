package findelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementsByID {
	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		
	}
	@Test
	public void findelembyid()
	{
		WebElement Usernametxt= driver.findElement(By.id("username"));
		WebElement Passwordtxt= driver.findElement(By.id("password"));
		System.out.println(Usernametxt.getTagName());
		System.out.println(Passwordtxt.getTagName());
	}
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}
	
	
}
