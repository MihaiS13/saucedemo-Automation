import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CartPage;
import pages.ProductsPage;

public class CartTests extends BaseTests {

    @Override
    @BeforeMethod
    public void before(){
        super.before();

        startFromProductsPage();
    }

    @Test
    public void addAndRemoveProductFromCart() {
        productsPage.clickAddToCartButton();
        productsPage.clickCartButton();
        Assert.assertTrue(cartPage.isCartHeaderDisplayed(), "Cart header should be displayed after opening cart");
        Assert.assertTrue(cartPage.isProductDisplayed(), "Product should be displayed after adding to cart");
        cartPage.clickRemoveButton();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart should be empty after removing the product");
    }

    }


