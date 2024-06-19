package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;

public class CheckPopupStep {
    MainPage mainPage = new MainPage();

    @When("Нажать на кнопку выбора раздела")
    public void openPopup() {
        mainPage.sectionButtonClick();
    }

    @And("Выбрать секцию {string}")
    public void selectSection (String section) {
        mainPage.sectionClick(section);
    }

    @Then("Проверить, что секция {string} выбрана")
    public void checkSectionInSelected(String text) {
        mainPage.checkSection(text);
    }
}
