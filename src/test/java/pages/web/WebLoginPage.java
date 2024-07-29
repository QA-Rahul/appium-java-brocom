package pages.web;

import actions.WaitElementAction;
import actions.WebElementAction;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


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
        PageFactory.initElements(driver, this);
        webElementAction = new WebElementAction(driver);
    }

    public void enterCredentials() throws InterruptedException, FileNotFoundException {

        File loginCredFile = new File("data/web/LoginCredentials.json");
        FileReader reader = new FileReader(loginCredFile);
        JSONTokener tokener = new JSONTokener(reader);
        JSONObject jsonObject = new JSONObject(tokener);

        String schoolId = jsonObject.getString("school_id");
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        webElementAction.sendKeysToWebElement(textboxSchoolId,schoolId);
        webElementAction.sendKeysToWebElement(textboxUsername,username);
        webElementAction.sendKeysToWebElement(textboxPassword,password);
        WaitElementAction.sleep(2000);
        webElementAction.clickWebElement(btnLogin);
    }
}
