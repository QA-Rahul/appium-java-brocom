package tests.mobile;

import driverutils.AppiumUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.mobile.MobileLandingPage;
import pages.mobile.MobileLoginPage;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class MobileWraparoundCareTest {

    public AppiumDriver<MobileElement> driver;
    public MobileLoginPage mobileLoginPage;
    public MobileLandingPage mobileLandingPage;

    @BeforeTest
    public void beforeTest() throws MalformedURLException, FileNotFoundException {

        driver = AppiumUtils.getAndroidDriver();
        mobileLoginPage = new MobileLoginPage(driver);
        mobileLandingPage = new MobileLandingPage(driver);

    }
    @Test
    public void landingOnWraparound() throws InterruptedException {

        mobileLoginPage.login();
        mobileLoginPage.enterPin();
//        mobileLandingPage.wraparoundCare();
//        mobileLandingPage.clickOnMenu("");
//        mobileLandingPage.clickOnMenu("Bhaviour");


    }
    @AfterTest
    public void quit(){
        AppiumUtils.quitAppiumDriver();
    }
}
