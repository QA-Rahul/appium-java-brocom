package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.WebLandingPage;
import pages.WebLoginPage;
import utils.WebUtils;

public class WebLoginTest {

    private WebDriver driver;
    private WebLoginPage webLoginPage;
    private WebLandingPage webLandingPage;

    @BeforeTest
    public void SetUp() {
        driver = WebUtils.getWebDriver();
        webLoginPage = new WebLoginPage(driver);
        webLandingPage = new WebLandingPage(driver);
    }

    @Test
    public void WebLogin() throws InterruptedException {

        webLoginPage.enterCredentials();
//        webLandingPage.WebLandingGroups();

    }

    // Please Delete this Page
}
