package com.appium.pages;

import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    private IOSDriver driver;
    private By loginButton = By.xpath("//XCUIElementTypeButton[@label='Login']");

    public LandingPage(IOSDriver driver) {
        this.driver = driver;
    }

    public void verifyDefaultPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isLoginButtonPresent = wait.until(ExpectedConditions.presenceOfElementLocated(loginButton)) != null;
        Assert.assertTrue("'Login' button is not present on the page", isLoginButtonPresent);
    }

    public void openLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

}
