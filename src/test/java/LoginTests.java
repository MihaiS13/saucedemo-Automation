import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test
    public void validLogin() {
        loginPage.authenticate(validUser.getUsername(), validUser.getPassword());
        Assert.assertEquals(productsPage.getTitleText(),"Products", "Products page title should be displayed after successful login");
        Assert.assertTrue(productsPage.isCartButtonDisplayed(), "Cart button should be visible after login");

    }

    @Test
    public void invalidLogin() {
        loginPage.authenticate(invalidUser.getUsername(), invalidUser.getPassword());
        Assert.assertEquals(loginPage.getLogoText(), "Swag Labs", "User should remain on login page after invalid login");
        Assert.assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service", "Proper error message should appear for invalid credentials");
    }

    @Test
    public void lockedLogin() {
        loginPage.authenticate(lockedUser.getUsername(), lockedUser.getPassword());
        Assert.assertEquals(loginPage.getLogoText(), "Swag Labs", "Locked user should remain on login page");
        Assert.assertEquals(loginPage.getLockedError(), "Epic sadface: Sorry, this user has been locked out.", "Proper error message should appear for locked user");

    }

}

