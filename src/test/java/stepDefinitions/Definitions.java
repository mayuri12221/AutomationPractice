package stepDefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.Config;
import drivers.Driver;
import junit.framework.Assert;
import library.Operations;
import objectRepository.Cart;
import objectRepository.Home;
import objectRepository.Registration;
import objectRepository.SignIn;
import objectRepository.SummerDresses;
import testData.Data;


public class Definitions
{
	public static WebDriver driver;
	public static String scenario;
	public static String Scenario_Name;
	public String quantity;
	public String cost;
	public ArrayList<String> costList;
	public ArrayList<String> costList_Sorted;
	
	@BeforeClass
    public static void before(Scenario scenario) 
	{
      
        Scenario_Name = ((Thread) scenario).getName();
        System.out.println("Execution started for scenario: "+ Scenario_Name);
    }
	
	
	
	@Given("^user is on Home page$")
	public void natigate_to_home_page() throws Throwable {
	try 
	{
		String browser=System.getProperty("Browser");
		browser="chrome";
		System.out.println("invoked browser: "+browser);		
		driver=Driver.Initialize(browser);	
		Config conf= new Config(System.getProperty("user.dir") + "//ConfigProperties//config.properties");		
		driver.get(conf.getObject("URL"));
	}
	catch(Exception ex)
	{
		driver.quit();
	}
}

@When("^user navigates to sign in page$")
public void user_navigate_to_signin() throws Throwable {
	driver.findElement(Home.SignIn).click();
}

@When("^user clicks enters valid email$")
public void user_enter_valid_email() throws Throwable {
	Random rand=new Random();
	int randonNumber = rand.nextInt();				
	Operations.EnterText(driver, SignIn.Enail_Id, "Email123"+ randonNumber +"@gmail.com");
    
}

@When("^user click on create an account$")
public void user_click_on_create_an_account() throws Throwable {
	driver.findElement(SignIn.CreateAccount).click();
    
}

@When("^user give all required registration details$")
public void user_give_all_required_registration_details() throws Throwable {
	String url=driver.getCurrentUrl();	
	Assert.assertTrue(url.contains("authentication"));
	Driver.WaitMethod(driver, Registration.Title_Mr);
	
	Scenario_Name = "Successful registration";
	if(Data.getCellValue("Title", Scenario_Name).equalsIgnoreCase("mr"))
	{
		Operations.Click(driver, Registration.Title_Mr);
	}
	else
	{
		Operations.Click(driver, Registration.Title_Mrs);
	}
	Operations.EnterText(driver, Registration.FirstName, Data.getCellValue("FirstName", Scenario_Name));
	Operations.EnterText(driver, Registration.LastName, Data.getCellValue("LastName", Scenario_Name));		
	driver.findElement(Registration.password).sendKeys("password");
	
	if(Data.getCellValue("NewsLetter", Scenario_Name).equalsIgnoreCase("yes")){
		Operations.Click(driver,Registration.NewsLetter );
	}
	if(Data.getCellValue("Offers", Scenario_Name).equalsIgnoreCase("yes")){
		Operations.Click(driver,Registration.Offers );
	}
	Operations.EnterText(driver, Registration.Addr_FirstName, Data.getCellValue("Address_FirstName", Scenario_Name));
	Operations.EnterText(driver, Registration.Addr_LastName, Data.getCellValue("Address_LastName", Scenario_Name));
	Operations.EnterText(driver, Registration.Company, Data.getCellValue("Company", Scenario_Name));
	Operations.EnterText(driver, Registration.Address, Data.getCellValue("Address", Scenario_Name));
	Operations.EnterText(driver, Registration.Addr_Line2, Data.getCellValue("Address_Line2", Scenario_Name));
	Operations.EnterText(driver, Registration.Addr_City, Data.getCellValue("City", Scenario_Name));
	new Select(driver.findElement(Registration.Addr_State)).selectByVisibleText(Data.getCellValue("State", Scenario_Name));
	Operations.EnterText(driver, Registration.Addr_ZipCode, Data.getCellValue("Address_ZipCode", Scenario_Name));
	Operations.EnterText(driver, Registration.Addr_HomePhone, Data.getCellValue("HomePhone", Scenario_Name));
	Operations.EnterText(driver, Registration.Addr_MobilePhone, Data.getCellValue("MobilePhone", Scenario_Name));
	//Operations.EnterText(driver, Registration.Address_ZipCode,"95456");
	Operations.EnterText(driver, Registration.Addr_AdditionalInfo, Data.getCellValue("AdditionalInformation", Scenario_Name));
	Operations.EnterText(driver, Registration.Email_Alias, Data.getCellValue("Alias_Email", Scenario_Name));
	new Select(driver.findElement(Registration.Addr_Country)).selectByValue(Data.getCellValue("Country", Scenario_Name));
	
    
}

@When("^user clicks on register$")
public void user_clicks_on_register() throws Throwable {
    Operations.Click(driver, Registration.Register_Button);
}

@Then("^user should be able to register successfully$")
public void user_should_be_able_to_register_successfully() throws Throwable {
	Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
	System.out.println("Testcase1 Passed");
	Driver.DriverQuit(driver);
}

@When("^user enters invalid email$")
public void user_enters_invalid_email() throws Throwable {
    Operations.EnterText(driver, SignIn.Enail_Id, "test987");
}

@Then("^error message should be displayed$")
public void error_message_should_be_displayed() throws Throwable {
	List<WebElement> Li_Elements= driver.findElement(SignIn.Errors).findElements(By.tagName("LI"));
	   System.out.println("Number of Error Messages are: " + Li_Elements.size());
	   
	   for (WebElement Li:Li_Elements){
	   	System.out.println("Error Message: "+Li.getText());
	   }	   
	   Assert.assertEquals("Error Elements is not 1",Li_Elements.size(),0 ); 
	   System.out.println("Testcase2 Passed");
	  Driver.DriverQuit(driver);
}


@When("^user clicks on Dresses$")
public void user_clicks_on_Dresses() throws Throwable {
	WebElement dressesElement = driver.findElement(Home.Dresses);
	Actions actionObj=new Actions(driver);
	actionObj.moveToElement(dressesElement).build().perform();
    
}

@When("^user clicks on Summer Dresses$")
public void user_clicks_on_Summer_Dresses() throws Throwable {
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(Home.Summer_Dresses));
	driver.findElement(Home.Summer_Dresses).click();
}

