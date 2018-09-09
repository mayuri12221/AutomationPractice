package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import drivers.Driver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Operations
{
static String workingDir = System.getProperty("user.dir");
	
	public static void LaunchAppURL(WebDriver driver, String AppURL) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(AppURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String AppTitle = driver.getTitle();
		System.out.println("Page Tite is" + AppTitle);
	}
	
	
	public static void Click(WebDriver driver, By by) {
		try{
			WebElement element = driver.findElement(by);		
			element.click();
			System.out.println("Clicked on the button" + element);
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}		
	}
	
	
	public static void EnterText(WebDriver driver, By by, String text ) {
		try{
			Driver.WaitMethod(driver, by);
			Cleartext(driver,by);
			WebElement element = driver.findElement(by);
			element.sendKeys(text);			
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}				
	}
	
	public static void Cleartext(WebDriver driver, By by)
	{
		WebElement element = driver.findElement(by);		
		element.clear();		
	}	
}
