package workingwithmultiplelements;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadusinfRobot {
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
	public void uploadfileusingrobot() throws InterruptedException, AWTException
	{
		String imagename="avatar-blank.jpg";
		String imagepath= System.getProperty("user.dir")+"/uploads/"+ imagename;
		WebElement uploadfile= driver.findElement(By.id("file-upload"));
		uploadfile.click();
	   
		//code using robot for file upload 
		Robot robot =new Robot();
		//ctr+c  copy image path
		StringSelection selection = new StringSelection(imagepath);
		Clipboard clib= Toolkit.getDefaultToolkit().getSystemClipboard();
		clib.setContents(selection, null);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);

		// click on ctr+v past image

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

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
		driver.quit();
	}

}
