package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import driverutils.WebElementAction;

public class WebClubPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public WebLandingPage webLandingPage;
    public WebElementAction webElementAction;

    @FindBy (xpath = "//select[@id='grouptypeDDL']")
    WebElement groupType;

    @FindBy (xpath = "//button[@id='ListPageNewButton']")
    WebElement btn_New;

    @FindBy (xpath = "//input[@id='newgroup_Name']")
    WebElement groupName;

    @FindBy (xpath = "//textarea[@id='newgroup_Description']")
    WebElement textarea_description;

    @FindBy (xpath = "//span[@aria-controls=\"newgroup_StartDate_dateview\"]")
    WebElement iconCalendar;

    @FindBy (xpath = "//div[@class='k-footer']//a")
    WebElement startDate;

    @FindBy (xpath = "//span[@aria-controls=\"newgroup_EndDate_dateview\"]")
    WebElement endDateIcon;

    @FindBy (id = "newgroup_CreateButton")
    WebElement btnSave;


    public WebClubPage(WebDriver driver) {
        this.driver = driver;
        this.webElementAction = new WebElementAction();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 120);
        this.webLandingPage = new WebLandingPage(driver);
    }
    public void goToGroup(){
        webLandingPage.webLandingGroups();
    }
    public void createGroup() throws InterruptedException {
        webElementAction.selectDropdownByVisibleText(driver,groupType,"Clubs & Trips");
        webElementAction.clickWebElement(driver,btn_New);
        webElementAction.setTextAndTodayDate(driver,groupName);
        webElementAction.setTextAndTodayDate(driver,textarea_description);
        webElementAction.calendarDateSelection(driver,iconCalendar,startDate,endDateIcon);
        webElementAction.clickWebElement(driver,btnSave);
    }

}
