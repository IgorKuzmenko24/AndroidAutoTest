import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.openqa.selenium.By.xpath;

public class LoginPage {

    protected AppiumDriver driver;

    public LoginPage (AppiumDriver driver) {
        this.driver = driver;
    }

    private String USERNAME = "testusermail2017@gmail.com";
    private String PASSWORD = "Password11";
    private String WRONG_PASSWORD = "Password11as";
    private By emailField = xpath("//android.widget.EditText[@text='Username/Email Address']");
    private By passField = xpath("//android.widget.EditText[@password='true']");
    private By finalSignin = xpath("//android.widget.Button[@text='Log In']");
    private By filesLabel = xpath("//android.widget.TextView[@text='Files']");
    private By unableLoginAlert = xpath("//android.widget.TextView[contains(@text,'Unable to log in')]");


    private void loginToBox(String password){
        Assert.assertFalse(driver.findElements(emailField).isEmpty(),"The App is not opened");
        driver.findElement(emailField).sendKeys(USERNAME);
        driver.findElement(passField).sendKeys(PASSWORD);
        driver.findElement(finalSignin).click();

    }

    protected void successLoginToBox(){
        loginToBox(PASSWORD);
        Assert.assertFalse(driver.findElements(filesLabel).isEmpty(),"login failed");
    }

    protected void failureLoginToBox(){
        loginToBox(WRONG_PASSWORD);
        Assert.assertTrue(driver.findElements(unableLoginAlert).isEmpty(),"No Alert! ");
    }
}
