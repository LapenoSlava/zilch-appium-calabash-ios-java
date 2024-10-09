package com.appium.steps;

import com.appium.pages.OnboardingPage;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.*;
import com.appium.utils.DriverFactory;

public class OnboardingSteps {
    private IOSDriver driver = DriverFactory.getDriver();
    private OnboardingPage onboardingPage = new OnboardingPage(driver);

    @When("I tap Skip button on Onboarding Page")
    public void tapSkipButton() {
        onboardingPage.tapSkipButton();
    }
}
