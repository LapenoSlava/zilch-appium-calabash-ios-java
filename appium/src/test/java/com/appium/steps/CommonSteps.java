package com.appium.steps;

import com.appium.pages.*;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.appium.utils.DriverFactory;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;
import org.openqa.selenium.By;

public class CommonSteps {
    private IOSDriver driver = DriverFactory.getDriver();
    private LandingPage landingPage = new LandingPage(driver);
    private HabitsPage habitsPage = new HabitsPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private SettingsPage settingsPage = new SettingsPage(driver);
    private MyAccountPage myAccountPage = new MyAccountPage(driver);
    private final By allowNotificationsButton = By.xpath("//XCUIElementTypeButton[@name='Allow']");

    @Given("I grant permission to notifications")
    public void grantNotificationPermission() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(allowNotificationsButton));
            driver.findElement(allowNotificationsButton).click();
        } catch (TimeoutException e) {
            System.out.println("Notification permission alert is not present - assuming permission is granted");
        }
    }

    @When("I tap Login button on Landing Page")
    public void tapLoginButton() {
        landingPage.openLoginPage();
    }

    @When("I login with the new user")
    public void login() {
        loginPage.login();
    }

    @When("I tap Log Out button")
    public void tapLogOutButton() {
        settingsPage.tapLogoutButton();
    }

    @Then("I am on Login Page")
    public void verifyDefaultLoginPage() {
        loginPage.verifyDefaultPage();
    }

    @Then("I reset my account")
    public void resetAccount() {
        habitsPage.openMenuPage();
        habitsPage.openSettingsPage();
        settingsPage.openMyAccountPage();
        myAccountPage.resetAccount();
    }
}
