package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot
{
    public static void takeScreenshot(WebDriver driver)
    {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = timestamp + ".png";
        String folderPath = System.getProperty("user.dir") + "/screenshots/";
        File screenshotDir = new File(folderPath);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(folderPath + fileName);

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot taken " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
}
