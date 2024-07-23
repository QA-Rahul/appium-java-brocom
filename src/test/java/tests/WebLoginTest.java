package tests;

import driverutils.WebUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.WebLandingPage;
import pages.WebLoginPage;

public class WebLoginTest {

    private WebDriver driver;
    private WebLoginPage webLoginPage;
    private WebLandingPage webLandingPage;

    @BeforeTest
    public void setUp() {
        driver = WebUtils.getWebDriver();
        webLoginPage = new WebLoginPage(driver);
        webLandingPage = new WebLandingPage(driver);
    }

    @Test
    public void webLogin() throws InterruptedException {

        webLoginPage.enterCredentials();

    }

    // Please Delete this Page
}
