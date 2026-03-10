package pages;

import driver.WaitUtils;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected static WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);

    }

    public void navigate(String url) {
        driver.get(url);
    }
}
