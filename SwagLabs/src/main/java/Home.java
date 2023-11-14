import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
    public WebElement Dropdown(WebDriver driver){
   By classname=By.className("product_sort_container");
   WebElement Dropdown=driver.findElement(classname);
   return Dropdown;
    }

    public WebElement HighestItem(WebDriver driver) {
        By xpath=By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[4]");
        WebElement HighestItem=driver.findElement(xpath);
        return HighestItem;
    }
    public WebElement SelectHighestPrice(WebDriver driver){
        By xpath=By.xpath("//*[@id=\"item_5_title_link\"]/div");
        WebElement SelectHighestPrice=driver.findElement(xpath);
return SelectHighestPrice;
    }
    public WebElement AddCart(WebDriver driver){
        By xpath=(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button"));
        WebElement AddCart=driver.findElement(xpath);
        return AddCart;
    }
    public WebElement LowestItem(WebDriver driver) {
        By xpath=By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[4]");
        WebElement LowestItem=driver.findElement(xpath);
        return LowestItem;
    }
    public WebElement SelectLowestPrice(WebDriver driver){
        By xpath=By.xpath("//*[@id=\"item_2_title_link\"]/div");
        WebElement SelectLowestPrice=driver.findElement(xpath);
        return SelectLowestPrice;
    }
    public WebElement Highestprice(WebDriver driver){
        By xpath=By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/div[3]");
        WebElement Highestprice=driver.findElement(xpath);
        return Highestprice;
    }
    public WebElement Lowestprice(WebDriver driver){
        By xpath=By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/div[3]");
        WebElement Lowestprice=driver.findElement(xpath);
        return Lowestprice;
    }
    public WebElement Cart(WebDriver driver){
        By id=By.id("shopping_cart_container");
        WebElement Cart=driver.findElement(id);
        return Cart;
    }
    public WebElement Back(WebDriver driver){
        By xpath=By.xpath("//*[@id=\"inventory_item_container\"]/div/button");
WebElement Back=driver.findElement(xpath);
return Back;
    }
}
