import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testData.classes.CheckoutData;


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
                String productPrice = productDetailsPage.getProductPrice();

                Assert.assertFalse(productDescription.isEmpty(), "Product description should not be empty");
                Assert.assertFalse(productPrice.isEmpty(), "Product price should not be empty");

                // 2. Add to cart
                productDetailsPage.clickAddToCartButton();
                productDetailsPage.clickCartButton();

                Assert.assertTrue(cartPage.isCartHeaderDisplayed(), "Cart header should be displayed after clicking cart");
                Assert.assertTrue(cartPage.isProductDisplayed(), "Product should be displayed");
                Assert.assertEquals(cartPage.getProductDescription(), productDescription, "Product description in cart should match product page");
                Assert.assertEquals(cartPage.getProductPrice(), productPrice, "Product price in cart should match product page");

                // 3. Checkout – user details
                cartPage.clickCheckoutButton();

                checkoutYourInformationPage.enterValidData(new CheckoutData("checkoutData"));


                // 4. Order overview – check values

                Assert.assertFalse(checkoutOverviewPage.getHeaderText().isEmpty(), "Overview header should be displayed");
                Assert.assertEquals(checkoutOverviewPage.getProductDescription(), productDescription, "Product description should match ");

                List<String> totals = checkoutOverviewPage.getTotalsList();

                Assert.assertEquals(totals.get(0), expectedTotals.getItemTotal(), "Item total should match the expected value");
                Assert.assertEquals(totals.get(1), expectedTotals.getTax(), "Tax should match the expected value");
                Assert.assertEquals(totals.get(2), expectedTotals.getTotal(),"Total should match the expected value (itemTotal + tax)");

                // 5. Finish order
                checkoutOverviewPage.clickFinishButton();

                // 6. Confirmation
                Assert.assertTrue(checkoutCompletePage.isCompleteHeaderDisplayed(),"Checkout complete header should be displayed");
                Assert.assertTrue(checkoutCompletePage.isCompleteTextDisplayed(),"Checkout complete text should be displayed");
            }
        }


