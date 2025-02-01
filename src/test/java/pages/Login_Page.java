package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;
import utilities.CustomWebElement;

public class Login_Page
{
    private BaseClass baseClass;
    private CustomWebElement login_button;
    private CustomWebElement login_logo;
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement submitButton;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;
    @FindBy(xpath = "//div[@class='login_logo']")
    WebElement loginLogo;
    WebDriver driver;
    public Login_Page(WebDriver driver,BaseClass baseClass)
    {
        this.driver = driver;
        this.baseClass=baseClass;
        PageFactory.initElements(driver, this);
        this.login_button=new CustomWebElement(submitButton);
        this.login_logo=new CustomWebElement(loginLogo);
    }

    public void enterUsernameAndPassword(String username, String pswd)
    {
        userName.sendKeys(username);
        password.sendKeys(pswd);
    }

    public void enterLoginButton()
    {
        submitButton.click();
    }

    public String readErrorMessage()
    {
        return errorMessage.getText();
    }

    public boolean verifyUserLandedSignInPage()
    {
        baseClass.waitForAnElementToBeVisible(loginLogo);
        if(loginLogo.isDisplayed())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getLoginButtonText()
    {
        return login_button.getAttribute("value");
    }

    public String getLoginLogoText()
    {
        return login_logo.getText();
    }
}
