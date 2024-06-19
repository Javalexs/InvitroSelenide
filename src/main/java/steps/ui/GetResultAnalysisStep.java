package steps.ui;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AnalysisResults;
import pages.MainPage;

import java.time.LocalDate;

public class GetResultAnalysisStep {
    MainPage mainPage = new MainPage();
    AnalysisResults analysisResults = new AnalysisResults();

    @When("Нажать кнопку 'получить результаты анализов'")
    public void goToAnalysisResults () {
        mainPage.getResultAnalysisButtonClick();
    }

    @And("Проверить заголовок страницы {string}")
    public void checkPageHeader(String textHeader) {
        analysisResults.checkHeader(textHeader);
    }

    @And("Нажать на кнопку 'Найти результаты'")
    public void searchResultButtonClick() {
        analysisResults.searchResultButtonClick();
    }

    @And("Проверить, что поля выделены красным")
    public void checkFieldRedColor() {
        analysisResults.checkFieldColor();
    }

    @And("Проверить сообщение об ошибки {string}")
    public void checkAlertMessageText(String text) {
        analysisResults.checkAlertText(text);
    }

    @Then("В поле 'код ИНЗ' ввести и проверить {string}")
    public void inputValueInFieldINZ(String text) {
        analysisResults.setCodeINZ(text);

    }

    @And("В поле 'Дата рождения' ввести и проверить {string}")
    public void inputValueInFieldDate(String text) {
        analysisResults.setFieldDate(text);
    }

    @And("В поле 'Фамилия' ввести и проверить {string}")
    public void inputValueInFieldLastName(String text) {
        analysisResults.setLastName(text);
    }
}
