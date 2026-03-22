package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage() {
        super();
    }

    // Locatori
    private By title = By.xpath("//div/span[@class='title']");
    private By cartButton = By.xpath("//div/a[@class='shopping_cart_link']");
    private By firstProduct = By.className("inventory_item_name");
    private By sortDropdown = By.className("product_sort_container");
    private By itemNames = By.className("inventory_item_name");
    private By itemPrices = By.className("inventory_item_price");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");

    // Actions
    public String getTitleText() {
        return getText(title);
    }

    public boolean isCartButtonDisplayed() {
        return isDisplayed(cartButton);
    }

    public void clickCartButton() {
        click(cartButton);
    }

    public void openFirstProduct() {
        click(firstProduct);
    }

    public void selectSortOption(String optionText) {
        selectByVisibleText(sortDropdown, optionText);
    }

    public List<String> getProductNames() {
        waitUtils.visibilityOfElementLocated(itemNames);
        return getDriver().findElements(itemNames)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<Double> getProductPrices() {
        waitUtils.visibilityOfElementLocated(itemPrices);
        return getDriver().findElements(itemPrices)
                .stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .toList();
    }

    public void openMenu() {
        click(menuButton);
    }

    public void clickLogoutButton() {
        click(logoutButton);
    }

    public void clickAddToCartButton(String productName) {
        By productLocator = By.xpath("//div[text()='" + productName + "']");
        click(productLocator);
    }

    public void clickAddToCartFirstProduct() {
        By addButton = By.xpath("//button[contains(@id,'add-to-cart')]");
        click(addButton);
    }
}


