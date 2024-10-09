package com.appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.collect.ImmutableMap;
import java.time.Duration;

public class MyAccountPage {
    private IOSDriver driver;
    private By passwordField = AppiumBy.accessibilityId("password");
    private By resetAccountButton = AppiumBy.accessibilityId("reset account");
    private By backButton = AppiumBy.accessibilityId("reset account");
    private By confirmResetAccountButton = AppiumBy.accessibilityId("confirmResetAccount");

    public MyAccountPage(IOSDriver driver) {
        this.driver = driver;
    }

    public void resetAccount() {
        driver.executeScript("mobile: scroll", ImmutableMap.of(
                "direction", "down"
        ));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(resetAccountButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys("SLAva79187164!");
        wait.until(ExpectedConditions.elementToBeClickable(confirmResetAccountButton)).click();
        driver.terminateApp("com.habitrpg.ios.Habitica");
        driver.activateApp("com.habitrpg.ios.Habitica");
    }

    public void tapBackButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }
}
