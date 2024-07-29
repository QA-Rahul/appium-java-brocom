package actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitElementAction {

    public static WebDriver driver;
    public WebDriverWait wait;
    //    public JavascriptExecutor jsExecutor;
    //    JavascriptExecutor js = (JavascriptExecutor) driver;
    private static WaitElementAction instance;

    public WaitElementAction(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 120L);
    }

    public static synchronized WaitElementAction getWaits(WebDriver driver) {
        if (instance == null) {
            try {
                instance = new WaitElementAction(driver);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public boolean waitUntilWebElementIsClickable(WebElement element) {
        try {
            new WebDriverWait(driver, 15L) // 15 seconds wait time
                    .until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("WebElement is clickable using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element to be clickable: " + "<" + element.toString() + ">");
            return false;
        }
    }

    public boolean waitUntilWebElementIsVisible(WebElement element) {
        try {
            new WebDriverWait(driver, 15L) // 15 seconds wait time
                    .until(ExpectedConditions.visibilityOf(element));
            System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element to be visible: " + "<" + element.toString() + ">");
            return false;
        }
    }

    public boolean waitUntilListWebElementIsVisible(List<WebElement> elements) {
        try {
            new WebDriverWait(driver, 15L) // 15 seconds wait time
                    .until(ExpectedConditions.visibilityOfAllElements(elements));
            System.out.println("List of WebElements is visible using locator: " + "<" + elements.toString() + ">");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for list of elements to be visible: " + "<" + elements.toString() + ">");
            return false;
        }
    }

    // Mobile Wait

    public static synchronized WaitElementAction getWaitsAppium(AppiumDriver<MobileElement> driver) {
        if (instance == null) {
            try {
                instance = new WaitElementAction(driver);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public boolean waitUntilMobileElementIsClickable(MobileElement element) {
        try {
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("MobileElement is clickable using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element to be clickable: " + element.toString() + " " + e.getMessage());
            return false;
        }
    }

    public boolean waitUntilMobileElementIsVisible(MobileElement element) {
        try {
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.visibilityOf(element));
            System.out.println("MobileElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element to be visible: " + element.toString() + " " + e.getMessage());
            return false;
        }
    }

    public boolean waitUntilListMobileElementIsVisible(List<AndroidElement> elements) {
        try {
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.visibilityOfAllElements((MobileElement)elements));
            System.out.println("MobileElements are visible using locator: " + "<" + elements.toString() + ">");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for elements to be visible: " + elements.toString() + " " + e.getMessage());
            return false;
        }
    }

    public boolean waitUntilMobileElementIsInvisible(AndroidElement element) throws InterruptedException {

        try {
            new WebDriverWait(driver, 15L)
                    .until(ExpectedConditions.invisibilityOf(element));
            System.out.println("Loader disappeared successfully using locator: " + "<" + element.toString() + ">");

        } catch (TimeoutException e) {

            System.out.println("Timeout waiting for loader to disappear. " + e.getMessage());
        }
        return true;
    }

    // Thread sleep method

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Webdriver Implicit wait

    public static void setImplicitWait() {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

}


