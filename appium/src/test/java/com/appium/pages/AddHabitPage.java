package com.appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddHabitPage {
    private IOSDriver driver;
    private By titleField = AppiumBy.accessibilityId("Title");
    private By createButton = By.xpath("//XCUIElementTypeButton[@label='Create']");

    public AddHabitPage(IOSDriver driver) {
        this.driver = driver;
    }

    public void enterTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(titleField)).sendKeys(title);
    }

    public void tapCreateButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }
}
