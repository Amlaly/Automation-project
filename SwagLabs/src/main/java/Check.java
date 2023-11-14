import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Check {

    public WebElement firstName(WebDriver driver){
        By id= By.id("first-name");
        WebElement firstName=driver.findElement(id);
        return firstName;
    }
    public WebElement lastName(WebDriver driver){
        By id= By.id("last-name");
        WebElement lastName=driver.findElement(id);
        return lastName;
    }
    public WebElement postalCode(WebDriver driver){
        By id= By.id("postal-code");
        WebElement postalCode=driver.findElement(id);
        return postalCode;
    }
    public WebElement Continue(WebDriver driver){
        By xpath=By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input");
        WebElement Continue=driver.findElement(xpath);
        return Continue;
    }
    public WebElement Cancel(WebDriver driver){
        By xpath=By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/a");
        WebElement Cancel=driver.findElement(xpath);
        return Cancel;
    }
    public WebElement Finish(WebDriver driver){
        By xpath=By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]");
        WebElement Finish=driver.findElement(xpath);
        return Finish;
    }

}
