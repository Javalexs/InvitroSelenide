package hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;

/**
 * Класс страницы 'Начальные настройки'
 * @author Алексей Фадеев
 */
public class BeforeAction {

    // Начальные настройки браузера
    @Before
    public static void option() {
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
    }
}
