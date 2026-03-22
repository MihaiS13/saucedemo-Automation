package pages;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    public CartPage() {
        super();
    }

    // locators
    private By removeButton = By.id("remove-sauce-labs-backpack");
    private By yourCartHeader = By.xpath("//span[@class='title']");
    private By checkoutButton = By.id("checkout");
    private By productDescriptionInCart = By.className("inventory_item_desc");
    private By cartItems = By.className("cart_item");
    private By cartPrice = By.className("inventory_item_price");
    // actions

    public boolean isProductDisplayed(String productName) {
        By productLocator = By.xpath("//div[contains(text(),'" + productName + "')]");
        return waitUtils.visibilityOfElementLocated(productLocator).isDisplayed();
    }

    public boolean isCartEmpty() {
        return getDriver().findElements(cartItems).isEmpty();
    }

    public void clickRemoveButton() {
        click(removeButton);
    }

    public boolean isCartHeaderDisplayed() {
        return isDisplayed(yourCartHeader);
    }

    public void clickCheckoutButton() {
        click(checkoutButton);
    }

    public String getProductDescription() {
        return getText(productDescriptionInCart);
    }

    public double getProductPriceValue() {
        String priceText = getText(cartPrice);
        priceText = priceText.replaceAll("[^0-9.]", "").trim();
        return Double.parseDouble(priceText);
    }
}





