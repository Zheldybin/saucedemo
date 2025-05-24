package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class AddGoodsToCartTest extends BaseTest {
    @Epic("Модуль логина интернет-магазина")
    @Feature("Юридические лица")
    @Story("STG")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Желдыбин Анатолий zheldynin.aa@mail.ru")
    @TmsLink("saucedemo")
    @Issue("2")
    @Flaky
    @Test(description = "Проверяем что товары добавлены в корзину")
    public void checkGoodsInCart() {
        loginPage
                .open()
                .login(withAdminPermission());
        productPage
                .isOpen()
                .addToCart(0)
                .addToCart(1)
                .addToCart(2)
                .openCart();
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
    }
}
