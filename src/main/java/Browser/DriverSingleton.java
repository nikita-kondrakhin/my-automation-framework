package Browser;

import Config.ConfigManager;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {
    private static WebDriver driver = null;

    private DriverSingleton() {}

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(ConfigManager.getConfigData().getBrowser());
        }
        return driver;
    }

    public static void resetDriver() {
        driver = null;
    }
}
