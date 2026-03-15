import org.testng.Assert;
import org.testng.annotations.Test;
import testData.classes.CheckoutData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EndToEndTests extends BaseTests {

    @Test
    public void fullEndtoEndFlow() {
        // 1. Login with valid data (standard user)
        loginPage.authenticate(validUser.getUsername(), validUser.getPassword());
        Assert.assertEquals(productsPage.getTitleText(), "Products", "Title should be Products after login");
        Assert.assertTrue(productsPage.isCartButtonDisplayed(), "Cart button should be displayed after log in");

        // 2. Filter A to Z
        productsPage.selectSortOption("Name (A to Z)");

        List<String> actualNames = productsPage.getProductNames();

        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames);

        Assert.assertEquals(actualNames, expectedNames, "Products are not sorted A to Z");

        // 3. Open product & check details
        productsPage.openFirstProduct();

        String productDescription = productDetailsPage.getProductDescription();
        double productPrice = productDetailsPage.getProductPriceValue();

        Assert.assertFalse(productDescription.isEmpty(), "Product description should not be empty");
        Assert.assertTrue(productPrice > 0, "Product price should be greater than zero");

        // 4. Add to cart
        productDetailsPage.clickAddToCartButton();
        productsPage.clickCartButton();

        double cartPrice = cartPage.getProductPriceValue();

        Assert.assertEquals(cartPrice, productPrice, 0.01, "Product price in cart should match product page");
        Assert.assertTrue(cartPage.isCartHeaderDisplayed(), "Cart header should be displayed after clicking cart");
        Assert.assertTrue(cartPage.isProductDisplayed(), "Product should be displayed");
        Assert.assertEquals(cartPage.getProductDescription(), productDescription, "Product description in cart should match product page");

        // 5. Checkout – user details
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.enterCheckoutInformation(checkoutData);

        // 6. Order overview – check values
        Assert.assertEquals(checkoutOverviewPage.getProductDescription(), productDescription, "Product description should match ");


        List<Double> totals = checkoutOverviewPage.getTotalsValuesList();
        double itemTotal = totals.get(0);
        double tax = totals.get(1);
        double total = totals.get(2);

        Assert.assertEquals(total, itemTotal + tax, 0.01, "Total should equal item total + tax");

        // 7. Finish order
        checkoutOverviewPage.clickFinishButton();

        // 8. Confirmation
        Assert.assertTrue(checkoutCompletePage.isCompleteHeaderDisplayed(), "Complete header should be visible after finishing order");
        Assert.assertTrue(checkoutCompletePage.isCompleteTextDisplayed(), "Complete header should be visible after finishing order");

        // 9. Logout
        productsPage.openMenu();
        productsPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Logout failed – login button not visible");
    }

    }

