package steps.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import pages.MainPage;
import pages.SearchAnalysis;

public class CheckCodeAnalysisStep {
    MainPage mainPage = new MainPage();
    SearchAnalysis searchAnalysis = new SearchAnalysis();

    @When("Ввести в поисковую строку {string} и нажать ввод")
    public void input(String value) {
        mainPage.inputValueInField(value);
    }

    @Then("Проверить, что продукт с кодом {string} присутствует на странице поиска")
    public void check(String value) {
        searchAnalysis.checkResult(value);
    }
}
