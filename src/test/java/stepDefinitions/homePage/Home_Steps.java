package stepDefinitions.homePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Home_Page;
import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.Screenshot;

public class Home_Steps
{
    BaseClass base=new BaseClass();
    WebDriver driver;
    ConfigReader config ;
    Home_Page homePage;

    public Home_Steps()
    {
        driver= base.getDriver();
        config=new ConfigReader();
        homePage=new Home_Page(driver,base);
    }

    @Then("user is navigated to the home page")
    public void navigateToHomePage()
    {
        Assert.assertTrue(homePage.verifyTitle("Products"));
        Screenshot.takeScreenshot(driver);
    }

    @Then("verify the cookie is storing the session username and it is same as the {string} used for login")
    public void getTheSessionDetails(String userName)
    {
        Assert.assertEquals(userName,homePage.getTheSessionDetails());
    }

    @When("user clicks on Add to cart for Sauce Labs Backpack")
    public void addItemToCart()
    {
        homePage.clickOnBackPackAddCart();
        homePage.userClickOnCart();
    }

    @Then("the product is added to the cart")
    public void verifyCart()
    {
        Assert.assertTrue(homePage.verifyBackPackIsAddedToCart());
        Screenshot.takeScreenshot(driver);
    }

    @When("user clicks on Remove button for Sauce Labs Backpack")
    public void removeItemFromCart()
    {
        homePage.removeFromCarts();
    }

    @Then("Item is removed from the cart")
    public void verifyItemRemovedFRomCart()
    {
        Assert.assertTrue(homePage.verifyItemRemovedFromCart());
        Screenshot.takeScreenshot(driver);
    }

}
