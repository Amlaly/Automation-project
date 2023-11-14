import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Homepage {
    WebDriver driver = null;
    Home homepage;
LoginPage login;
    @BeforeTest
    public void SucessLogin(){
        driver=new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        login=new LoginPage();
    login.usernameElement(driver).clear();
        login.usernameElement(driver).sendKeys("standard_user");
        login.PasswordElement(driver).sendKeys("secret_sauce");
        login.LoginButtonElement(driver).click();
        homepage=new Home();
    }
@Test
    public void AddHighestItem() throws InterruptedException {
        Thread.sleep(2000);
Select Dropdown=new Select(homepage.Dropdown(driver));
Dropdown.selectByVisibleText("Price (high to low)");
Thread.sleep(2000);
homepage.HighestItem(driver).click();
homepage.SelectHighestPrice(driver).click();
    Thread.sleep(2000);
   String ExpectedResult="49.99";
    String ActualResult=homepage.Highestprice(driver).getText();
    Assert.assertEquals(ActualResult.contains(ExpectedResult),true);
     homepage.AddCart(driver).click();
     Thread.sleep(2000);
    homepage.Back(driver).click();
}
    @Test
    public void LowestItem() throws InterruptedException {
        Thread.sleep(2000);
        Select Dropdown=new Select(homepage.Dropdown(driver));
        Dropdown.selectByVisibleText("Price (low to high)");
        Thread.sleep(2000);
        homepage.LowestItem(driver).click();
        homepage.SelectLowestPrice(driver).click();
        Thread.sleep(2000);
        String ExpectedResult="7.99";
        String ActualResult=homepage.Lowestprice(driver).getText();
        Assert.assertEquals(ActualResult.contains(ExpectedResult),true);
        homepage.AddCart(driver).click();
        Thread.sleep(2000);
        homepage.Back(driver).click();
    }
    public void AsserPrices() throws InterruptedException {
        homepage.Cart(driver).click();
        Thread.sleep(2000);
        String ExpectedResult="49.99";
        String ActualResult=homepage.Cart(driver).getText();
        Assert.assertEquals(ActualResult.contains(ExpectedResult),true);
        Thread.sleep(2000);
        String Expectedprice="7.99";
        String Actualprice=homepage.Lowestprice(driver).getText();
        Assert.assertEquals(Actualprice.contains(Expectedprice),true);
    }
    }

