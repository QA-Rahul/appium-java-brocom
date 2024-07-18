package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileElementAction {

    // Scrolls the application view to find an element with the specified text.
    public static MobileElement scrollToElementByText(AppiumDriver<MobileElement> driver, String elementText) {
        return driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                        + ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))"));
    }

    // Method to click on an element by different locator types
    public static void clickElementByLocators(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {
        MobileElement element;
        switch (locatorType.toLowerCase()) {
            case "text":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().text(\"" + locatorValue + "\")"));
                break;
            case "resourceid":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().resourceId(\"" + locatorValue + "\")"));
                break;
            case "classname":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().className(\"" + locatorValue + "\")"));
                break;
            case "xpath":
                element = driver.findElement(MobileBy.xpath(locatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // Method to double-click on an element by different locator types
    public static void doubleClickElementByLocator(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {
        MobileElement element;
        switch (locatorType.toLowerCase()) {
            case "text":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().text(\"" + locatorValue + "\")"));
                break;
            case "resourceid":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().resourceId(\"" + locatorValue + "\")"));
                break;
            case "classname":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().className(\"" + locatorValue + "\")"));
                break;
            case "xpath":
                element = driver.findElement(MobileBy.xpath(locatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    // Method to send key on an element by different locator types
    public static void sendKeysToMobileByLocator(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue, String text) {
        MobileElement element;
        switch (locatorType.toLowerCase()) {
            case "text":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().text(\"" + locatorValue + "\")"));
                break;
            case "resourceid":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().resourceId(\"" + locatorValue + "\")"));
                break;
            case "classname":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().className(\"" + locatorValue + "\")"));
                break;
            case "xpath":
                element = driver.findElement(MobileBy.xpath(locatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }

    // Method to Select Dropdown
    public static void selectMobileDropdownByVisibleText(AppiumDriver<MobileElement> driver, MobileElement dropdownElement, String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(dropdownElement));

        dropdownElement.click();

        MobileElement option = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + visibleText + "']"));
        option.click();
    }

    // Method to Check Checkbox by different locator types
    public static void mobileCheckCheckbox(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {
        MobileElement element;
        switch (locatorType.toLowerCase()) {
            case "text":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().text(\"" + locatorValue + "\")"));
                break;
            case "resourceid":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().resourceId(\"" + locatorValue + "\")"));
                break;
            case "classname":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().className(\"" + locatorValue + "\")"));
                break;
            case "xpath":
                element = driver.findElement(MobileBy.xpath(locatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        if (!element.isSelected()) {
            element.click();
        }
    }

    // Method to Uncheck Checkbox by different locator types
    public static void mobileUncheckCheckbox(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {
        MobileElement element;
        switch (locatorType.toLowerCase()) {
            case "text":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().text(\"" + locatorValue + "\")"));
                break;
            case "resourceid":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().resourceId(\"" + locatorValue + "\")"));
                break;
            case "classname":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().className(\"" + locatorValue + "\")"));
                break;
            case "xpath":
                element = driver.findElement(MobileBy.xpath(locatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        if (element.isSelected()) {
            element.click();
        }
    }

    // Method to click on an RadioButton by different locator types
    public static void mobileCheckRadioButton(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {
        MobileElement element;
        switch (locatorType.toLowerCase()) {
            case "text":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().text(\"" + locatorValue + "\")"));
                break;
            case "resourceid":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().resourceId(\"" + locatorValue + "\")"));
                break;
            case "classname":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().className(\"" + locatorValue + "\")"));
                break;
            case "xpath":
                element = driver.findElement(MobileBy.xpath(locatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        if (!element.isSelected()) {
            element.click();
        }
    }

    // Method to click on an RadioButton by different locator types
    public static void mobileUncheckRadioButton(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {
        MobileElement element;
        switch (locatorType.toLowerCase()) {
            case "text":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().text(\"" + locatorValue + "\")"));
                break;
            case "resourceid":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().resourceId(\"" + locatorValue + "\")"));
                break;
            case "classname":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().className(\"" + locatorValue + "\")"));
                break;
            case "xpath":
                element = driver.findElement(MobileBy.xpath(locatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        if (element.isSelected()) {
            element.click();
        }
    }

    // Method to Click on ToggleButton on an element by different locator types
    public static void mobileToggleButton(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue, boolean turnOn) {
        MobileElement element;
        switch (locatorType.toLowerCase()) {
            case "text":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().text(\"" + locatorValue + "\")"));
                break;
            case "resourceid":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().resourceId(\"" + locatorValue + "\")"));
                break;
            case "classname":
                element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiSelector().className(\"" + locatorValue + "\")"));
                break;
            case "xpath":
                element = driver.findElement(MobileBy.xpath(locatorValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        String isChecked = element.getAttribute("checked");
        boolean isCurrentlyChecked = isChecked != null && isChecked.equalsIgnoreCase("true");
        if (turnOn && !isCurrentlyChecked) {
            element.click();
        } else if (!turnOn && isCurrentlyChecked) {
            element.click();
        }
    }

    // Method to hide keyboard on screen
    public static void closeKeyboard (AppiumDriver<MobileElement> driver, MobileElement textField) {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(textField)).click();

        driver.hideKeyboard();
    }
}
