import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testData.classes.CheckoutData;

public class CheckoutTests extends BaseTests {
    @Override
    @BeforeMethod
    public void before(){
        super.before();

        startFromCheckoutPage();
    }
@Test
    public void checkoutWithInvalidData() {
    checkoutYourInformationPage.enterInvalidData(new CheckoutData("checkoutData"));
    Assert.assertEquals(checkoutYourInformationPage.getCheckoutHeaderText(), "Checkout: Your Information" , "User should remain on checkout information page when data is invalid");
    //BUG
// Expected behavior: stay on Checkout: Your Information
// Actual behavior: user is redirected to Overview page

}


}

