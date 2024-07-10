package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumUtils;


public class LandingPage {

    public AppiumDriver<MobileElement> driver;

    public WebDriverWait wait;

    public LandingPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 40);

    }

    public void WraparoundCare() {
        MobileElement LandingWraparoundCare = AppiumUtils.scrollToElementByText(driver, "Wraparound Care");
        LandingWraparoundCare.click();
    }

    public void Behaviour() {
        MobileElement LandingBehaviour = AppiumUtils.scrollToElementByText(driver, "Behaviour");
        LandingBehaviour.click();
    }

    public void OutstandingPayments(){
        MobileElement LandingOutstandingPayments = AppiumUtils.scrollToElementByText(driver, "Outstanding Payments");
        LandingOutstandingPayments.click();
    }

    public void Homework(){
        MobileElement LandingHomework = AppiumUtils.scrollToElementByText(driver, "Homework");
        LandingHomework.click();
    }

    public void Trips(){
        MobileElement LandingTrips = AppiumUtils.scrollToElementByText(driver, "Trips");
        LandingTrips.click();
    }

    public void Clubs() {
        MobileElement LandingClubs = AppiumUtils.scrollToElementByText(driver, "Clubs");
        LandingClubs.click();
    }

    public void TermDates(){
        MobileElement LandingTermDates = AppiumUtils.scrollToElementByText(driver, "TermDates");
        LandingTermDates.click();
    }

    public void Dinner(){
        MobileElement LandingDinner = AppiumUtils.scrollToElementByText(driver, "Dinner");
        LandingDinner.click();
    }

    public void Attendance(){
        MobileElement LandingAttendance = AppiumUtils.scrollToElementByText(driver, "Attendance");
        LandingAttendance.click();
    }

    public void ImportantDocuments(){
        MobileElement LandingImportantDocuments = AppiumUtils.scrollToElementByText(driver, "Important Documents");
        LandingImportantDocuments.click();
    }

    public void Teachers(){
        MobileElement LandingTeachers = AppiumUtils.scrollToElementByText(driver, "Teachers");
        LandingTeachers.click();
    }

    public void Reports(){
        MobileElement LandingReports = AppiumUtils.scrollToElementByText(driver, "Reports");
        LandingReports.click();
    }

    public void ParentsEvening(){
        MobileElement LandingParentsEvening = AppiumUtils.scrollToElementByText(driver, "Parents Evening");
        LandingParentsEvening.click();
    }

    public void OnReport(){
        MobileElement LandingOnReport = AppiumUtils.scrollToElementByText(driver, "On Report");
        LandingOnReport.click();
    }

    public void AdmissionForm() {
        MobileElement LandingAdmissionForm = AppiumUtils.scrollToElementByText(driver, "Admission Form");
        LandingAdmissionForm.click();
    }

    public void ParentalConsent(){
        MobileElement LandingParentalConsent = AppiumUtils.scrollToElementByText(driver, "Parental Consent");
        LandingParentalConsent.click();
    }
}
