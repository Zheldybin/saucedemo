package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    private final By title = By.cssSelector("[class='title']");
    private final By title2 = By.xpath("//*[text()='Products']");
    private static final String ADD_TO_CART_BUTTON_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public boolean titleIsDisplayed() {
        return driver.findElement(title2).isDisplayed();
    }

    public void addToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public void addToCart(int index) {
        driver.findElements(By.xpath("//*[text()='Add to cart']")).get(index).click();
    }

    public void isOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
    }

    public void openCart () {
        driver.findElement(By.xpath("//*[@data-test='shopping-cart-link']")).click();
    }
}