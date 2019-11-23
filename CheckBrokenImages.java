package workingwithmultiplelements;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBrokenImages {
	ChromeDriver driver ;
	private int  invalidcount;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/broken_images"); 
	}
	@Test
	public void brokenimages()
	{
		invalidcount=0;
		List<WebElement>images =driver.findElements(By.tagName("img"));
		for(WebElement imgElement:images)
		{
			if (imgElement!= null) {
				verifyimageactive(imgElement);
				
			}
			
		}
		System.out.println("total number of invalid images are:"+ invalidcount);
	}
	public void verifyimageactive(WebElement imgElement)
	{
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request= new HttpGet(imgElement.getAttribute("src"));
		try {
			HttpResponse response= client.execute(request);
			if (response.getStatusLine().getStatusCode()!=200) {
				invalidcount++;
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}
}
