package workingwithelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithWebtable {
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
	public void webtable()
	{
		WebElement table1=driver.findElement(By.id("table1"));
		//get all rows
		List<WebElement>rows= table1.findElements(By.tagName("tr"));
		Assert.assertEquals(5, rows.size());
		//get all cell data 
		for (WebElement row : rows) {
			List<WebElement>cols=row.findElements(By.tagName("td"));
		for (WebElement col : cols) {
			System.out.println(col.getText());
			
		}
		System.out.println();
		}
	}
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}

	

}
