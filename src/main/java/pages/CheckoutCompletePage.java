package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutCompletePage extends BasePage {

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    //locators
    private By header = By.className("title");
    private By completeHeader = By.className("complete-header");
    private By backHomeButton = By.id("back-to-products");
    private By completeText = By.className("complete-text");

    // Actions
    public boolean isCompleteHeaderDisplayed() {
        return isDisplayed(completeHeader);
    }

    public boolean isCompleteTextDisplayed() {
        return isDisplayed(completeText);
    }

}