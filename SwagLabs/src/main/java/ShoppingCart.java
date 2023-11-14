import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
    public WebElement Cart(WebDriver driver){
        By id=By.id("shopping_cart_container");
        WebElement Cart=driver.findElement(id);
        return Cart;
    }
public WebElement Remove(WebDriver driver){
        By xpath=By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button");
        WebElement Remove=driver.findElement(xpath);
        return Remove;
}
    public WebElement ContinueShopping(WebDriver driver)
    {
        By xpath=By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[1]");
        WebElement ContinueShopping=driver.findElement(xpath);
        return ContinueShopping;
    }
    public WebElement Checkout(WebDriver driver){
        By xpath=By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]");
        WebElement Checkout=driver.findElement(xpath);
        return Checkout;
    }


}
