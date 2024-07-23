package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import driverutils.WebElementAction;

public class WebLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElementAction webElementAction;

    @FindBy (xpath = "//input[@id='SchoolIDTextBox']")
    WebElement textboxSchoolId;

    @FindBy (xpath = "//input[@id='UsernameTextBox']")
    WebElement textboxUsername;

    @FindBy (xpath = "//input[@id='PasswordTextBox']")
    WebElement textboxPassword;

    @FindBy (xpath = "//button[@id='LoginButton']")
    WebElement btnLogin;

    public WebLoginPage(WebDriver driver) {

        this.driver = driver;
        this.webElementAction = new WebElementAction();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 120);

    }

    public void enterCredentials() throws InterruptedException {

        webElementAction.sendKeysToWebElement(driver, textboxSchoolId,"711124");
        webElementAction.sendKeysToWebElement(driver, textboxUsername,"brcm");
        webElementAction.sendKeysToWebElement(driver, textboxPassword,"Br0mc0m_1234");
        Thread.sleep(2000);
        webElementAction.clickWebElement(driver, btnLogin);
    }
}
