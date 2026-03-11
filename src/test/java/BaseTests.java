import driver.DriverFactory;
import driver.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import testData.URL;
import testData.classes.CheckoutData;
import testData.classes.ExpectedTotals;
import testData.classes.LoginData;
import org.testng.annotations.Listeners;

@Listeners({AllureListener.class})
public class BaseTests {

    protected WebDriver driver;
    protected WaitUtils waitUtils;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutYourInformationPage checkoutPage;
    protected ProductDetailsPage productDetailsPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutYourInformationPage checkoutYourInformationPage;
    protected CheckoutCompletePage checkoutCompletePage;

    protected LoginData validUser;
    protected LoginData invalidUser;
    protected LoginData lockedUser;
    protected ExpectedTotals expectedTotals;

    @BeforeMethod
    public void before() {
        driver = DriverFactory.getDriver();
        DriverFactory.driver = driver;
        // inițializare WaitUtils și Pages
        waitUtils = new WaitUtils(driver);
        loginPage = new LoginPage(driver, waitUtils);
        productsPage = new ProductsPage(driver, waitUtils);
        cartPage = new CartPage(driver, waitUtils);
        checkoutPage = new CheckoutYourInformationPage(driver,waitUtils);
        productDetailsPage = new ProductDetailsPage(driver, waitUtils);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver, waitUtils);
        checkoutOverviewPage = new CheckoutOverviewPage(driver, waitUtils);
        checkoutCompletePage = new CheckoutCompletePage(driver,  waitUtils);

        // inițializare date de login
        validUser = new LoginData("validUser");
        invalidUser = new LoginData("invalidUser");
        lockedUser = new LoginData("lockedUser");
        expectedTotals = new ExpectedTotals("expectedTotals");

        driver.get(URL.MAIN_URL);
    }


    @AfterMethod
    public void after() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


    //helper metods
    protected void startFromProductsPage() {
        loginPage.authenticate(validUser.getUsername(), validUser.getPassword());
        Assert.assertTrue(productsPage.isCartButtonDisplayed());
    }

    protected void startFromCheckoutPage(){
        startFromProductsPage();
        productsPage.clickAddToCartButton();
        productsPage.clickCartButton();
        cartPage.clickCheckoutButton();
    }


}
