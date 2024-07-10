package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class LoginPage {

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

    public WebDriverWait wait;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 40);

    }
    public void login() throws InterruptedException {

        loadingWait(loader);

        try {
            if (emailTextBox.isDisplayed()) {
                emailTextBox.sendKeys("E733467583@bromcomcloud.com");
                wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
                passwordTextBox.sendKeys("Br0mc0m_1234");
                wait.until(ExpectedConditions.elementToBeClickable(signIn));
                signIn.click();
                System.out.println("Login Successful");
            }
        }catch (Exception e) {
            System.out.println("User Already Logged In");
        }
    }
    public void getStudentName() throws InterruptedException {
        Thread.sleep(3000);
        String expectedText = "Maya ABIY";

        WebElement myChildText = driver.findElementByXPath("//android.widget.TextView[@text=\"Maya ABIY\"]");
        String actualText = myChildText.getText();
        System.out.println("Verified Text is : " + actualText);

        Assert.assertEquals(actualText, expectedText, "Text validation failed!");
    }
    public void enterPin() throws InterruptedException {

        Thread.sleep(3000);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.bromcom.mcas:id/navigationlayout_content\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")));
            if (chooseYourPin.stream().count() == 1) {

                Thread.sleep(2000);
                MobileElement viewGroup = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.bromcom.mcas:id/navigationlayout_content\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")));

                TouchAction touchAction = new TouchAction(driver);
                touchAction.tap(ElementOption.element(viewGroup)).perform();

                String pin = "12345";
                driver.getKeyboard().sendKeys(pin);

                String pin1 = "12345";
                driver.getKeyboard().sendKeys(pin1);

                wait.until(ExpectedConditions.elementToBeClickable(btnNo));
                btnNo.click();

                Thread.sleep(10000);
            }
            else {
                MobileElement viewGroup = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Please Enter your 5 digit PIN\"]")));

                TouchAction touchAction = new TouchAction(driver);
                touchAction.tap(ElementOption.element(viewGroup)).perform();

                String pin = "12345";
                driver.getKeyboard().sendKeys(pin);
            }
        }catch (Exception e){
            System.out.println("Enter Pin textboxs are not visible");
        }
    }
    public void loadingWait(AndroidElement element) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 15);

        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            System.out.println("Loader disappeared successfully.");

        } catch (TimeoutException e) {

            System.out.println("Timeout waiting for loader to disappear. " + e.getMessage());
        }
    }
}