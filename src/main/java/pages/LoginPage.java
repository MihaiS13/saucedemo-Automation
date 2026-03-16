package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3[@data-test='error']");
    private By logo = By.xpath("//div[@class='login_logo']");
    private By lockedError = By.xpath("//div/h3[@data-test=\"error\"]");


    // Actions
    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public String getLogoText() {
        return getText(logo);
    }

    public String getError() {
        return getText(errorMessage);
    }

    public String getLockedError() {
        return getText(lockedError);
    }

    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }

    public void authenticate(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}