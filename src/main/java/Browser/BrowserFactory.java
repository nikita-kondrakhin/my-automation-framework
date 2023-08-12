package Browser;

import Logger.LoggerManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    private static final LoggerManager logger = new LoggerManager();

    public static WebDriver getBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            case "safari" -> {
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            }
            case "ie" -> {
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            }
            default -> {
                logger.warning("Error: please choose another browser");
                return null;
            }
        }
    }
}
