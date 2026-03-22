package tests;

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

    //Page initialization
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected ProductDetailsPage productDetailsPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutYourInformationPage checkoutYourInformationPage;
    protected CheckoutCompletePage checkoutCompletePage;

    //Data initialization
    protected LoginData validUser;
    protected LoginData invalidUser;
    protected LoginData lockedUser;
    protected CheckoutData checkoutData;

    @BeforeMethod
    public void before() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());

        DriverFactory.initDriver();

        //  WaitUtils and Pages initialization
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        productDetailsPage = new ProductDetailsPage();
        checkoutYourInformationPage = new CheckoutYourInformationPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutCompletePage = new CheckoutCompletePage();

        // data initialization
        validUser = new LoginData("validUser");
        invalidUser = new LoginData("invalidUser");
        lockedUser = new LoginData("lockedUser");
        checkoutData = new CheckoutData("checkoutData");

        //Navigate to URL
        DriverFactory.getDriver().get(URL.MAIN_URL);
    }


    @AfterMethod
    public void afterMethod(ITestResult result) {
        // If test fails, take a screenshoot
        if (result.getStatus() == ITestResult.FAILURE && DriverFactory.getDriver() != null) {
            saveScreenshot(result.getName());
        }

        if (DriverFactory.getDriver() != null) {
            DriverFactory.quitDriver();
        }
    }

    // Screenshoot method for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(String testName) {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
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
