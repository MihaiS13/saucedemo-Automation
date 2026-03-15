package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

public class CheckoutOverviewPage extends BasePage {


    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
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

    public double getItemTotalValue() {
        String text = waitUtils.visibilityOfElementLocated(itemTotal).getText(); // "Item total: $29.99" >> 29.99
        text = text.replaceAll("[^0-9.]", "");
        return Double.parseDouble(text);
    }

    public double getTaxValue() {
        String text = waitUtils.visibilityOfElementLocated(tax).getText(); // "Tax: $2.40" >> 2.40
        text = text.replaceAll("[^0-9.]", "");
        return Double.parseDouble(text);
    }

    public double getTotalValue() {
        String text = waitUtils.visibilityOfElementLocated(total).getText(); // "Total: $32.39" >> 32.39
        text = text.replaceAll("[^0-9.]", "");
        return Double.parseDouble(text);
    }

    public List<Double> getTotalsValuesList() {
        List<Double> totals = new ArrayList<>();
        totals.add(getItemTotalValue());
        totals.add(getTaxValue());
        totals.add(getTotalValue());
        return totals;
    }

}

