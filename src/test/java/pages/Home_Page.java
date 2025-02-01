package pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;
import utilities.CustomWebElement;

import java.util.Set;

public class Home_Page {
    private BaseClass baseClass;
    private CustomWebElement addBackPackToCrt;
    @FindBy(xpath = "//span[text()='Products']")
    WebElement productTitle;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement addBackPackToCart;
    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    WebElement clickOnCart;
    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    WebElement backPack;
    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    WebElement removeFromCart;
    @FindBy(xpath = "//button[@id='continue-shopping']")
    WebElement continueShopping;

    WebDriver driver;

    public Home_Page(WebDriver driver, BaseClass baseClass) {
        this.driver = driver;
        this.baseClass = baseClass;
        PageFactory.initElements(driver, this);
        this.addBackPackToCrt=new CustomWebElement(addBackPackToCart);
    }

    public boolean verifyTitle(String title) {
        baseClass.waitForAnElementToBeVisible(productTitle);
        if (productTitle.getText().equals(title)) {
            return true;
        } else {
            return false;
        }
    }

    public String getTheSessionDetails() {
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("Cookie Name:" + cookie.getName() + "value:" + cookie.getValue());
            if (cookie.getName().equals("session-username")) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public void clickOnBackPackAddCart()
    {
        baseClass.waitForAnElementToBeVisible(productTitle);
        addBackPackToCart.click();
    }

    public void userClickOnCart()
    {
        clickOnCart.click();
    }

    public boolean verifyBackPackIsAddedToCart()
    {
        return backPack.isDisplayed();
    }

    public void removeFromCarts()
    {
        removeFromCart.click();
    }

    public boolean verifyItemRemovedFromCart()
    {
        continueShopping.click();
        addBackPackToCrt.getText();
        if(addBackPackToCart.getText().equals("Add to cart"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
