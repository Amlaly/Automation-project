import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebElement usernameElement(WebDriver driver)
    {

        By username=By.id("user-name");
        WebElement usernameElement=driver.findElement(By.id("user-name"));
        return usernameElement;
    }
    public WebElement PasswordElement(WebDriver driver)
    {              By Password=By.id("password");
        WebElement PasswordElement=driver.findElement(By.id("password"));
return PasswordElement;

    }

public WebElement LoginButtonElement(WebDriver driver){
    By login=By.id("login-button");
    WebElement LoginButtonElement=driver.findElement(By.id("login-button"));
    return LoginButtonElement;

}

}
