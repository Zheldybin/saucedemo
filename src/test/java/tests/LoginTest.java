package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productPage.titleIsDisplayed());
        assertEquals(productPage.getTitle(), "Products");
    }

    @DataProvider(name = "incorrectLoginDate")
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

