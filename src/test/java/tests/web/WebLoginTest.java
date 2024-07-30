package tests.web;

import driverutils.WebUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.web.WebLandingPage;
import pages.web.WebLoginPage;

import java.io.FileNotFoundException;

public class WebLoginTest {

    private WebDriver driver;
    private WebLoginPage webLoginPage;
    private WebLandingPage webLandingPage;

    @BeforeTest
    public void setUp() throws FileNotFoundException {
        driver = WebUtils.getWebDriver();
        webLoginPage = new WebLoginPage(driver);
        webLandingPage = new WebLandingPage(driver);
    }

    @Test
    public void webLogin() throws InterruptedException, FileNotFoundException {

        webLoginPage.enterCredentials();

    }
    @AfterTest
    public void quit(){
        WebUtils.quitWebDriver();
    }
}
