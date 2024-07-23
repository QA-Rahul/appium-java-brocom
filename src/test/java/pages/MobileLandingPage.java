package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import driverutils.MobileElementAction;


public class MobileLandingPage {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    public MobileLandingPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 40);

    }
    MobileElement menuItem;
    public void clickOnMenu(String menuName){
         menuItem = MobileElementAction.scrollToElementByText(driver, menuName);
         menuItem.click();
    }

    /* Scrolling on element using Text */

    public void wraparoundCare() {
        clickOnMenu("Wraparound Care");
    }

    public void behaviour() {
        clickOnMenu("Behaviour");
    }

    public void outstandingPayments(){
        clickOnMenu("Outstanding Payments");
    }

    public void homework(){
        clickOnMenu("Homework");
    }

    public void trips(){
      clickOnMenu("Trips");
    }

    public void clubs() {
        clickOnMenu("Clubs");
    }

    public void termDates(){
        clickOnMenu("TermDates");
    }

    public void dinner(){
        clickOnMenu("Dinner");
    }

    public void attendance(){
        clickOnMenu("Attendance");
    }

    public void importantDocuments(){
        clickOnMenu("Important Documents");
    }

    public void teachers(){

        clickOnMenu("Teachers");
    }

    public void reports(){

        clickOnMenu("Reports");
    }

    public void parentsEvening(){

        clickOnMenu("Parents Evening");
    }

    public void onReport(){
        clickOnMenu("On Report");
    }

    public void admissionForm() {
        clickOnMenu("Admission Form");
    }

    public void parentalConsent(){
        clickOnMenu("Parental Consent");
    }

    public void store() {
        clickOnMenu("Store");
        //android.widget.FrameLayout[@content-desc="Store"]
    }
    public void announcements() {
        clickOnMenu("Announcements");
        //android.widget.FrameLayout[@content-desc="Announcements"]
    }
    public void messages() {
        clickOnMenu("Messages");
        //android.widget.FrameLayout[@content-desc="Messages"]
    }

    /* Clicking on element Using Text */
    public void changeProfile(){
        MobileElementAction.clickElementByLocators(driver,"text","Maya ABIY");
    }
    
}
