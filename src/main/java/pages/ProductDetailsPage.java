package pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductDetailsPage extends BasePage {

    private WaitUtils waitUtils;

    public ProductDetailsPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver);
        this.waitUtils = waitUtils;
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

    public String getProductPrice() {
        return waitUtils.visibilityOfElementLocated(productPrice).getText();
    }
    public void clickCartButton(){
        waitUtils.visibilityOfElementLocated(cartButton).click();
    }

}

