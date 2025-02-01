package utilities;


import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass
{
    public static WebDriver driver;
    public static WebDriverWait wait;

    public WebDriver getDriver()
    {
        if (driver == null)
        {
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        }
        return driver;
    }

    public static void waitForAnElementToBeVisible(WebElement element)
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void quitDriver()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }
}
