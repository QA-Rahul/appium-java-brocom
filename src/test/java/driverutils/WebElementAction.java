package driverutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class WebElementAction {

    public void clickWebElement(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendKeysToWebElement(WebDriver driver, WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public void selectDropdownByVisibleText(WebDriver driver, WebElement dropdownElement, String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(dropdownElement));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    public void setTextAndTodayDate(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String textPrefix = "QA_GROUP_";
        String textToSet = textPrefix + getCurrentDateFormatted();
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(textToSet);
    }

    private String getCurrentDateFormatted() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        return formatter.format(currentDate);
    }

    public void doubleClickElement(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Actions actions = new Actions(driver);
        actions.doubleClick(locator).perform();
    }

    public void checkCheckbox(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        if (!locator.isSelected()) {
            locator.click();
        }
    }

    public void uncheckCheckbox(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        if (locator.isSelected()) {
            locator.click();
        }
    }

    public void checkRadioButton(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        if (!locator.isSelected()) {
            locator.click();
        }
    }

    public void uncheckRadioButton(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        if (locator.isSelected()) {
            locator.click();
        }
    }

    public void toggleButton(WebDriver driver, WebElement locator, boolean turnOn) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        boolean isChecked = Boolean.parseBoolean(locator.getAttribute("checked"));
        if (turnOn && !isChecked) {
            locator.click();
        } else if (!turnOn && isChecked) {
            locator.click();
        }
    }

    public static void applyFilter(WebDriver driver, WebElement filterElement, String optionName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(filterElement));
        filterElement.click();

        List<WebElement> filterOptions = driver.findElements(By.xpath("//div[@class='popover-content']//div[@class='checkbox']"));

        for (WebElement option : filterOptions) {
            if (option.getText().equals(optionName)) {
                if (!option.isSelected()) {
                    option.click();
                }
                break;
            }
        }
    }

    public void calendarDateSelection(WebDriver driver, WebElement calendarStartIcon, WebElement startingDate, WebElement calendarEndIcon) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(calendarStartIcon)).click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(startingDate)).click();

        Calendar currentDate = Calendar.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

        String endDate = dateFormat.format(currentDate.getTimeInMillis() + (30L * 24 * 60 * 60 * 1000));

        wait.until(ExpectedConditions.elementToBeClickable(calendarEndIcon)).click();

        List<WebElement> dateCells = driver.findElements(By.xpath("//div[@class='k-calendar-view']//tbody//td"));
        for (WebElement dateCell : dateCells) {
            if (dateCell.getText().equals(endDate)) {
                dateCell.click();
                Thread.sleep(3000);
                break;
            }
        }

    }













}
