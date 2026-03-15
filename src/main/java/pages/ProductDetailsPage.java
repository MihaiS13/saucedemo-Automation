package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    //locators
    private By productDescription = By.className("inventory_details_desc");
    private By addToCartButton = By.id("add-to-cart");
    private By backToProductsButton = By.id("back-to-products");
    private By productPrice = By.className("inventory_details_price");
    private By cartButton = By.className("shopping_cart_link");
    //actions

    public String getProductDescription() {
        return waitUtils.visibilityOfElementLocated(productDescription).getText();
    }

    public void clickAddToCartButton(){
        waitUtils.visibilityOfElementLocated(addToCartButton).click();
    }

    public void clickBackToProductsButton(){
        waitUtils.visibilityOfElementLocated(backToProductsButton).getText();
    }

    public void clickCartButton(){
        waitUtils.visibilityOfElementLocated(cartButton).click();
    }

    public double getProductPriceValue() {
        String priceText = waitUtils.visibilityOfElementLocated(productPrice).getText();
        priceText = priceText.replaceAll("[^0-9.]", "").trim();
        return Double.parseDouble(priceText);
    }

}

