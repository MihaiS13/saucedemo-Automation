package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.RandomGenerator;

public class CheckoutTests extends BaseTests {
    @Override
    @BeforeMethod
    public void before() {
        super.before();

        startFromCheckoutPage();
    }


        @DataProvider(name = "invalidCheckoutData")
        public Object[][] invalidCheckoutData() {
            return new Object[][]{
                    {RandomGenerator.stringValue(30) + "#", "Popescu", "400000"},
                    {"Ion", RandomGenerator.stringValue(30) + "@", "400000"},
                    {"Ion", "Popescu", "#" + RandomGenerator.integerValue(6)}
            };
        }

        @Test(dataProvider = "invalidCheckoutData")
        public void checkoutWithInvalidData(String firstName, String lastName, String postalCode) {
            checkoutYourInformationPage.enterInvalidCheckoutInformation(firstName, lastName, postalCode);
            Assert.assertEquals(checkoutYourInformationPage.getCheckoutHeaderText(), "Checkout: Your Information", "User should remain on checkout information page when data is invalid"
            );
        }
    }


