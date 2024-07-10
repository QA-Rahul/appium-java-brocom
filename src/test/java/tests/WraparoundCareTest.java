package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import utils.AppiumUtils;

import java.net.MalformedURLException;

public class WraparoundCareTest {

    public AppiumDriver<MobileElement> driver;
    public LoginPage loginPage;
    public LandingPage landingPage;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {

        driver = AppiumUtils.getAndroidDriver();
        loginPage = new LoginPage(driver);
        landingPage = new LandingPage(driver);

    }
    @Test
    public void LandingOnWraparound() throws InterruptedException {

        loginPage.login();
        loginPage.enterPin();
        landingPage.WraparoundCare();


    }
//    @AfterTest
//    public void afterClass (){
//        driver.quit();
//    }
}
