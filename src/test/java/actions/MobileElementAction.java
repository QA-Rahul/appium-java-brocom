package actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class MobileElementAction {

    private AppiumDriver<MobileElement> driver;


    public MobileElementAction(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Scrolls the application view to find an element with the specified text.
    public static MobileElement scrollToElementByText(AppiumDriver<MobileElement> driver, String elementText) {
        try {
            return driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                            + ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))"));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element Not Found with text: " + elementText);
        }
    }

    // Method to click on an element by different locator types
    public static void clickElementByLocators(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {

        MobileElement element;
        try {
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
            WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsClickable(element);
            element.click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element Not Found with " + locatorType + ": " + locatorValue);
        }
    }

    // Method to double-click on an element by different locator types
    public static void doubleClickElementByLocator(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {
        MobileElement element;
        try {
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
            WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsClickable(element);
            Actions actions = new Actions(driver);
            actions.doubleClick(element).perform();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element Not Found with " + locatorType + ": " + locatorValue);
        }
    }

    // Method to send key on an element by different locator types
    public static void sendKeysToMobileByLocator(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue, String text) {
        MobileElement element;
        try {
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
            WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsVisible(element);
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element Not Found with " + locatorType + ": " + locatorValue);
        }
    }

    // Method to Select Dropdown
    public static void selectMobileDropdownByVisibleText(AppiumDriver<MobileElement> driver, MobileElement dropdownElement, String visibleText) {
        try {
            WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsClickable(dropdownElement);
            dropdownElement.click();
            MobileElement option = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + visibleText + "']"));
            option.click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Dropdown or option Not Found with text: " + visibleText);
        }
    }

    // Method to Check Checkbox by different locator types
    public static void mobileCheckCheckbox(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {
        MobileElement element;
        try {
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
            WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsVisible(element);
            if (!element.isSelected()) {
                element.click();
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Checkbox Not Found with " + locatorType + ": " + locatorValue);
        }
    }

    // Method to Uncheck Checkbox by different locator types
    public static void mobileUncheckCheckbox(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {
        MobileElement element;
        try {
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
            WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsClickable(element);
            if (element.isSelected()) {
                element.click();
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Checkbox Not Found with " + locatorType + ": " + locatorValue);
        }
    }

    // Method to click on an RadioButton by different locator types
    public static void mobileCheckRadioButton(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {
        MobileElement element;
        try {
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
            WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsClickable(element);
            if (!element.isSelected()) {
                element.click();
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Radio Button Not Found with " + locatorType + ": " + locatorValue);
        }
    }

    // Method to click on an RadioButton by different locator types
    public static void mobileUncheckRadioButton(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue) {
        MobileElement element;
        try {
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
            WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsClickable(element);
            if (element.isSelected()) {
                element.click();
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Radio Button Not Found with " + locatorType + ": " + locatorValue);
        }
    }

    // Method to Click on ToggleButton on an element by different locator types
    public static void mobileToggleButton(AppiumDriver<MobileElement> driver, String locatorType, String locatorValue, boolean turnOn) {
        MobileElement element;
        try {
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
            WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsClickable(element);
            String isChecked = element.getAttribute("checked");
            boolean isCurrentlyChecked = isChecked != null && isChecked.equalsIgnoreCase("true");
            if (turnOn && !isCurrentlyChecked) {
                element.click();
            } else if (!turnOn && isCurrentlyChecked) {
                element.click();
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Toggle Button Not Found with " + locatorType + ": " + locatorValue);
        }
    }

    // Method to hide keyboard on screen
    public static void closeKeyboard (AppiumDriver<MobileElement> driver, MobileElement textField) {
        try {
            WaitElementAction.getWaitsAppium(driver).waitUntilMobileElementIsVisible(textField);
            textField.click();
            driver.hideKeyboard();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("TextField Not Found for closing keyboard");
        }
    }
}
