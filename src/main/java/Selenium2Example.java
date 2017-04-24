import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Selenium2Example {
    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the ismplementation.

        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);

        // And now use this to visit Google
        driver.get("http://soft.it-hillel.com.ua:8080/browse/QAAUT-60");

        //login
        WebElement loginField = driver.findElement(By.xpath(".//*[@id='login-form-username']"));
        loginField.clear();
        loginField.sendKeys("oksana.gorbachenko.2009");

        WebElement passwordField =  driver.findElement(By.xpath(".//*[@id='login-form-password']"));
        passwordField.clear();
        passwordField.sendKeys("123456qwerty");

        WebElement loginButton =  driver.findElement(By.xpath(".//*[@id='login-form-submit']"));
        loginButton.click();

        //Creating sub-task
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement addSubButton =  driver.findElement(By.xpath(".//*[@id='stqc_show']"));
        addSubButton.click();

        WebElement summaryField =  driver.findElement(By.xpath(".//*[@id='summary']"));
        summaryField.clear();
        summaryField.sendKeys("Oksana`s Sub-Task");


        WebElement assignButton =  driver.findElement(By.xpath(" .//*[@id='assign-to-me-trigger']"));
        assignButton.click();
        WebElement submitButton =  driver.findElement(By.xpath(".//*[@id='subtask-create-details-submit']"));
        submitButton.click();

        //Close the browser

        driver.quit();
    }
}