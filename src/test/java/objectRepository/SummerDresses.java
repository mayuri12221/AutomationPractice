package objectRepository;

import org.openqa.selenium.By;

public class SummerDresses
{
	public static By SortBy=By.xpath("//select[@id=\"selectProductSort\"]");
	public static By AddToCart=By.xpath("//span[contains(text(),'Add to cart')]");		
	public static By Prices=By.xpath("//div[@class=\"right-block\"]//div[@class=\"content_price\"]/span[@class=\"price product-price\"]");
	public static By Dress_Price=By.xpath("//span[@id=\"our_price_display\"]");
	public static By Quantity=By.xpath("//input[@name=\"qty\"]");
	public static By Proceed_To_Checkout=By.xpath("//a[@title=\"Proceed to checkout\"]");
	public static By Dress=	By.xpath("//a[@class=\"product_img_link\"]/img[@title=\"Printed Summer Dress\"]");

}
