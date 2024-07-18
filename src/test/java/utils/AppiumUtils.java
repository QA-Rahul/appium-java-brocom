package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumUtils {
    public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException {
        DesiredCapabilities Dcp = new DesiredCapabilities();
        Dcp.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        Dcp.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        Dcp.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        Dcp.setCapability(MobileCapabilityType.DEVICE_NAME, "RMX1825");
        Dcp.setCapability(MobileCapabilityType.UDID, "PRY5AUOJONAAVO6T");
        Dcp.setCapability("appPackage", "com.bromcom.mcas");
        Dcp.setCapability("appActivity", "crc64738b383418757493.MainActivity");
        Dcp.setCapability(MobileCapabilityType.APP, "D:\\TestingAPK\\com.bromcom.mcas 1.apk");
        Dcp.setCapability("ignoreHiddenApiPolicyError", true);
        Dcp.setCapability("noReset", true);  // Prevents resetting app state
        Dcp.setCapability("fullReset", false);

        return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), Dcp);
    }
}