package pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private WaitUtils waitUtils;

    public CartPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver);
        this.waitUtils = waitUtils;
    }

    // locators
    private By removeButton = By.id("remove-sauce-labs-backpack");
    private By yourCartHeader = By.xpath("//span[@class='title']");
    private By sauceLabsBackpackProduct = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
    private By checkoutButton = By.id("checkout");
    private By productDescriptionInCart = By.className("inventory_item_desc");
    private By cartItems = By.className("cart_item");
    private By cartPrice = By.className("inventory_item_price");
    // actions

    public String getProductPrice() {
        return waitUtils.visibilityOfElementLocated(cartPrice).getText();
    }

    public boolean isProductDisplayed() {
        return waitUtils.visibilityOfElementLocated(sauceLabsBackpackProduct).isDisplayed();
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartItems).isEmpty();
    }

    public void clickRemoveButton() {
        waitUtils.visibilityOfElementLocated(removeButton).click();
    }

    public boolean isCartHeaderDisplayed() {
        return waitUtils.visibilityOfElementLocated(yourCartHeader).isDisplayed();
    }

    public void clickCheckoutButton() {
        waitUtils.visibilityOfElementLocated(checkoutButton).click();

    }

    public String getProductDescription() {
        return waitUtils.visibilityOfElementLocated(productDescriptionInCart).getText();
    }
}





