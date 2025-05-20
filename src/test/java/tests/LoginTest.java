package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productPage.titleIsDisplayed());
        assertEquals(productPage.getTitle(), "Products");
        //productPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productPage.isOpen();
        productPage.addToCart(0);
        productPage.addToCart(1);
        productPage.addToCart(2);
        productPage.openCart();
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
    }

    @DataProvider(name="incorrectLoginDate")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"stan", "secret", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "incorrectLoginDate")
    public void incorrectLogin(String user, String password, String error) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMsg(), error);
    }
}

