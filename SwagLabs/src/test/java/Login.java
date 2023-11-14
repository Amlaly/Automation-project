import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class Login {

    WebDriver driver = null;
    LoginPage login;

    @BeforeMethod
    public void OpenPage()
    {
       driver=new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
       login=new LoginPage();

    }
    @Test
    public void validData()
    {   //Enter valid username and valid password

        login.usernameElement(driver).clear();
        login.usernameElement(driver).sendKeys("standard_user");
        login.PasswordElement(driver).sendKeys("secret_sauce");
        login.LoginButtonElement(driver).click();

    }
    @Test
    public void invalidData1()
    {//Enter valid username and empty password
        login.usernameElement(driver).clear();
        login.usernameElement(driver).sendKeys("standard_user\n");
        login.LoginButtonElement(driver).click();
        //Soft assert
        SoftAssert soft=new SoftAssert();
        String expectedResult="Password is required\n";
String actualResult=driver.findElement(By.cssSelector("h3[data-test=\"error\"]")).getText();
soft.assertEquals(actualResult.contains(expectedResult),true);

  }
    @Test
    public void invalidData2()
    {//Enter valid password and empty username
        login.PasswordElement(driver).click();
        login.PasswordElement(driver).sendKeys("secret_sauce");
        login.LoginButtonElement(driver).click();
//soft assert
        SoftAssert soft=new SoftAssert();
        String expectedResult=" Username is required";
        String actualResult=driver.findElement(By.cssSelector("h3[data-test=\"error\"]")).getText();
        soft.assertEquals(actualResult.contains(expectedResult),true);
    }


    @Test
    public void invalidData3()
    {   //Enter invalid username and invalid password(with spaces at first)
        login.usernameElement(driver).clear();
        login.usernameElement(driver).sendKeys(" standard_user\n");
        login.PasswordElement(driver).sendKeys(" secret_sauce");
        login.LoginButtonElement(driver).click();
        //soft assert
    SoftAssert soft=new SoftAssert();
    String expectedResult=" Username and password do not match any user in this service";
    String actualResult=driver.findElement(By.cssSelector("h3[data-test=\"error\"]")).getText();
    soft.assertEquals(actualResult.contains(expectedResult),true);

    }
    @Test
    public void invalidData4()
    {   //Enter invalid username(with spaces at first) and valid password
        login.usernameElement(driver).clear();
        login.usernameElement(driver).sendKeys(" standard_user\n");
        login.PasswordElement(driver).sendKeys("secret_sauce");
        login.LoginButtonElement(driver).click();
       //soft assert
        SoftAssert soft=new SoftAssert();
        String expectedResult=" Username and password do not match any user in this service";
        String actualResult=driver.findElement(By.cssSelector("h3[data-test=\"error\"]")).getText();
        soft.assertEquals(actualResult.contains(expectedResult),true);
    }

    @Test
    public void invalidData5()

    {   //Enter valid username and invalid password(with spaces at first)
        login.usernameElement(driver).clear();
        login.usernameElement(driver).sendKeys("standard_user\n");
        login.PasswordElement(driver).sendKeys(" secret_sauce");
        login.LoginButtonElement(driver).click();
        //soft assert
        SoftAssert soft=new SoftAssert();
        String expectedResult=" Username and password do not match any user in this service";
        String actualResult=driver.findElement(By.cssSelector("h3[data-test=\"error\"]")).getText();
        soft.assertEquals(actualResult.contains(expectedResult),true);
    }
@Test
    public void invalidData6(){
        //Enter empty username and empty password
    login.LoginButtonElement(driver).click();
    //soft assert
    SoftAssert soft=new SoftAssert();
    String expectedResult=" Username and password do not match any user in this service";
    String actualResult=driver.findElement(By.cssSelector("h3[data-test=\"error\"]")).getText();
    soft.assertEquals(actualResult.contains(expectedResult),true);
}

    @Test
    public void validDataEntry()
    {   //Enter valid username and valid password and close website
        login.usernameElement(driver).clear();
        login.usernameElement(driver).sendKeys("standard_user");
        login.PasswordElement(driver).sendKeys("secret_sauce");
        login.LoginButtonElement(driver).click();

    }
}
