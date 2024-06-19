package steps.ui;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Cart;
import pages.ForDoctors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumInCartRememberStep {
    public static String sumAddProduct;
    public static String sumProductInCart;
    ForDoctors forDoctors = new ForDoctors();
    Cart cart = new Cart();
    @When("Добавить продукт в корзину")
    public void addProductInCart() {
        forDoctors.addProductInCart();
    }

    @And("Получить сумму продукта добавленного в корзину")
    public void getSumProductAddInCart() {
        sumAddProduct = forDoctors.gesSumProduct();
    }

    @And("Открыть страницу корзины")
    public void openCart() {
        forDoctors.goToCart();
    }

    @And("Получить сумму продукта из корзины")
    public void getSumProductInCart() {
        sumProductInCart = cart.getSumInCart();
    }

    @Then("Сравнить полученные суммы продуктов")
    public void checkSum() {
        assertEquals(sumAddProduct, sumProductInCart, "Полученные суммы продуктов не совпадают");
    }

    @And("Сравнить сумму продуктов с {string} р")
    public void checkSumInCartWithNumber(String number) throws Exception {
        int sumProduct = Integer.parseInt(sumProductInCart.split(" ")[0]);
        int num = Integer.parseInt(number);
        if (sumProduct > num) {
            System.out.println("Сумма в корзине больше " + num);
        } else if (sumProduct < num) {
            System.out.println("Сумма в корзине меньше " + num);
        } else {
            throw new Exception("Сумма в корзине равна " + num);
        }
    }
}
