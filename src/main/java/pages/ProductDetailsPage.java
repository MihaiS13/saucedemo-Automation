package pages;
import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage() {
        super();
    }

    //locators
    private By productDescription = By.className("inventory_details_desc");
    private By addToCartButton = By.id("add-to-cart");
    private By backToProductsButton = By.id("back-to-products");
    private By productPrice = By.className("inventory_details_price");
    private By cartButton = By.className("shopping_cart_link");
    //actions

    public String getProductDescription() {
        return getText(productDescription);
    }

    public void clickAddToCartButton() {
        click(addToCartButton);
    }

    public void clickBackToProductsButton() {
        click(backToProductsButton);
    }

    public void clickCartButton() {
        click(cartButton);
    }

    public double getProductPriceValue() {
        String priceText = getText(productPrice);
        priceText = priceText.replaceAll("[^0-9.]", "").trim();
        return Double.parseDouble(priceText);
    }
}
