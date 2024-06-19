package pages;

import allure.selenide.CustomAllureSelenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

/**
 * Класс 'Основные методы'
 * @author Алексей Фадеев
 */
public class BaseMethod {

    /**
     * Переопределяем собственный листенер для скриншотов
     *
     * @author Алексей Фадеев
     */
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new CustomAllureSelenide().screenshots(true).savePageSource(true));
    }

    @Given("Открыть сайт {string}")
    public void open_url(String url) {
        open(url);
    }
}
