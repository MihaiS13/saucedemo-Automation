package pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testData.classes.CheckoutData;

public class CheckoutYourInformationPage extends BasePage {

    private WaitUtils waitUtils;

    public CheckoutYourInformationPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver);
        this.waitUtils = waitUtils;
    }

    // locators
    private By checkoutHeader = By.className("title");
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");

    //actions
    public String getCheckoutHeaderText() {
        return waitUtils.visibilityOfElementLocated(checkoutHeader).getText();
    }

    public void enterFirstName(String firstName) {
        waitUtils.visibilityOfElementLocated(firstNameInput).clear();
        waitUtils.visibilityOfElementLocated(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        waitUtils.visibilityOfElementLocated(lastNameInput).clear();
        waitUtils.visibilityOfElementLocated(lastNameInput).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        waitUtils.visibilityOfElementLocated(postalCodeInput).clear();
        waitUtils.visibilityOfElementLocated(postalCodeInput).sendKeys(postalCode);
    }

    public void clickContinue() {
        waitUtils.visibilityOfElementLocated(continueButton).click();
    }
    //checkoutDataMetods
    public void enterValidData(CheckoutData data) {
        waitUtils.visibilityOfElementLocated(firstNameInput).sendKeys(data.getfirstName());
        waitUtils.visibilityOfElementLocated(lastNameInput).sendKeys(data.getlastName());
        waitUtils.visibilityOfElementLocated(postalCodeInput).sendKeys(data.getpostalCode());
        waitUtils.visibilityOfElementLocated(continueButton).click();
    }

    public void enterInvalidData(CheckoutData data) {
        waitUtils.visibilityOfElementLocated(firstNameInput).sendKeys(data.getinvalidFirstName());
        waitUtils.visibilityOfElementLocated(lastNameInput).sendKeys(data.getinvalidLastName());
        waitUtils.visibilityOfElementLocated(postalCodeInput).sendKeys(data.getinvalidPostalCode());
        waitUtils.visibilityOfElementLocated(continueButton).click();
    }
}
