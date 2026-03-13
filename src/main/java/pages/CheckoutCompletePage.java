package pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutCompletePage extends BasePage {

    private WaitUtils waitUtils;

    public CheckoutCompletePage(WebDriver driver, WaitUtils waitUtils) {
        super(driver);
        this.waitUtils = waitUtils;
    }

    //locators
    private By header = By.className("title");
    private By completeHeader = By.className("complete-header");
    private By backHomeButton = By.id("back-to-products");
    private By completeText = By.className("complete-text");

    // Actions
    public String getHeaderText() {
        return waitUtils.visibilityOfElementLocated(header).getText();
    }

    public String getCompleteHeaderText() {
        return waitUtils.visibilityOfElementLocated(completeHeader).getText();
    }

    public String getCompleteText() {
        return waitUtils.visibilityOfElementLocated(completeText).getText();
    }

    public void clickBackHomeButton() {
        waitUtils.visibilityOfElementLocated(backHomeButton).click();
    }
    public boolean isCompleteHeaderDisplayed() {
        return driver.findElement(completeHeader).isDisplayed();
    }

    public boolean isCompleteTextDisplayed() {
        return driver.findElement(completeText).isDisplayed();
    }

}