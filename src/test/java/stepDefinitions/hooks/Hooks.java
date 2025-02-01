package stepDefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BaseClass;

import static utilities.BaseClass.driver;

public class Hooks
{
    @After
    public void afterScenario(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Test Screenshot");
        }
        BaseClass.quitDriver();
    }
}
