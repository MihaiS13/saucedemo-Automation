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
        return getText(header);
    }

    public String getProductDescription() {
        return getText(productDescription);
    }

    public void clickFinishButton() {
        click(finishButton);
    }

    public double getItemTotalValue() {
        String text = getText(itemTotal); // "Item total: $29.99" >> 29.99
        text = text.replaceAll("[^0-9.]", "");
        return Double.parseDouble(text);
    }

    public double getTaxValue() {
        String text = getText(tax); // "Tax: $2.40" >> 2.40
        text = text.replaceAll("[^0-9.]", "");
        return Double.parseDouble(text);
    }

    public double getTotalValue() {
        String text = getText(total); // "Total: $32.39" >> 32.39
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