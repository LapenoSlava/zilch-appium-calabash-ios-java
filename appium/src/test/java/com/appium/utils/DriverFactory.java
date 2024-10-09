package com.appium.utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static IOSDriver driver;

    public static IOSDriver getDriver() {
        if (driver == null) {
            try {
                XCUITestOptions options = new XCUITestOptions()
                        .setPlatformName("iOS")
                        .setPlatformVersion("17.4")
                        .setDeviceName("iPhone 15")
                        .setApp("apps/Habitica.app")
                        .setAutomationName("XCUITest")
                        .setNoReset(false);
//                .setFullReset(false)

                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
