package workingwithmultiplelements;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;

public class testcookies {
	 public WebDriver driver;
	@BeforeTest
	public void setup()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver=new ChromeDriver();
		driver.navigate().to("http://magento-demo.lexiconn.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void tetcookies()
	{
		WebElement langselect= driver.findElement(By.id("select-language"));
		Select selectlang=new Select(langselect);
		Assert.assertEquals("English", selectlang.getFirstSelectedOption().getText());
		Cookie storecookie=driver.manage().getCookieNamed("store");
		Assert.assertEquals(null, storecookie);
		selectlang.selectByVisibleText("German");
		Cookie storecookies=driver.manage().getCookieNamed("store");
		Assert.assertEquals("german", storecookies.getValue());
		//get all cookies
	Set<Cookie>	cookies=driver.manage().getCookies();
	System.out.println("numberofcookies"+ cookies.size());
	Iterator<Cookie>itr=cookies.iterator();
	while(itr.hasNext())
	{Cookie cookie=itr.next();
	System.out.println(cookie.getDomain());
	System.out.println(cookie.getName());

	System.out.println(cookie.getPath());
	System.out.println(cookie.getValue());

	System.out.println(cookie.getExpiry());

	}
	}
	
	@AfterTest
	public void teardwon()
	{
		driver.quit();
	}
	

	

}
