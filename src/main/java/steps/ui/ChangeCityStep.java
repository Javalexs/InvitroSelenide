package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;

public class ChangeCityStep {
    MainPage mainPage = new MainPage();

    @When("Открыть меню Выбор города")
    public void openMenu() {
        mainPage.cityButtonClick();
    }

    @And("Нажать на кнопку 'Выбрать другой'")
    public void chooseAnotherOneButtonClick() {
        mainPage.chooseAnotherOneButtonClick();
    }

    @And("Ввести в поиск {string}")
    public void inputCity(String city) {
        mainPage.inputCity(city);
    }

    @Then("Проверить, что выбранный город {string} есть в поиске")
    public void checkCityAndPressEnter(String city) {
        mainPage.checkCity(city);
    }

    @And("Проверить отображение города {string}")
    public void cityVisible(String city) {
        mainPage.cityVisible(city);
    }
}
