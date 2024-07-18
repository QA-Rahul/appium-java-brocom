package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.WebClubPage;
import pages.WebLoginPage;
import utils.WebUtils;

public class WebClubTest {

    private WebDriver driver;
    private WebLoginPage webLoginPage;
    private WebClubPage webClubPage;

    @BeforeTest
    public void SetUp() {
        driver = WebUtils.getWebDriver();
        webLoginPage = new WebLoginPage(driver);
        webClubPage = new WebClubPage(driver);
    }

    @Test
    public void CreateGroup() throws InterruptedException {

        webLoginPage.enterCredentials();
        webClubPage.goToGroup();
        webClubPage.createGroup();

    }
    @AfterTest
    public void Quit(){
        driver.quit();
    }

}
