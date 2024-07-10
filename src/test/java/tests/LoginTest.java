package tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import pages.LoginPage;
import utils.AppiumUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


public class LoginTest {

    private AppiumDriver<MobileElement> driver;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {

        driver = AppiumUtils.getAndroidDriver();
        loginPage = new LoginPage(driver);

    }

    @Test (priority = 1)
    public void testLogin() throws InterruptedException {

        loginPage.login();
    }
    @Test (priority = 2)
    public void enterPIN() throws InterruptedException {
        loginPage.enterPin();
        Thread.sleep(5000);
        loginPage.getStudentName();
    }
    @AfterTest
    public void afterClass (){
        driver.quit();
    }
}