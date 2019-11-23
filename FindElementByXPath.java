package findelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByXPath {
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
	public void FindelementbyabsolusteXpath()
	{
		WebElement usernametxt= driver.findElement(By.xpath("//*[@id=\"username\"]"));
		System.out.println(usernametxt.getTagName());
		WebElement passwordtxt= driver.findElement(By.xpath("//*[@id=\"password\"]"));
		System.out.println(passwordtxt.getTagName());
		WebElement loginbtn =driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		System.out.println(loginbtn.getText());
	}
	@Test
	public void FindelementbyrelativeXpath()
	{
		WebElement usernametxt= driver.findElement(By.xpath("//input"));
		System.out.println(usernametxt.getTagName());
		WebElement passwordtxt= driver.findElement(By.xpath("//input"));
		System.out.println(passwordtxt.getTagName());
		WebElement loginbtn =driver.findElement(By.xpath("//button"));
		System.out.println(loginbtn.getText());
	}


	
	
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}

}
