package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver getDriver() {

        ChromeOptions chromeOption = new ChromeOptions();
        // Essential for GitHub Actions (Linux environment)
        chromeOption.addArguments("--headless=new"); // Run without GUI
        chromeOption.addArguments("--no-sandbox");    // Bypass OS security model
        chromeOption.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        chromeOption.addArguments("--window-size=1920,1080"); // Set virtual screen resolution
        // General Chrome settings
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


        return driver;
    }

}