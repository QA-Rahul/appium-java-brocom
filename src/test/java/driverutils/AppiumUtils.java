package driverutils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

import static actions.WaitElementAction.driver;

public class AppiumUtils {
    public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException, FileNotFoundException {

        String capabilities = "data/mobile/DesiredCapabilities.json";
        FileReader reader = new FileReader(capabilities);
        JSONTokener tokener = new JSONTokener(reader);
        JSONObject jsonObject = new JSONObject(tokener);

        String apkPath = System.getProperty("user.dir") + "/apk/com.bromcom.mcas 1.apk";
        String appPath = jsonObject.getString("app").replace("${apkPath}", apkPath);

        DesiredCapabilities Dcp = new DesiredCapabilities();
        for (String key : jsonObject.keySet()) {
            switch (key) {
                case "app":
                    Dcp.setCapability(MobileCapabilityType.APP, appPath);
                    break;
                case "hubUrl":
                    continue;
                case "ignoreHiddenApiPolicyError":
                case "noReset":
                case "fullReset":
                    Dcp.setCapability(key, jsonObject.getBoolean(key));
                    break;
                default:
                    Dcp.setCapability(key, jsonObject.get(key).toString());
                    break;
            }
        }

        String hubUrl = jsonObject.getString("hubUrl");
        return new AndroidDriver<>(new URL(hubUrl), Dcp);
    }

    public static void quitAppiumDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}