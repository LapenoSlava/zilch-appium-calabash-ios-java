package com.appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;

public class HabitsPage {
    private IOSDriver driver;
    private By menuButton = By.xpath("//XCUIElementTypeButton[@label='Menu']");
    private By settingsButton = By.xpath("//XCUIElementTypeButton[@label='Settings']");
    private By addHabitButton = By.xpath("//XCUIElementTypeButton[@label='Add Habit']");
    private By zeroHabitsLabel = AppiumBy.accessibilityId("zeroHabits");

    public HabitsPage(IOSDriver driver) {
        this.driver = driver;
    }

    public void verifyDefaultPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isAddHabitButtonPresent = wait.until(ExpectedConditions.presenceOfElementLocated(addHabitButton)) != null;
        Assert.assertTrue("'Add Habit' button is not present on the page", isAddHabitButtonPresent);
    }

    public void tapAddHabitButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addHabitButton)).click();
    }
    public void openMenuPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
    }

    public void openSettingsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(settingsButton)).click();
    }

    public void verifyHabitsListIsEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isZeroHabitsLabelPresent = wait.until(ExpectedConditions.presenceOfElementLocated(zeroHabitsLabel)) != null;
        Assert.assertTrue("'Zero Habits' text is not present on the page", isZeroHabitsLabelPresent);
    }

    public void verifyHabitsListIsNotEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(zeroHabitsLabel));
            System.out.println("'Zero Habits' label is no longer visible.");
        } catch (TimeoutException e) {
            Assert.fail("'Zero Habits' text is still present on the page, but it should not be.");
        }
    }
}
