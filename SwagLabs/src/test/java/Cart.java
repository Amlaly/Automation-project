import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cart {
WebDriver driver=null;
    Home homepage;
    LoginPage login;
ShoppingCart cart;


@BeforeMethod
        public void ShoppingCart() throws InterruptedException {
    driver=new ChromeDriver();
    driver.navigate().to("https://www.saucedemo.com/v1/");
    driver.manage().window().maximize();
    login=new LoginPage();
    homepage=new Home();
    cart=new ShoppingCart();
    login.usernameElement(driver).clear();
    login.usernameElement(driver).sendKeys("standard_user");
    login.PasswordElement(driver).sendKeys("secret_sauce");
    login.LoginButtonElement(driver).click();
    Thread.sleep(2000);
    Select Dropdown=new Select(homepage.Dropdown(driver));
    Dropdown.selectByVisibleText("Price (high to low)");
    Thread.sleep(2000);
    homepage.HighestItem(driver).click();
    homepage.SelectHighestPrice(driver).click();
    Thread.sleep(2000);
    homepage.AddCart(driver).click();
    Thread.sleep(2000);
    homepage.Back(driver).click();
    Dropdown.selectByVisibleText("Price (low to high)");
    Thread.sleep(2000);
    homepage.LowestItem(driver).click();
    homepage.SelectLowestPrice(driver).click();
    Thread.sleep(2000);
    homepage.AddCart(driver).click();
    Thread.sleep(2000);
    homepage.Back(driver).click();

}

    @Test
    public void Checkout() throws InterruptedException {
        Thread.sleep(2000);
        cart.Cart(driver).click();
        Thread.sleep(2000);
        cart.Checkout(driver).click();
        Thread.sleep(2000);

    }

    @Test
    public void RemoveAndCheckout() throws InterruptedException {
        Thread.sleep(2000);
        cart.Cart(driver).click();
        Thread.sleep(2000);
        cart.Remove(driver).click();
        Thread.sleep(2000);
        cart.Checkout(driver).click();
        Thread.sleep(2000);

    }
    @Test
    public void OpenAndContinue() throws InterruptedException {
        Thread.sleep(2000);
        cart.Cart(driver).click();
        Thread.sleep(2000);
        cart.ContinueShopping(driver).click();
        Thread.sleep(2000);

    }
    @Test
    public void RemoveAndContinue() throws InterruptedException {
        Thread.sleep(2000);
        cart.Cart(driver).click();
        Thread.sleep(2000);
        cart.Remove(driver).click();
        Thread.sleep(2000);
        cart.ContinueShopping(driver).click();
        Thread.sleep(2000);

    }
    @AfterMethod
    public void Close()
    {
        driver.close();
    }
}
