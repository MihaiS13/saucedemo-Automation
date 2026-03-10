package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        ChromeOptions chromeOption = new ChromeOptions();
        chromeOption.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        chromeOption.addArguments("disable-infobars"); // Disable infobars
        chromeOption.addArguments("disable-popup-blocking"); // Disable popup blocking
        chromeOption.addArguments("disable-default-apps"); // Disable default apps
        chromeOption.addArguments("no-first-run"); // Skip first run wizards
        chromeOption.addArguments("no-default-browser-check"); // Skip default browser check
        chromeOption.addArguments("--disable-search-engine-choice-screen");
        chromeOption.addArguments("start-maximized"); // Open browser in maximized mode
        chromeOption.addArguments("disable-notifications"); // Disable notifications
        chromeOption.addArguments("disable-extensions"); // Disable extensions
        chromeOption.addArguments("guest"); // Disable change password popup

         driver = new ChromeDriver(chromeOption);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        return driver;
    }
    public static WebDriver closeDriver() {
        driver.quit();
        return driver;
    }



}
