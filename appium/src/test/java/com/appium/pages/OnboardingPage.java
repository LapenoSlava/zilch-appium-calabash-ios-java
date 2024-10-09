package com.appium.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnboardingPage {
    private IOSDriver driver;
    private By skipButton = By.xpath("//XCUIElementTypeButton[@label='Skip']");

    public OnboardingPage(IOSDriver driver) {
        this.driver = driver;
    }

    public void tapSkipButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(skipButton)).click();
    }
}
