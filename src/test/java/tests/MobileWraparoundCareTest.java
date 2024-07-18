package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MobileLandingPage;
import pages.MobileLoginPage;
import utils.AppiumUtils;

import java.net.MalformedURLException;

public class MobileWraparoundCareTest {

    public AppiumDriver<MobileElement> driver;
    public MobileLoginPage mobileLoginPage;
    public MobileLandingPage mobileLandingPage;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {

        driver = AppiumUtils.getAndroidDriver();
        mobileLoginPage = new MobileLoginPage(driver);
        mobileLandingPage = new MobileLandingPage(driver);

    }
    @Test
    public void LandingOnWraparound() throws InterruptedException {

        mobileLoginPage.login();
        mobileLoginPage.enterPin();
        mobileLandingPage.WraparoundCare();


    }
    @AfterTest
    public void afterClass (){
        driver.quit();
    }
}
