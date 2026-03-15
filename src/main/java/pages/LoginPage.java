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
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getLogoText() {
        return waitUtils.visibilityOfElementLocated(logo).getText();
    }

    public String getError() {
        return waitUtils.visibilityOfElementLocated(errorMessage).getText();
    }

    public String getLockedError() {
        return waitUtils.visibilityOfElementLocated(lockedError).getText();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public void authenticate(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
