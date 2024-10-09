package com.appium.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;

import java.time.Duration;

public class SettingsPage {
    private IOSDriver driver;
    private By logoutButton = AppiumBy.accessibilityId("Logout");
    private By myAccountButton = AppiumBy.accessibilityId("my account");

    public SettingsPage(IOSDriver driver) {
        this.driver = driver;
    }

    public void tapLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public void openMyAccountPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton)).click();
    }
}
