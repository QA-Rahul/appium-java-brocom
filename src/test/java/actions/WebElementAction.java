package actions;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class WebElementAction {

    private WebDriver driver;

    public WebElementAction(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWebElement(WebElement locator) {

        try {
            WaitElementAction.getWaits(driver).waitUntilWebElementIsClickable(locator);
            locator.click();
        } catch (Exception e) {
            System.out.println("Element Not Found: " + locator);
            e.printStackTrace();
        }
    }

    public void sendKeysToWebElement(WebElement element, String text) {

        try {
            WaitElementAction.getWaits(driver).waitUntilWebElementIsVisible(element);
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("Element Not Found: " + element);
            e.printStackTrace();
        }
    }

    public void selectDropdownByVisibleText(WebDriver driver, WebElement dropdownElement, String visibleText) {

        try {
            WaitElementAction.getWaits(driver).waitUntilWebElementIsVisible(dropdownElement);
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText(visibleText);
        } catch (Exception e) {
            System.out.println("Element Not Found: " + dropdownElement);
            e.printStackTrace();
        }
    }

    public void setTextAndTodayDate(WebDriver driver, WebElement element) throws FileNotFoundException {

        try {
            File loginCredFile = new File("data/web/GroupNamePrefix.json");
            FileReader reader = new FileReader(loginCredFile);
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject jsonObject = new JSONObject(tokener);

            String groupNamePrefix = jsonObject.getString("prefix");
            String textToSet = groupNamePrefix + getCurrentDateFormatted();

            WaitElementAction.getWaits(driver).waitUntilWebElementIsVisible(element);
            element.sendKeys(textToSet);
        } catch (Exception e) {
            System.out.println("Element Not Found: " + element);
            e.printStackTrace();
        }
    }

    private String getCurrentDateFormatted() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        return formatter.format(currentDate);
    }

    public void doubleClickElement(WebDriver driver, WebElement locator) {

        try {
            WaitElementAction.getWaits(driver).waitUntilWebElementIsClickable(locator);
            Actions actions = new Actions(driver);
            actions.doubleClick(locator).perform();
        } catch (Exception e) {
            System.out.println("Element Not Found: " + locator);
            e.printStackTrace();
        }
    }

    public void checkCheckbox(WebDriver driver, WebElement locator) {

        try {
            WaitElementAction.getWaits(driver).waitUntilWebElementIsClickable(locator);
            if (!locator.isSelected()) {
                locator.click();
            }
        } catch (Exception e) {
            System.out.println("Element Not Found: " + locator);
            e.printStackTrace();
        }
    }

    public void uncheckCheckbox(WebDriver driver, WebElement locator) {

        try {
            WaitElementAction.getWaits(driver).waitUntilWebElementIsClickable(locator);
            if (locator.isSelected()) {
                locator.click();
            }
        } catch (Exception e) {
            System.out.println("Element Not Found: " + locator);
            e.printStackTrace();
        }
    }

    public void checkRadioButton(WebDriver driver, WebElement locator) {

        try {
            WaitElementAction.getWaits(driver).waitUntilWebElementIsClickable(locator);
            if (!locator.isSelected()) {
                locator.click();
            }
        } catch (Exception e) {
            System.out.println("Element Not Found: " + locator);
            e.printStackTrace();
        }
    }

    public void uncheckRadioButton(WebDriver driver, WebElement locator) {

        try {
            WaitElementAction.getWaits(driver).waitUntilWebElementIsClickable(locator);
            if (locator.isSelected()) {
                locator.click();
            }
        } catch (Exception e) {
            System.out.println("Element Not Found: " + locator);
            e.printStackTrace();
        }
    }

    public void toggleButton(WebDriver driver, WebElement locator, boolean turnOn) {

        try {
            WaitElementAction.getWaits(driver).waitUntilWebElementIsClickable(locator);
            boolean isChecked = Boolean.parseBoolean(locator.getAttribute("checked"));
            if (turnOn && !isChecked) {
                locator.click();
            } else if (!turnOn && isChecked) {
                locator.click();
            }
        } catch (Exception e) {
            System.out.println("Element Not Found: " + locator);
            e.printStackTrace();
        }
    }

    public void applyFilter(WebDriver driver, WebElement filterElement, String optionName, List<WebElement> filterOptions) {

        try {
            WaitElementAction.getWaits(driver).waitUntilListWebElementIsVisible(filterOptions);
            filterElement.click();
            for (WebElement option : filterOptions) {
                if (option.getText().equals(optionName)) {
                    if (!option.isSelected()) {
                        option.click();
                    }
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Element Not Found: " + filterElement);
            e.printStackTrace();
        }
    }

    public void calendarDateSelection(WebDriver driver, WebElement calendarStartIcon, WebElement startingDate, WebElement calendarEndIcon, List<WebElement> dateCells) throws InterruptedException {

        try {
            clickWebElement(calendarStartIcon);
            WaitElementAction.sleep(2000);
            clickWebElement(startingDate);
            Calendar currentDate = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
            String endDate = dateFormat.format(currentDate.getTimeInMillis() + (30L * 24 * 60 * 60 * 1000));
            clickWebElement(calendarEndIcon);
            for (WebElement dateCell : dateCells) {
                if (dateCell.getText().equals(endDate)) {
                    dateCell.click();
                    WaitElementAction.sleep(3000);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Element Not Found: " + calendarStartIcon + ", " + startingDate + ", " + calendarEndIcon);
            e.printStackTrace();
        }
    }
}