@Then("^user navigates Summer Dresses page$")
public void user_navigates_Summer_Dresses_page() throws Throwable {
	String actualUrl = driver.getCurrentUrl();
	 String expectedUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";
	    
		if(actualUrl.compareTo(expectedUrl)==0)
		{
			System.out.println("Testcase3 Passed");
		}
		else
		{
			System.out.println("Testcase3 Failed");
		}
		Driver.DriverQuit(driver);
}

@When("^user clicks on Sort by price$")
public void user_clicks_on_Sort_by_price() throws Throwable {
	//Before sorting, take all prices into a list	
			List<WebElement> costElement=driver.findElements(SummerDresses.Prices);
			costList=new ArrayList<>();		
			for(WebElement price:costElement)
			{
				costList.add(price.getText());
			}		
			Collections.sort(costList);
					
			//Click on sortBy
			new Select(driver.findElement(SummerDresses.SortBy)).selectByValue("price:desc");
				
			Thread.sleep(5000);
			
			//After sorting, take all prices into a list			
			List<WebElement> sorted_PriceElement=driver.findElements(SummerDresses.Prices);
			costList_Sorted=new ArrayList<String>();			
			for(WebElement sortedPrice:sorted_PriceElement)
			{
				costList_Sorted.add(sortedPrice.getText());
			
			}
}

@Then("^items should be arranged accordingly$")
public void items_should_be_arranged_accordingly() throws Throwable {
	Assert.assertEquals(costList_Sorted,costList);
	System.out.println("Testcase4 Passed");
	Driver.DriverQuit(driver);
}

@When("^user select a dress$")
public void user_select_a_dress() throws Throwable {
	 driver.findElement(SummerDresses.Dress).click();		 		 
	 quantity=driver.findElement(SummerDresses.Quantity).getAttribute("value");
	 cost=driver.findElement(SummerDresses.Dress_Price).getText();
}

@When("^user change the dress color to blue$")
public void user_change_the_dress_color_to_blue() throws Throwable {
	List<WebElement> colorList=driver.findElements(By.xpath("//ul[@id=\"color_to_pick_list\"]//a"));		
	System.out.println(colorList.size() + " Colors found");
	driver.findElement(By.xpath("//ul[@id=\"color_to_pick_list\"]//a[@name=\"Blue\"]")).click();
}

@When("^user add the product to cart$")
public void user_add_the_product_to_cart() throws Throwable {
	driver.findElement(SummerDresses.AddToCart).click();
	Driver.WaitMethod(driver, SummerDresses.Proceed_To_Checkout);
	driver.findElement(SummerDresses.Proceed_To_Checkout).click();
}

@Then("^user should see proper Details of the product in the cart summary$")
public void user_should_see_proper_Details_of_the_product_in_the_cart_summary() throws Throwable {
	Driver.WaitMethod(driver,Cart.CartHeader);
	
	//Take color, quantity and price of the product in the cart
	String  actualColor=driver.findElement(Cart.Color).getText();
	String  actualQuantity=driver.findElement(Cart.Quantity).getAttribute("value");
	String  actualPrice=driver.findElement(Cart.Price).getText();
	
	//Comparing 
	Assert.assertTrue(actualColor.contains("Blue"));
	Assert.assertEquals(actualQuantity,quantity);
	Assert.assertEquals(actualPrice,cost);
	System.out.println("Testcase5 Passed");
	Driver.DriverQuit(driver);
}
   
}
