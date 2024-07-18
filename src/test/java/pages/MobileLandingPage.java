package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MobileElementAction;


public class MobileLandingPage {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    public MobileLandingPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 40);

    }

    /* Scrolling on element using Text */

    public void WraparoundCare() {
        MobileElement LandingWraparoundCare = MobileElementAction.scrollToElementByText(driver, "Wraparound Care");
        LandingWraparoundCare.click();
    }

    public void Behaviour() {
        MobileElement LandingBehaviour = MobileElementAction.scrollToElementByText(driver, "Behaviour");
        LandingBehaviour.click();
    }

    public void OutstandingPayments(){
        MobileElement LandingOutstandingPayments = MobileElementAction.scrollToElementByText(driver, "Outstanding Payments");
        LandingOutstandingPayments.click();
    }

    public void Homework(){
        MobileElement LandingHomework = MobileElementAction.scrollToElementByText(driver, "Homework");
        LandingHomework.click();
    }

    public void Trips(){
        MobileElement LandingTrips = MobileElementAction.scrollToElementByText(driver, "Trips");
        LandingTrips.click();
    }

    public void Clubs() {
        MobileElement LandingClubs = MobileElementAction.scrollToElementByText(driver, "Clubs");
        LandingClubs.click();
    }

    public void TermDates(){
        MobileElement LandingTermDates = MobileElementAction.scrollToElementByText(driver, "TermDates");
        LandingTermDates.click();
    }

    public void Dinner(){
        MobileElement LandingDinner = MobileElementAction.scrollToElementByText(driver, "Dinner");
        LandingDinner.click();
    }

    public void Attendance(){
        MobileElement LandingAttendance = MobileElementAction.scrollToElementByText(driver, "Attendance");
        LandingAttendance.click();
    }

    public void ImportantDocuments(){
        MobileElement LandingImportantDocuments = MobileElementAction.scrollToElementByText(driver, "Important Documents");
        LandingImportantDocuments.click();
    }

    public void Teachers(){
        MobileElement LandingTeachers = MobileElementAction.scrollToElementByText(driver, "Teachers");
        LandingTeachers.click();
    }

    public void Reports(){
        MobileElement LandingReports = MobileElementAction.scrollToElementByText(driver, "Reports");
        LandingReports.click();
    }

    public void ParentsEvening(){
        MobileElement LandingParentsEvening = MobileElementAction.scrollToElementByText(driver, "Parents Evening");
        LandingParentsEvening.click();
    }

    public void OnReport(){
        MobileElement LandingOnReport = MobileElementAction.scrollToElementByText(driver, "On Report");
        LandingOnReport.click();
    }

    public void AdmissionForm() {
        MobileElement LandingAdmissionForm = MobileElementAction.scrollToElementByText(driver, "Admission Form");
        LandingAdmissionForm.click();
    }

    public void ParentalConsent(){
        MobileElement LandingParentalConsent = MobileElementAction.scrollToElementByText(driver, "Parental Consent");
        LandingParentalConsent.click();
    }

    public void Store() {
        MobileElement LandingStore = MobileElementAction.scrollToElementByText(driver, "Store");
        LandingStore.click();
        //android.widget.FrameLayout[@content-desc="Store"]
    }
    public void Announcements() {
        MobileElement LandingAnnouncements = MobileElementAction.scrollToElementByText(driver, "Announcements");
        LandingAnnouncements.click();
        //android.widget.FrameLayout[@content-desc="Announcements"]
    }
    public void Messages() {
        MobileElement LandingMessages = MobileElementAction.scrollToElementByText(driver, "Messages");
        LandingMessages.click();
        //android.widget.FrameLayout[@content-desc="Messages"]
    }

    /* Clicking on element Using Text */
    public void ChangeProfile(){
        MobileElementAction.clickElementByLocators(driver,"text","Maya ABIY");
    }
    
}
