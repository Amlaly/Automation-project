import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Checkout {
    WebDriver driver = null;
    Home homepage;
    LoginPage login;
    ShoppingCart cart;
    Check Checkout;

    @BeforeMethod
    public void SuccessCheckOut() throws InterruptedException {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        login = new LoginPage();
        homepage = new Home();
        cart = new ShoppingCart();
        Checkout = new Check();
        login.usernameElement(driver).clear();
        login.usernameElement(driver).sendKeys("standard_user");
        login.PasswordElement(driver).sendKeys("secret_sauce");
        login.LoginButtonElement(driver).click();
        Thread.sleep(2000);
        Select Dropdown = new Select(homepage.Dropdown(driver));
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
        Thread.sleep(2000);
        cart.Cart(driver).click();
        Thread.sleep(2000);
        cart.Checkout(driver).click();
    }
    @Test
    public void ValidDataWithContinue() throws InterruptedException {
        Checkout.firstName(driver).sendKeys("Aml");
        Thread.sleep(2000);

        Checkout.lastName(driver).sendKeys("Ali");
        Thread.sleep(2000);

        Checkout.postalCode(driver).sendKeys("123");
        Thread.sleep(2000);

        Checkout.Continue(driver).click();
        Thread.sleep(2000);

        Checkout.Finish(driver).click();
        Thread.sleep(2000);
    }

    @Test
    public void ValidDataWithCancel() throws InterruptedException {
        Checkout.firstName(driver).sendKeys("Aml");
        Thread.sleep(2000);

        Checkout.lastName(driver).sendKeys("Ali");
        Thread.sleep(2000);

        Checkout.postalCode(driver).sendKeys("123");
        Thread.sleep(2000);

        Checkout.Cancel(driver).click();
        Thread.sleep(2000);

    }
    @Test
    public void InValidData1() throws InterruptedException {

        Checkout.lastName(driver).sendKeys("Ali");
        Thread.sleep(2000);

        Checkout.postalCode(driver).sendKeys("123");
        Thread.sleep(2000);
        Checkout.Continue(driver).click();
        Thread.sleep(2000);
    }
    @Test
    public void InValidData2() throws InterruptedException {
        Checkout.firstName(driver).sendKeys("Aml");
        Thread.sleep(2000);

        Checkout.postalCode(driver).sendKeys("123");
        Thread.sleep(2000);

        Checkout.Continue(driver).click();
        Thread.sleep(2000);
    }
    @Test
    public void InValidData3() throws InterruptedException {
        Checkout.firstName(driver).sendKeys("Aml");
        Thread.sleep(2000);

        Checkout.lastName(driver).sendKeys("Ali");
        Thread.sleep(2000);
        Checkout.Continue(driver).click();

        Thread.sleep(2000);

    }
    @AfterMethod
    public void closepage()
    {
        driver.close();
    }
}















