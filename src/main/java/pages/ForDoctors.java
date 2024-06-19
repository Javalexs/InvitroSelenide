package pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Math.random;

/**
 * Класс страницы 'Список анализов'
 * @author Алексей Фадеев
 */
public class ForDoctors {

    // Хедер страницы
    SelenideElement headerMenu = $x(".//*[contains(@class, 'invitro_header-menu')]");

    // Страница анализов
    SelenideElement analyzesPage = $x(".//*[contains(@class, 'analyzes-page')]");

    // Кнопка Добавить продукт
    ElementsCollection addButton = analyzesPage.$$x(".//*[contains(@class, 'ds_box_svg')]");

    // Кнопка корзины
    SelenideElement cartButton = headerMenu.$x(".//div[contains(@class,'invitro-header-cart__icon')]");

    // Сумма продуктов
    SelenideElement getSum = $x(".//*[contains(@class, 'analyzes-item__to-basket')]/parent::*//*[contains(@class, 'analyzes-item__total--sum')]");

    // Добавить продукт в корзину
    public ForDoctors addProductInCart() {
        addButton.first().click();
        return this;
    }

    // Взять сумму продуктов
    public String gesSumProduct() {
        return getSum.text();
    }

    // Перейти в корзину
    public Cart goToCart() {
        cartButton.shouldBe(visible, enabled).click();
        return new Cart();
    }
}
