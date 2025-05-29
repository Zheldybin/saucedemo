package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    private final By title = By.cssSelector("[class='title']");
    private final By title2 = By.xpath("//*[text()='Products']");
    private final By addToCart = By.xpath("//*[text()='Add to cart']");
    private final By cartLink = By.xpath("//*[@data-test='shopping-cart-link']");
    private static final String ADD_TO_CART_BUTTON_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем название товара")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Проверяем что отбражается заголовок страницы")
    public boolean titleIsDisplayed() {
        return driver.findElement(title2).isDisplayed();
    }

    @Step("Добавление товара в корзину")
    public ProductPage addToCart(int index) {
        driver.findElements(addToCart).get(index).click();
        return this;
    }

    @Step("Ожидаем прогрузки карточки товаров")
    public ProductPage isOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return this;
    }

    @Step("Открытие корзины")
    public ProductPage openCart() {
        driver.findElement(cartLink).click();
        return this;
    }
}
