package Util;

import Logger.LoggerManager;

import java.util.Set;

public abstract class BrowserUtil {
    private static final LoggerManager logger = new LoggerManager();

    public static String getCurrentWindowHandle() {
        logger.debug("Getting current window handle");
        return DriverUtil.getDriver().getWindowHandle();
    }

    public static Set<String> getCurrentHandles() {
        logger.debug("Getting all current windows handles");
        return DriverUtil.getDriver().getWindowHandles();
    }

    public static void switchToSpecificWindow(String windowHandle) {
        logger.debug("Switching to specific window");
        DriverUtil.getDriver().switchTo().window(windowHandle);
    }

    public static void switchToTheNewWindow(String currentWindowHandle, Set<String> windowHandles) {
        logger.debug("Switching to the new window");
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                DriverUtil.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}
