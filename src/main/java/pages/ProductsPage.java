package pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {
    private WaitUtils waitUtils;

    // Constructor
    public ProductsPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver);
        this.waitUtils = waitUtils;
    }

    // Locatori
    private By title = By.xpath("//div/span[@class='title']");
    private By cartButton = By.xpath("//div/a[@class='shopping_cart_link']");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By firstProduct = By.className("inventory_item_name");
    private By sortDropdown = By.className("product_sort_container");
    private By itemNames = By.className("inventory_item_name");
    private By itemPrices = By.className("inventory_item_price");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");

    // Actions
    public String getTitleText() {
        return waitUtils.visibilityOfElementLocated(title).getText();
    }

    public boolean isCartButtonDisplayed() {
        return waitUtils.visibilityOfElementLocated(cartButton).isDisplayed();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    public void clickAddToCartButton() {
        waitUtils.visibilityOfElementLocated(addToCartButton).click();
    }

    public void openFirstProduct() {waitUtils.visibilityOfElementLocated(firstProduct).click();}

    public void selectSortOption(String optionText) {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText(optionText);
    }

    public List<String> getProductNames() {
        return driver.findElements(itemNames)
                .stream()
                .map(WebElement::getText)
                .toList();
    }
    public List<Double> getProductPrices() {
        return driver.findElements(itemPrices)
                .stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .toList();
    }

    public void openMenu() {
        driver.findElement(menuButton).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void clickProduct(String productName) {

        By productLocator = By.xpath("//div[text()='" + productName + "']");

        waitUtils.visibilityOfElementLocated(productLocator);

        driver.findElement(productLocator).click();

    }
}
