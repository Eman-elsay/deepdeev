package findelements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindelementByCSSselector {
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
	public void findelembycssselector()
	{
	WebElement usernametxt =driver.findElement(By.cssSelector("input#username"));
				System.out.println(usernametxt.getText());

				WebElement passwordtxt =driver.findElement(By.cssSelector("input#password"));
				System.out.println(passwordtxt.getText());
		//WebElement loginbtn =driver.findElement(By.cssSelector("i.fa fa-2x fa-sign-in"));
		//System.out.println(loginbtn.getText());

	} 


	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}

}


