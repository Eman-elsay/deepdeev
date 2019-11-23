package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithDropdownlist {
	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/dropdown");

	}
	@Test
	public void testdropdownlist()
	{
		WebElement optionslist=driver.findElement(By.id("dropdown"));
		Select selectoption= new Select(optionslist);
		Assert.assertFalse(selectoption.isMultiple());
		Assert.assertEquals(3, selectoption.getOptions().size());
	//	selectoption.selectByVisibleText("Option 2");
	//	selectoption.selectByValue("1");
		selectoption.selectByIndex(1);
		Assert.assertEquals("Option 1", selectoption.getFirstSelectedOption().getText());
		
	}
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}

}
