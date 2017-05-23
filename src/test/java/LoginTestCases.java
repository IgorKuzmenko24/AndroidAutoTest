import org.testng.annotations.Test;

public class LoginTestCases extends  Config {

    @Test
    protected void succesLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLoginToBox();
    }

    @Test
    protected void failureLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.failureLoginToBox();
    }


}
