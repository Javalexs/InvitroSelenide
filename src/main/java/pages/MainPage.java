package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Класс страницы 'Главная страница'
 * @author Алексей Фадеев
 */
public class MainPage {

    // Значение в секции попапа
    String value;

    // Кнопка выбора города
    SelenideElement cityButton = $x(".//div[contains(@class, 'city__label')]");

    // Кнопка 'Выбрать другой'
    SelenideElement chooseAnotherOneButton = $x(".//*[contains(@class, 'btn--empty')]");

    // Содержит все результаты поиска
    SelenideElement chooseContainer = $("#eac-container-select-basket-city-input");

    // Главный элемент кнопок
    SelenideElement headerButton = $x(".//*[contains(@class, 'invitro_header-bottom')]");

    // Кнопка 'Результаты анализов'
    SelenideElement getResultAnalysisButton = headerButton.$x(".//*[contains(@class, 'invitro_header-get_result')]");

    // Поле ввода для города в поиске
    SelenideElement inputField = $("#select-basket-city-input");

    // Группы в разделе медицинские услуги
    ElementsCollection groups = $$x(".//*[contains(@class, 'side-bar-second__link--icon')]");

    // Активная группа
    SelenideElement activeGroup = $x(".//*[contains(@class, 'side-bar-second__items side-bar__items--active')]");

    // Подгруппы в разделе медицинские услуги
    ElementsCollection subGroups = activeGroup.$$x(".//*[contains(@class, 'side-bar-third__link')]");

    // Поле поиска
    SelenideElement searchField = $("input[name='q']");

    // Кнопка бокового меню
    SelenideElement popup = $("#buttonOpenPopupTargetSTATICSTRINGFORID");

    // Кнопка Закрыть
    SelenideElement closeButton = $("button[id = 'close']");

    // Активный элемент
    private SelenideElement activeElement(String value) {
        return $x(".//*[contains(@class, 'invitro_header-target_audience-item active') and contains(., '" + value + "')]");
    }

    // Элемент
    private SelenideElement element (String value) {
        return $x(".//*[contains(@class, 'invitro_header-target_audience-item ') and contains(., '" + value + "')]");
    }

    // Прокликивание меню с подгруппами
    public MainPage menuClick() {
        List<SelenideElement> groupList = groups;
        for (int i = 0; i < groupList.size(); i++) {
            groupList.get(i).scrollTo().shouldBe(visible, enabled).click();
            if (activeGroup.is(visible)) {
                List<SelenideElement> subGroupList = subGroups;
                for (int j = 0; j < subGroupList.size(); j++) {
                    subGroupList.get(j).scrollTo().shouldBe(visible, enabled).click();
                }
            }
        }
        return this;
    }

    // Нажать кнопку выбора города
    public MainPage cityButtonClick() {
        cityButton.shouldBe(visible, enabled).click();
        return this;
    }

    // Нажать на кнопку 'Выбрать другой'
    public MainPage chooseAnotherOneButtonClick() {
        chooseAnotherOneButton.shouldBe(visible, enabled).click();
        return this;
    }

    // Ввести значение в поле поиска города
    public MainPage inputCity(String city) {
        inputField.setValue(city);
        return this;
    }

    // Проверить результат поиска
    public MainPage checkCity(String city) {
        chooseContainer.shouldHave(text(city)).click();
        return this;
    }

    // Проверить выбранный город
    public MainPage cityVisible(String city) {
        cityButton.shouldBe(visible, enabled, text(city));
        return this;
    }

    // Нажать кнопку Результаты анализов
    public AnalysisResults getResultAnalysisButtonClick() {
        getResultAnalysisButton.shouldBe(visible, enabled).click();
        return new AnalysisResults();
    }

    // Вводим значение
    public SearchAnalysis inputValueInField(String value) {
        searchField.setValue(value).pressEnter();
        return new SearchAnalysis();
    }

    // Нажать кнопку выбрат секцию
    public MainPage sectionButtonClick() {
        popup.shouldBe(visible, enabled).click();
        return this;
    }

    // Выбрать секцию
    public MainPage sectionClick(String value) {
        if(activeElement(value).is(enabled)) {
            closeButton.click();
        } else {
            element(value).click();
        }
        return this;
    }

    // Проверить, что секция выбрана
    public MainPage checkSection(String value) {
        popup.shouldHave(text(value));
        return this;
    }
}
