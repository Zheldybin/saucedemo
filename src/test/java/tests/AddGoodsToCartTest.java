package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class AddGoodsToCartTest extends BaseTest {
    @Test()
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productPage.isOpen();
        productPage.addToCart(0);
        productPage.addToCart(1);
        productPage.addToCart(2);
        productPage.openCart();
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
    }
}
