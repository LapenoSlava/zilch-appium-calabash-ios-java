package com.appium.steps;

import com.appium.pages.*;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.*;
import com.appium.utils.DriverFactory;

public class HabitsSteps {
    private IOSDriver driver = DriverFactory.getDriver();

    private HabitsPage habitsPage = new HabitsPage(driver);
    private AddHabitPage addHabitPage = new AddHabitPage(driver);

    @When("I create a new Habit with {string}")
    public void createNewHabit(String title) {
        habitsPage.tapAddHabitButton();
        addHabitPage.enterTitle(title);
        addHabitPage.tapCreateButton();
    }

    @Then("I verify list of habits is empty")
    public void verifyHabitsListIsEmpty() {
        habitsPage.verifyHabitsListIsEmpty();
    }

    @Then("I verify list of habits is not empty")
    public void verifyHabitsListIsNotEmpty() {
        habitsPage.verifyHabitsListIsNotEmpty();
    }

    @When("I tap Add Habit button")
    public void tapAddHabitButton() {
        habitsPage.tapAddHabitButton();
    }

    @Then("I am on Habits Page")
    public void verifyDefaultHabitsPage() {
        habitsPage.verifyDefaultPage();
    }

    @When("I open Settings Page")
    public void tapMenuButton() {
        habitsPage.openMenuPage();
        habitsPage.openSettingsPage();
    }

}
