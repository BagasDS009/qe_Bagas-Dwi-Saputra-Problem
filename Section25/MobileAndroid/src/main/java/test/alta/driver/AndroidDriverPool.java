package test.alta.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverPool {
    public static AndroidDriver create() {
        AndroidDriver<AndroidElement> driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();

        String appiumUrl =  "http://127.0.0.1:4723/wd/hub/";

        caps.setCapability(AndroidMobileCapabilityType.APPLICATION_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8");
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+ File.separator + "app/app.apk");

        try {
            driver = new AndroidDriver<AndroidElement>(new URL(appiumUrl), caps);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
