package stepDefinitions.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Login_Page;
import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.Screenshot;

public class Login_Steps
{
    BaseClass base=new BaseClass();
    WebDriver driver;
    ConfigReader config ;
    Login_Page loginPage;

    public Login_Steps()
    {
        driver= base.getDriver();
        config=new ConfigReader();
        loginPage=new Login_Page(driver,base);
    }

    @Given("user navigates to the SauceDemo website")
    public void navigateToSauceDemoURL()
    {
        driver.get(config.getURL());
    }

    @When("user enters the {string} and {string}")
    @When("user enters an invalid {string} and {string}")
    public void enterCredentials(String username, String password)
    {
        loginPage.enterUsernameAndPassword(username,password);
    }

    @When("clicks on login button")
    public void clickLoginButton()
    {
        loginPage.enterLoginButton();
    }

    @Then("error message {string} is displayed to the user")
    public void verifyErrorMessage(String errorMessage)
    {
        Assert.assertEquals(errorMessage,loginPage.readErrorMessage());
        Screenshot.takeScreenshot(driver);
    }

    @Then("close the browser")
    public void browserClose()
    {
        base.quitDriver();
    }

    @When("user lands in the sign in page")
    public void verifyUserLandsInTheSignInPage()
    {
        Assert.assertTrue(loginPage.verifyUserLandedSignInPage());
    }

    @Then("user is able to view the Login button as {string} and Login logo as {string}")
    public void verifyLoginLogoAndLoginButton(String lgnBtn,String lgnLogo)
    {
        Assert.assertEquals(lgnBtn,loginPage.getLoginButtonText());
        Assert.assertEquals(lgnLogo,loginPage.getLoginLogoText());
    }
}
