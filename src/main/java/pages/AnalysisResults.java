package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.MatchText;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Класс страницы 'Анализы результатов'
 * @author Алексей Фадеев
 */
public class AnalysisResults {

    // Форматирование даты
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    // Тело страницы
    SelenideElement body = $x(".//div[contains(@class, 'UnauthResultsPage_bodyContainer')]");

    // кнопка 'Найти результаты'
    SelenideElement searchResultButton = body.$x(".//*[contains(@class, 'Button_')]");

    // Строка предупреждение
    ElementsCollection words = $$x(".//span[contains(@class, 'UnauthResultsPage_noteBold')]");

    // Поле формы заполнения
    SelenideElement formField = body.$x(".//*[contains(@class, 'UnauthResultsPage_error__')]");

    // Блок окон для ввода данных
    SelenideElement blockInputWindows = $x(".//*[contains(@class, 'UnauthResultsPage_formBlock__')]");

    // Поля ввода
    ElementsCollection elementsField = blockInputWindows.$$x(".//*[contains(@class, 'Input_input__')]");

    // Выбранный день при вводе даты
    SelenideElement daySelected = $x(".//*[contains(@class, 'react-datepicker__day--selected')]");

    // Поле ввода кода ИНЗ
    SelenideElement fieldCodeINZ = $(By.name("orderNumber"));

    // Поле ввода даты
    SelenideElement dataPickerField = $(By.name("birthday"));

    // Поле ввода Фамилии
    SelenideElement fieldLastName = $(By.name("lastName"));

    // Нажать кнопку 'Найти результаты'
    public AnalysisResults searchResultButtonClick() {
        searchResultButton.shouldBe(visible, enabled).click();
        return this;
    }

    // Проверить заголовок страницы
    public AnalysisResults checkHeader(String header) {
        body.shouldBe(visible, enabled, matchText(header));
        return this;
    }

    // Проверить текст предупреждения
    public AnalysisResults checkAlertText(String text) {
        formField.shouldBe(visible, enabled, matchText(text));
        return this;
    }

    // Проверить поля по цвету
    public AnalysisResults checkFieldColor() {
        for(SelenideElement element : elementsField) {
            element.shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));
        }
        return this;
    }

    // Ввести код ИНЗ и проверить поле
    public AnalysisResults setCodeINZ(String codeInz) {
        fieldCodeINZ.shouldBe(visible, enabled).clear();
        fieldCodeINZ.sendKeys(Keys.HOME, codeInz);
        fieldCodeINZ.shouldHave(visible, value(codeInz));
        return this;
    }

    // Ввести дату в поле и проверить поле
    public AnalysisResults setFieldDate(String date) {
        dataPickerField.shouldBe(visible, enabled).clear();
        dataPickerField.sendKeys(Keys.HOME);
        dataPickerField.sendKeys(date);
        daySelected.shouldBe(visible).click();
        dataPickerField.shouldHave(visible, value(date));
        return this;
    }

    // Ввести Фамилию и проверить поле
    public AnalysisResults setLastName(String lastName) {
        fieldLastName.shouldBe(visible, enabled).clear();
        fieldLastName.sendKeys(Keys.HOME, lastName);
        fieldLastName.shouldHave(visible, value(lastName));
        return this;
    }
}