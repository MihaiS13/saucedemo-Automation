package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testData.classes.CheckoutData;

public class CheckoutYourInformationPage extends BasePage {

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
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

    public void clickContinue() {
        waitUtils.visibilityOfElementLocated(continueButton).click();
    }
    //checkoutDataMetods
    public void enterCheckoutInformation(CheckoutData data) {
        waitUtils.visibilityOfElementLocated(firstNameInput).sendKeys(data.getFirstName());
        waitUtils.visibilityOfElementLocated(lastNameInput).sendKeys(data.getLastName());
        waitUtils.visibilityOfElementLocated(postalCodeInput).sendKeys(data.getPostalCode());
        waitUtils.visibilityOfElementLocated(continueButton).click();
    }

    public void enterInvalidCheckoutInformation(String firstName, String lastName, String postalCode) {
        waitUtils.visibilityOfElementLocated(firstNameInput).sendKeys(firstName);
        waitUtils.visibilityOfElementLocated(lastNameInput).sendKeys(lastName);
        waitUtils.visibilityOfElementLocated(postalCodeInput).sendKeys(postalCode);
        waitUtils.visibilityOfElementLocated(continueButton).click();
    }
}
