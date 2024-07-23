package tests;

import driverutils.WebUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.WebClubPage;
import pages.WebLoginPage;

public class WebClubTest {

    private WebDriver driver;
    private WebLoginPage webLoginPage;
    private WebClubPage webClubPage;

    @BeforeTest
    public void setUp() {
        driver = WebUtils.getWebDriver();
        webLoginPage = new WebLoginPage(driver);
        webClubPage = new WebClubPage(driver);
    }

    @Test
    public void createGroup() throws InterruptedException {

        webLoginPage.enterCredentials();
        webClubPage.goToGroup();
        webClubPage.createGroup();

    }
    @AfterTest
    public void quit(){
        driver.quit();
    }

}
