package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private final By errorSing = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(User user) {
        fillLoginInput(user.getEmail());
        fillPasswordInput(user.getPassword());
        clickSubmitBtn();
    }

    public void login(String username, String password) {
        fillLoginInput(username);
        fillPasswordInput(password);
        clickSubmitBtn();
    }

    public void fillLoginInput(String user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
    }

    public void fillPasswordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickSubmitBtn() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMsg() {
        return driver.findElement(errorSing).getText();
    }
}
