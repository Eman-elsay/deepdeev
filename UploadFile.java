package workingwithmultiplelements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFile {
	ChromeDriver driver ;
	@BeforeTest
	public void OpenURL()
	{
		String chromepath= System.getProperty("user.dir")+"//resources//chromedriver.exe" ;
		System.setProperty("WebDriver.Chrome.driver",System.getProperty("user.dir")+chromepath);
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/upload"); 
	}
	@Test
	public void testfileupload() throws InterruptedException
	{
		String imagename="avatar-blank.jpg";
		String imagepath= System.getProperty("user.dir")+"/uploads/"+ imagename;
		WebElement uploadfilebtn= driver.findElement(By.id("file-upload"));
	uploadfilebtn.sendKeys(imagepath);
		
		WebElement submitebtn= driver.findElement(By.id("file-submit"));
		submitebtn.click();
		Thread.sleep(2000);
		WebElement uploadedfile = driver.findElement(By.id("uploaded-files"));
		System.out.println(uploadedfile.getText());
		Assert.assertEquals(imagename, uploadedfile.getText());
		
	}
	

	
	@AfterTest
	public void closedriver()
	{
		//driver.quit();
	}
}

