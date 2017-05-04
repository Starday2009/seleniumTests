import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    By loginField = By.xpath(".//*[@id='login-form-username']");
    By passwordField = By.xpath(".//*[@id='login-form-password']");
    By loginButton = By.xpath(".//*[@id='login-form-submit']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage typeUsername(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickOnLogin(){
        driver.findElement(loginButton).click();
        return this;
    }
    public LoginPage open(){
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        return this;
    }


}
