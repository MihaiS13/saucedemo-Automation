import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class BookingTests extends BaseTests {
    @Override
    @BeforeMethod
    public void before(){
        super.before();

        startFromProductsPage();
    }


            @Test
            public void createBookingForOneProduct() {

                // 1. Open product & check details
                productsPage.openFirstProduct();

                String productDescription = productDetailsPage.getProductDescription();
                double productPrice = productDetailsPage.getProductPriceValue();

                Assert.assertFalse(productDescription.isEmpty(), "Product description should not be empty");
                Assert.assertTrue(productPrice > 0, "Product price should be greater than zero");
                // 2. Add to cart
                productDetailsPage.clickAddToCartButton();
                productDetailsPage.clickCartButton();

                double cartPrice = cartPage.getProductPriceValue();

                Assert.assertEquals(cartPrice, productPrice, "Product price in cart should match product page");
                Assert.assertTrue(cartPage.isCartHeaderDisplayed(), "Cart header should be displayed after clicking cart");
                Assert.assertTrue(cartPage.isProductDisplayed(), "Product should be displayed");
                Assert.assertEquals(cartPage.getProductDescription(), productDescription, "Product description in cart should match product page");

                // 3. Checkout – user details
                cartPage.clickCheckoutButton();
                checkoutYourInformationPage.enterCheckoutInformation(checkoutData);

                // 4. Order overview – check values
                String overviewHeader = checkoutOverviewPage.getHeaderText();
                Assert.assertTrue(overviewHeader.contains("Overview"), "Overview header should be displayed");
                Assert.assertEquals(checkoutOverviewPage.getProductDescription(), productDescription, "Product description should match ");

                List<Double> totals = checkoutOverviewPage.getTotalsValuesList();
                double itemTotal = totals.get(0);
                double tax = totals.get(1);
                double total = totals.get(2);

                Assert.assertEquals(total, itemTotal + tax, 0.01, "Total should equal item total + tax");

                // 5. Finish order
                checkoutOverviewPage.clickFinishButton();

                // 6. Confirmation
                Assert.assertTrue(checkoutCompletePage.isCompleteHeaderDisplayed(),"Checkout complete header should be displayed");
                Assert.assertTrue(checkoutCompletePage.isCompleteTextDisplayed(),"Checkout complete text should be displayed");
            }
        }


