package Util;

import Config.ConfigManager;
import Logger.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class WaitsUtil {
    private static final LoggerManager logger = new LoggerManager();
    private static WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(ConfigManager.getConfigData().getDefaultWait()));

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void waitForElementToBeClickable(By uniqueLocator) {
        wait.until(ExpectedConditions.elementToBeClickable(uniqueLocator));
    }

    public static void waitForElementToBeVisible(By uniqueLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(uniqueLocator));
    }

    public static void waitForElementToBePresented(By uniqueLocator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(uniqueLocator));
    }

    public static void waitForNumberOfWindowsToBe(int numberOfWindows) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
    }

    public static void waitForPageToLoad() {
        logger.debug("Waiting for page load");
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        wait.until(pageLoadCondition);
    }
}
