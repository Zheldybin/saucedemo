package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static enums.DepartmentNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class LoginTest extends BaseTest {
    @Epic("Модуль логина интернет-магазина")
    @Feature("Юридические лица")
    @Story("STG")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Желдыбин Анатолий zheldynin.aa@mail.ru")
    @TmsLink("saucedemo")
    @Issue("2")
    @Flaky
    @Test(description = "Проверка авторизации")
    public void correctLogin() {
        loginPage
                .open()
                .login(withAdminPermission());
        assertTrue(productPage.titleIsDisplayed());
        assertEquals(productPage.getTitle(), PRODUCTS.getDisplayName());
    }

    @DataProvider(name = "incorrectLoginDate")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"stan", "secret", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Epic("Модуль логина интернет-магазина")
    @Feature("Юридические лица")
    @Story("STG")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Желдыбин Анатолий zheldynin.aa@mail.ru")
    @TmsLink("saucedemo")
    @Issue("2")
    @Test(dataProvider = "incorrectLoginDate")
    public void incorrectLogin(String user, String password, String error) {
        loginPage
                .open()
                .login(user, password);
        assertEquals(loginPage.getErrorMsg(), error);
    }
}
