package Util;

import Logger.LoggerManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class AlertsUtil {
    private static final LoggerManager logger = new LoggerManager();
    private static org.openqa.selenium.Alert alert;

    public static boolean isAlertOpen() {
        logger.debug("Checking if alert is open");
        try {
            WaitsUtil.getWait().until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            logger.warning("Alert is not open");
            return false;
        }
    }

    public static void alertAccept() {
        logger.debug("Alert OK button clicked");
        alert = DriverUtil.getDriver().switchTo().alert();
        alert.accept();
    }

    public static void alertRandomTextInput(String randomText) {
        logger.debug("Entered random text to alert");
        alert.sendKeys(randomText);
    }
}
