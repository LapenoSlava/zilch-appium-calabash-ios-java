package com.appium.pages;

import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;
import com.appium.utils.User;

import java.time.Duration;

public class LoginPage {
    private IOSDriver driver;
    private By usernameField = AppiumBy.accessibilityId("Username");
    private By passwordField = AppiumBy.accessibilityId("Password");
    private By loginButton = By.xpath("//XCUIElementTypeButton[@label='Login']");

    public LoginPage(IOSDriver driver) {
        this.driver = driver;
    }

    public void verifyDefaultPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isUsernameFieldExists = wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)) != null;
        Assert.assertTrue("'Username' field is not present on the page", isUsernameFieldExists);
        boolean isPasswordFieldExists = wait.until(ExpectedConditions.presenceOfElementLocated(usernameField)) != null;
        Assert.assertTrue("'Password' field is not present on the page", isPasswordFieldExists);
    }

    public void login() {
        User user = new User();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(usernameField)).sendKeys(user.email());
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(user.password());
        tapLoginButton();
    }
    public void tapLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}
