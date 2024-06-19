package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

/**
 * Класс страницы 'Корзина'
 * @author Алексей Фадеев
 */
public class Cart {

    // Элементы в корзине
    ElementsCollection elements = $$x(".//*[contains(@class, 'CartProduct_productPrice__')]");

    // Взять сумму элемента
    public String getSumInCart() {
        return elements.first().text();
    }
}
