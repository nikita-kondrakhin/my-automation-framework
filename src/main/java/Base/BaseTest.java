package Base;

import Browser.DriverSingleton;
import Logger.LoggerManager;
import Util.DriverUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    private final LoggerManager logger = new LoggerManager();

    @BeforeTest
    public void setupTest() {
        logger.info("Test started");
        DriverSingleton.getInstance();
        DriverUtil.maximizeWindow();
    }

    @AfterTest
    public void endTest() {
        logger.info("Test ended");
        DriverUtil.quitDriver();
    }
}
