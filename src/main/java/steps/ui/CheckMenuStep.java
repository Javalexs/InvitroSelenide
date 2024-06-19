package steps.ui;

import io.cucumber.java.en.Then;
import pages.MainPage;

public class CheckMenuStep {
    MainPage mainPage = new MainPage();

    @Then("Прокликать все меню")
    public CheckMenuStep clickMenu() {
        mainPage.menuClick();
        return this;
    }
}
