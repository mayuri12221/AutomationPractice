package objectRepository;

import org.openqa.selenium.By;

public class Registration 
{
	public static By Title_Mr=By.xpath("//input[@id=\"id_gender1\"]");
	public static By Title_Mrs=By.xpath("//input[@id=\"id_gender2\"]");
	public static By FirstName=By.xpath("//input[@name=\"customer_firstname\"]");
	public static By LastName=By.xpath("//input[@name=\"customer_lastname\"]");
	public static By password=By.xpath("//input[@name=\"passwd\"]");
	public static By DOB_Day=By.xpath("//select[@name=\"days\"]");
	public static By DOB_Month=By.xpath("//select[@name=\"months\"]");
	public static By DOB_Year=By.xpath("//select[@name=\"years\"]");
	public static By NewsLetter=By.xpath("//input[@id=\"newsletter\"]");
	public static By Offers=By.xpath("//input[@id=\"optin\"]");
	public static By Addr_FirstName=By.xpath("//input[@id=\"firstname\"]");
	public static By Addr_LastName=By.xpath("//input[@id=\"lastname\"]");
	public static By Company=By.xpath("//input[@id=\"company\"]");
	public static By Address=By.xpath("//input[@id=\"address1\"]");
	public static By Addr_Line2=By.xpath("//input[@id=\"address2\"]");
	public static By Addr_City=By.xpath("//input[@id=\"city\"]");
	public static By Addr_State=By.xpath("//select[@id=\"id_state\"]");
	public static By Addr_ZipCode=By.xpath("//input[@id=\"postcode\"]");
	public static By Addr_Country=By.xpath("//select[@id=\"id_country\"]");
	public static By Addr_AdditionalInfo=By.xpath("//textarea[@id=\"other\"]");
	public static By Addr_HomePhone=By.xpath("//input[@id=\"phone\"]");
	public static By Addr_MobilePhone=By.xpath("//input[@id=\"phone_mobile\"]");
	public static By Email_Alias=By.xpath("//input[@id=\"alias\"]");	
	public static By Register_Button =By.xpath("//button[@id=\"submitAccount\"]");


}
