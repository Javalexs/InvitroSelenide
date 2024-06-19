package hooks;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

/**
 * Класс страницы 'Завершающее действие'
 * @author Алексей Фадеев
 */
public class AfterAction {
    // Завершение работы драйвера
    @After
    public void quitWebDriver() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.getWebDriver().quit();
        }
    }
}
