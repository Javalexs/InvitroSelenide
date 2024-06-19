package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс страницы 'Найти анализы'
 * @author Алексей Фадеев
 */
public class SearchAnalysis {

    // Результаты анализов
    SelenideElement resultAnalysis = $x("//div[contains(@class,'analyzes-item__head--number')]");

    // Проверка результата, что номер анализа совпадает
    public SearchAnalysis checkResult(String value) {
        String str = resultAnalysis.text().replaceAll("[^0-9]", "");
        assertEquals(str, value, "Вводимое значение не найдено на странице поиска");
        return this;
    }
}
