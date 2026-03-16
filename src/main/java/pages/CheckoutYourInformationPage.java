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
        return getText(checkoutHeader);
    }

    public void clickContinue() {
        click(continueButton);
    }

    // checkoutDataMethods
    public void enterCheckoutInformation(CheckoutData data) {
        type(firstNameInput, data.getFirstName());
        type(lastNameInput, data.getLastName());
        type(postalCodeInput, data.getPostalCode());
        click(continueButton);
    }

    public void enterInvalidCheckoutInformation(String firstName, String lastName, String postalCode) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);
        click(continueButton);
    }
}
