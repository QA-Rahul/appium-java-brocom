package tests.web;

import driverutils.WebUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.web.WebClubPage;
import pages.web.WebLoginPage;

import java.io.FileNotFoundException;

public class WebClubTest {

    private WebDriver driver;
    private WebLoginPage webLoginPage;
    private WebClubPage webClubPage;

    @BeforeTest
    public void setUp() throws FileNotFoundException {
        driver = WebUtils.getWebDriver();
        webLoginPage = new WebLoginPage(driver);
        webClubPage = new WebClubPage(driver);
    }

    @Test
    public void createGroup() throws InterruptedException, FileNotFoundException {

        webLoginPage.enterCredentials();
        webClubPage.goToGroup();
        webClubPage.createGroup();

    }
    @AfterTest
    public void quit(){
        WebUtils.quitWebDriver();
    }

}
