package workingwithmultiplelements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestContextMenu {
	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html"); 
	}
	
	@Test
	public void contextmenu() throws InterruptedException
	{
		WebElement clickme= 
				driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		
		Actions builder = new Actions(driver);
		builder.contextClick(clickme);
		WebElement contextmenu=
		driver.findElement(By.xpath("/html/body/ul/li[1]"));
		builder
		.moveToElement(contextmenu)
			.click()
.perform();
		Thread.sleep(2000);
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait= new WebDriverWait(driver,40);
		Alert alert =wait.until(ExpectedConditions.alertIsPresent());
		assertEquals("clicked: edit",alert.getText());
		alert.dismiss();

Thread.sleep(2000);
	}
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}





}
