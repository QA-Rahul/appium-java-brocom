package pages.web;

import actions.WebElementAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.util.List;

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

    @FindBy (xpath = "//div[@class='k-calendar-view']//tbody//td")
    List<WebElement> dateCells;

//    Check box Options
//    @FindBy (xpath = "//div[@class='popover-content']//div[@class='checkbox']");
//    List<WebElement> filterOptions;

    public WebClubPage(WebDriver driver) {
        this.driver = driver;
        webElementAction = new WebElementAction(driver);
        PageFactory.initElements(driver, this);
        webLandingPage = new WebLandingPage(driver);
    }
    public void goToGroup(){

        webLandingPage.webLandingGroups();
    }
    public void createGroup() throws InterruptedException, FileNotFoundException {
        webElementAction.selectDropdownByVisibleText(driver,groupType,"Clubs & Trips");
        webElementAction.clickWebElement(btn_New);
        webElementAction.setTextAndTodayDate(driver,groupName);
        webElementAction.setTextAndTodayDate(driver,textarea_description);
        webElementAction.calendarDateSelection(driver,iconCalendar,startDate,endDateIcon,dateCells);
        webElementAction.clickWebElement(btnSave);
    }

}
