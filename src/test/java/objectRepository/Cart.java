package objectRepository;

import org.openqa.selenium.By;

public class Cart 
{
	public static By CartButton=By.xpath("//a[@title=\"View my shopping cart\"]");
	public static By CartHeader=By.xpath("//h1[contains(text(),'Shopping')]");
	public static By Color=By.xpath("//td[@class=\"cart_description\"]/small/a[contains(text(),'Color')]");
	public static By Quantity=By.xpath("//td[@class=\"cart_quantity text-center\"]/input[2]");
	public static By Price=By.xpath("//td[@class=\"cart_total\"]/span");


}
