import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

public class Selenium2Example {
        LoginPage loginPage;
        WebDriver driver;
        Header header;
        @BeforeTest
                public void before() {
            System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);

            driver = new FirefoxDriver(capabilities);
            loginPage = new LoginPage(driver);
            header = new Header(driver);
        }

        @Test(groups = {"functest", "login"})
        public void login(){
            loginPage.open();
            loginPage.typeUsername("oksana.gorbachenko.2009");
            loginPage.typePassword("123456qwerty");
            loginPage.clickOnLogin();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            header.clickCreate();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
     // @AfterTest
            //  public void after(){ driver.quit();}
}