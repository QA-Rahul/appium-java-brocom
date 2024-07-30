package pages.web;

import actions.WebElementAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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


    public WebLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.webElementAction = new WebElementAction(driver);
    }
    public void clickOnWebMenu(WebDriver driver,WebElement element) {

        webElementAction.clickWebElement(element);
    }

    /* public void webLandingHome(){

        wait.until(ExpectedConditions.elementToBeClickable(Home));
        webElementAction.clickWebElement(driver,Home);
    } */

    public void webLandingHome(){
        clickOnWebMenu(driver,Home);
    }
    public void webLandingFavourites(){
        clickOnWebMenu(driver,Favourites);
    }
    public void webLandingModules(){
        clickOnWebMenu(driver,Modules);
    }
    public void webLandingStudents(){
        clickOnWebMenu(driver,Students);
    }
    public void webLandingStaff(){
        clickOnWebMenu(driver,Staff);
    }
    public void webLandingGroups(){
        clickOnWebMenu(driver,Groups);
    }
    public void webLandingOthers(){
        clickOnWebMenu(driver,Others);
    }
    public void webLandingConfig(){
        clickOnWebMenu(driver,Config);
    }

}
