package Util;

import Browser.DriverSingleton;
import Logger.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public abstract class DriverUtil {
    private static final LoggerManager logger = new LoggerManager();

    public static WebDriver getDriver() {
        return DriverSingleton.getInstance();
    }

    public static void maximizeWindow() {
        logger.debug("Maximizing browser window");
        getDriver().manage().window().maximize();
    }

    public static void scrollToElement(By uniqueLocator) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(uniqueLocator));
    }

    public static void closeDriver() {
        logger.info("Closing the browser");
        getDriver().close();
        DriverSingleton.resetDriver();
    }

    public static void quitDriver() {
        logger.info("Quitting the browser");
        getDriver().quit();
        DriverSingleton.resetDriver();
    }
}
