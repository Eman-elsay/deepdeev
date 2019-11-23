package findelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByTableTagName {

	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");

	}
	@Test
	public void findelembytagname()
	{
		WebElement table =driver.findElement(By.id("table1"));
		List<WebElement> rows= table.findElements(By.tagName("tr"));
		System.out.print(rows.size()); 
		System.out.println(rows.get(3).getText());

	} 


	@AfterTest
	public void closedriver()
	{
		//driver.quit();
	}

}
