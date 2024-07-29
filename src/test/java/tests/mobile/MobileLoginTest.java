package tests.mobile;


import actions.WaitElementAction;
import driverutils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mobile.MobileLoginPage;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;


public class MobileLoginTest {

    private AppiumDriver<MobileElement> driver;
    private MobileLoginPage mobileLoginPage;

    @BeforeClass
    public void beforeClass() throws MalformedURLException, FileNotFoundException {

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
//        WaitElementAction.sleep(5000);
        WaitElementAction.sleep(5000);
        mobileLoginPage.getStudentName();
    }
    @AfterTest
    public void quit(){
        AppiumUtils.quitAppiumDriver();
    }
}