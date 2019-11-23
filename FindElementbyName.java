package findelements;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementbyName {
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
	public void findelembyName()
	{
		try {
			WebElement Usernametxt= driver.findElement(By.name("username"));
			WebElement Passwordtxt= driver.findElement(By. name("password"));
			System.out.println(Usernametxt.getTagName());
			System.out.println(Passwordtxt.getTagName());
		} 	catch(org.openqa.selenium.NoSuchElementException e) {

			System.out.println("the element is not found please use anthor attribute");
		}
	}
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}


}