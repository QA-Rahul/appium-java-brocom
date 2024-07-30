package driverutils;

import actions.WaitElementAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static actions.WaitElementAction.driver;

public class WebUtils {

    public static WebDriver getWebDriver() throws FileNotFoundException {

        File loginCred = new File("data/web/LoginCredentials.json");
        FileReader reader = new FileReader(loginCred);
        JSONTokener tokener = new JSONTokener(reader);
        JSONObject jsonObject = new JSONObject(tokener);

        String misUrl = jsonObject.getString("url");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WaitElementAction.setImplicitWait();
        driver.get(misUrl);
        return driver;
    }

    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
