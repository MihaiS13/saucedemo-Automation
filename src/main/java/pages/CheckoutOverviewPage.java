package pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testData.classes.CheckoutData;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOverviewPage extends BasePage {

    private WaitUtils waitUtils;

    public CheckoutOverviewPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver);
        this.waitUtils = waitUtils;
    }

    //locators
    private By header = By.className("title");
    private By productDescription = By.className("inventory_item_desc");
    private By finishButton = By.id("finish");
    private By itemTotal = By.className("summary_subtotal_label");
    private By tax = By.className("summary_tax_label");
    private By total = By.className("summary_total_label");

    // Actions
    public String getHeaderText() {
        return waitUtils.visibilityOfElementLocated(header).getText();
    }

    public String getProductDescription() {
        return waitUtils.visibilityOfElementLocated(productDescription).getText();
    }

    public void clickFinishButton() {
        waitUtils.visibilityOfElementLocated(finishButton).click();
    }

    public String getItemTotalText() {
        return waitUtils.visibilityOfElementLocated(itemTotal).getText();
    }

    public String getTaxText() {
        return waitUtils.visibilityOfElementLocated(tax).getText();
    }

    public List<String> getTotalsList() {
        List<String> totals = new ArrayList<>();
        totals.add(waitUtils.visibilityOfElementLocated(itemTotal).getText());
        totals.add(waitUtils.visibilityOfElementLocated(tax).getText());
        totals.add(waitUtils.visibilityOfElementLocated(total).getText());
        return totals;
    }
}

