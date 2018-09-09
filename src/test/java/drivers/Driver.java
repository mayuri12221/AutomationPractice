package drivers;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver
{
	public static WebDriver driver;
	static String workingDir = System.getProperty("user.dir");

	
	public static final String ConfigurationPath = workingDir + "//Configproperties//config.properties";
	
	public static WebDriver Initialize(String browser) throws IOException
	{
		System.out.println("Global Constants Configuration"+ConfigurationPath);
		Config config= new Config(ConfigurationPath);
		
		System.out.println("Inside Driver Class");
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",workingDir+config.getObject("DriversPath")+config.getObject("ChromeDriverPath"));
			driver= new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();			
		}
		return driver;
	}

	public static void WaitMethod(WebDriver driver,By by)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			System.out.println("Wait Method: waited for element to be present" + by.toString());
		}
		catch (Exception e){
			System.out.println("Error Message while waiting: " +e.getMessage());
		} 
	}
	
	public static void DriverQuit(WebDriver driver)
	{
		driver.quit();
		System.out.println("Quitting Driver");
	}
	

}
