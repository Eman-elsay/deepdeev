package workingwithelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragandDropActions {

	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");
	}
	@Test
	public void draganddrop() throws InterruptedException
	{
		WebElement Source=driver.findElement(By.id("draggable"));
		WebElement Target= driver.findElement(By.id("droppable"));
		Actions builder=new Actions(driver);
		builder.dragAndDrop(Source, Target).perform();
		Assert.assertEquals("Dropped!", Target.getText());
		Thread.sleep(2000);
	}


	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}

}
