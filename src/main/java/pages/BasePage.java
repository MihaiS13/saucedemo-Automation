package pages;
import driver.DriverFactory;
import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    protected WaitUtils waitUtils;

    public BasePage() {
        this.waitUtils = new WaitUtils(DriverFactory.getDriver());
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }


    protected void click(By locator) {
        waitUtils.visibilityOfElementLocated(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitUtils.visibilityOfElementLocated(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitUtils.visibilityOfElementLocated(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        return waitUtils.visibilityOfElementLocated(locator).isDisplayed();
    }

    protected void selectByVisibleText(By locator, String text) {
        Select select = new Select(waitUtils.visibilityOfElementLocated(locator));
        select.selectByVisibleText(text);
    }
}