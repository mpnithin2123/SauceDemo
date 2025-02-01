package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader
{
    public String getURL() {
        Properties properties = new Properties();
        String url = null;

        try (FileInputStream fileInput = new FileInputStream("config.properties")) {
            properties.load(fileInput);
            url = properties.getProperty("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return url;
    }
}
