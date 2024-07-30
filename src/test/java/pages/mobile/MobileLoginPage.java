package pages.mobile;

import actions.WaitElementAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.ElementOption;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class MobileLoginPage {

    public AppiumDriver<MobileElement> driver;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Your Email\"]")
    public AndroidElement emailTextBox;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Your Password\"]")
    public AndroidElement passwordTextBox;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Sign In\"]")
    public AndroidElement signIn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Please Enter your 5 digit PIN\"]")
    public List <AndroidElement> enterPin;

    @FindBy(id = "com.bromcom.mcas:id/loadingProgressBar")
    public AndroidElement loader;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Please choose your 5 digit PIN\"]")
    public List <AndroidElement> chooseYourPin;

    @FindBy(xpath = "//android.widget.TextView[@text=\"No\"]")
    public AndroidElement btnNo;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Maya ABIY\"]")
    public AndroidElement textStuProfile;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.bromcom.mcas:id/navigationlayout_content\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    public AndroidElement pinTextbox;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.bromcom.mcas:id/navigationlayout_content\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    public AndroidElement pinTextbox2;


    public MobileLoginPage(AppiumDriver<MobileElement> driver) throws FileNotFoundException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    File webLoginCredFile = new File("data/mobile/MobileLoginCredentials.json");
    FileReader reader = new FileReader(webLoginCredFile);
    JSONTokener tokener = new JSONTokener(reader);
    JSONObject jsonObject = new JSONObject(tokener);

    public void login() throws InterruptedException {

        WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsInvisible(loader);

        try {
            if (emailTextBox.isDisplayed()) {

                String emailID = jsonObject.getString("email_id");
                String pass = jsonObject.getString("password");

                emailTextBox.sendKeys(emailID);
                WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsVisible(passwordTextBox);

                passwordTextBox.sendKeys(pass);
                WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsClickable(signIn);
                signIn.click();

                WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsInvisible(loader);
                System.out.println("Login Successful");
            }
        }catch (Exception e) {
            System.out.println("User Already Logged In");
        }
    }
    public void getStudentName() throws InterruptedException {
        WaitElementAction.sleep(3000);

        WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsVisible(textStuProfile);
        String stu_name = jsonObject.getString("student_profile_name");

        String actualText = textStuProfile.getText();
        System.out.println("Verified Text is : " + actualText);

        Assert.assertEquals(actualText, stu_name, "Text validation failed!");

        Assert.assertEquals(actualText, stu_name, "Text validation failed!");
    }
    public void enterPin() throws InterruptedException {

        WaitElementAction.sleep(3000);
        try {
            WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsVisible(pinTextbox);

            if (chooseYourPin.stream().count() == 1) {

                WaitElementAction.sleep(2000);
                WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsVisible(pinTextbox2);

                TouchAction touchAction = new TouchAction(driver);
                touchAction.tap(ElementOption.element(pinTextbox2)).perform();

                String pin = jsonObject.getString("Pin");
                driver.getKeyboard().sendKeys(pin);

                String pin1 = jsonObject.getString("Pin");
                driver.getKeyboard().sendKeys(pin1);

                WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsClickable(btnNo);
                btnNo.click();

                WaitElementAction.sleep(10000);
            }
            else {
                WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsVisible(enterPin.get(0));

                TouchAction touchAction = new TouchAction(driver);
                touchAction.tap(ElementOption.element(enterPin.get(0))).perform();

                String pin = jsonObject.getString("Pin");
                driver.getKeyboard().sendKeys(pin);
            }
        }catch (Exception e){
            System.out.println("Enter Pin textboxs are not visible");
        }
    }
}
