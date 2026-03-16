package pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    protected static WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
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