package workingwithmultiplelements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheclAllBrokenLinks {
	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/"); 
	}
	@Test
	public void testbrokenlinks() throws IOException
	{
		List<WebElement>links =driver.findElements(By.tagName("a"));
		System.out.println("total links are "+ links.size());
		for( int i=0;i<links.size(); i++)
		{
			WebElement element= links.get(i);
			String url= element.getAttribute("href");
			veriftlink(url);
		}
	}
	public static  void veriftlink(String urllink) throws IOException
	{
		try {
			URL link =new URL(urllink);
			//create connection using URL object 
			HttpURLConnection httpconnection =  (HttpURLConnection) link.openConnection();
			httpconnection.setConnectTimeout(2000);
			httpconnection.connect();
			//using get response  to get response code 
			if (httpconnection.getResponseCode()==200)
			{
				System.out.println( urllink + " _ " + httpconnection.getResponseMessage());
			}
			if (httpconnection.getResponseCode()==404)
			{
				System.out.println( urllink + " _ " + httpconnection.getResponseMessage());
			}
		    }
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
	}

	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}

}
