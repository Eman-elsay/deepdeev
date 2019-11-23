package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Workingwittextboxandbutton {
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
	public void loginscreen()
	{
		WebElement txtusername=driver.findElement(By.id("username"));
		WebElement txtpassword =driver.findElement(By.id("password"));
		WebElement btnlogin=driver.findElement(By.className("radius"));
		txtusername.clear();
		txtusername.sendKeys("tomsmith");
		txtpassword.clear();
		txtpassword.sendKeys("SuperSecretPassword!");
		btnlogin.click();
		WebElement sucessnotification =driver.findElement(By.id("flash"));
		System.out.println(sucessnotification.getText());
	Assert.assertTrue(sucessnotification.getText().contains("You logged into a secure a"));
	}
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}
	
}
