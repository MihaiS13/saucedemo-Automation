import driver.DriverFactory;
import driver.WaitUtils;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import testData.URL;
import testData.classes.CheckoutData;
import testData.classes.LoginData;


public class BaseTests {

    protected WebDriver driver;
    protected WaitUtils waitUtils;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected ProductDetailsPage productDetailsPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutYourInformationPage checkoutYourInformationPage;
    protected CheckoutCompletePage checkoutCompletePage;

    protected LoginData validUser;
    protected LoginData invalidUser;
    protected LoginData lockedUser;
    protected CheckoutData checkoutData;

    @BeforeMethod
    public void before() {
        driver = DriverFactory.getDriver();
        DriverFactory.driver = driver;
        //  WaitUtils and Pages initialization
        waitUtils = new WaitUtils(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);

        // data initialization
        validUser = new LoginData("validUser");
        invalidUser = new LoginData("invalidUser");
        lockedUser = new LoginData("lockedUser");
        checkoutData = new CheckoutData("checkoutData");
        driver.get(URL.MAIN_URL);
    }


    @AfterMethod
    public void afterMethod(ITestResult result) {
        // If test fails, take a screenshoot
        if (result.getStatus() == ITestResult.FAILURE && driver != null) {
            saveScreenshot(result.getName());
        }

        // Close the browser.
        if (driver != null) {
            driver.quit();
        }
    }

    // Screenshoot method for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(String testName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    //helper metods
    protected void startFromProductsPage() {
        loginPage.authenticate(validUser.getUsername(), validUser.getPassword());
        Assert.assertTrue(productsPage.isCartButtonDisplayed());
    }

    protected void startFromCheckoutPage(){
        startFromProductsPage();
        productsPage.clickAddToCartFirstProduct();
        productsPage.clickCartButton();
        cartPage.clickCheckoutButton();
    }


}
