package workingwithelements;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithChckboxes {
	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
	}
	@Test(enabled = false)
	public void checkbox() throws InterruptedException
	{
		WebElement checkboxopt1=driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		checkboxopt1.click();
		WebElement checkopt2=driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		if (checkopt2 .isSelected()) 
		{
			checkopt2.click();
		}
		Thread.sleep(2000);
	}
	@Test
	public void testisementpresent() throws InterruptedException
	{
		if (isElementpresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))) {
			WebElement check1=driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
			if (!check1.isSelected()) {
				check1.click();

			}
		} else {
			
			Assert.fail("check1 dosent exist ");
		}
		Thread.sleep(2000);
	}

	private boolean isElementpresent(By by)
	{
		try {
			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}
	}


	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}



}
