package tests;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import pages.MobileLoginPage;
import utils.AppiumUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


public class MobileLoginTest {

    private AppiumDriver<MobileElement> driver;
    private MobileLoginPage mobileLoginPage;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {

        driver = AppiumUtils.getAndroidDriver();
        mobileLoginPage = new MobileLoginPage(driver);

    }

    @Test (priority = 1)
    public void testLogin() throws InterruptedException {

        mobileLoginPage.login();
    }
    @Test (priority = 2)
    public void enterPIN() throws InterruptedException {
        mobileLoginPage.enterPin();
        Thread.sleep(5000);
        mobileLoginPage.getStudentName();
    }
    @AfterTest
    public void afterClass (){
        driver.quit();
    }
}