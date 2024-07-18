package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebElementAction;


public class WebLandingPage {

    WebElementAction webElementAction;
    WebDriver driver;

    @FindBy (xpath = "//span[text()='Home']")
    WebElement Home;

    @FindBy (xpath = "//span[text()='Favourites']")
    WebElement Favourites;

    @FindBy (xpath = "//span[text()='Modules']")
    WebElement Modules;

    @FindBy (xpath = "//span[text()='Students']")
    WebElement Students;

    @FindBy (xpath = "//span[text()='Staff']")
    WebElement Staff;

    @FindBy (xpath = "//span[text()='Groups']")
    WebElement Groups;

    @FindBy (xpath = "//span[text()='Others']")
    WebElement Others;

    @FindBy (xpath = "//span[text()='Config']")
    WebElement Config;

    public WebDriverWait wait;

    public WebLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 120);
        this.webElementAction = new WebElementAction();
    }
    public void WebLandingHome(){

        wait.until(ExpectedConditions.elementToBeClickable(Home));
        webElementAction.clickWebElement(driver,Home);
    }
    public void WebLandingFavourites(){

        wait.until(ExpectedConditions.elementToBeClickable(Favourites));
        webElementAction.clickWebElement(driver,Favourites);
    }
    public void WebLandingModules(){

        wait.until(ExpectedConditions.elementToBeClickable(Modules));
        webElementAction.clickWebElement(driver,Modules);
    }
    public void WebLandingStudents(){

        wait.until(ExpectedConditions.elementToBeClickable(Students));
        webElementAction.clickWebElement(driver,Students);
    }
    public void WebLandingStaff(){

        wait.until(ExpectedConditions.elementToBeClickable(Staff));
        webElementAction.clickWebElement(driver,Staff);
    }
    public void WebLandingGroups(){

        wait.until(ExpectedConditions.elementToBeClickable(Groups));
        webElementAction.clickWebElement(driver,Groups);
    }
    public void WebLandingOthers(){

        wait.until(ExpectedConditions.elementToBeClickable(Others));
        webElementAction.clickWebElement(driver,Others);
    }
    public void WebLandingConfig(){

        wait.until(ExpectedConditions.elementToBeClickable(Config));
        webElementAction.clickWebElement(driver,Config);
    }

}
