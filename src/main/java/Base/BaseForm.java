package Base;

import Config.ConfigManager;
import Logger.LoggerManager;
import Util.DriverUtil;
import Util.WaitsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;


public abstract class BaseForm {
    protected By uniqueLocator;
    protected String formName;
    private final LoggerManager logger = new LoggerManager();

    protected BaseForm() {}

    protected BaseForm(By uniqueLocator, String formName) {
        this.uniqueLocator = uniqueLocator;
        this.formName = formName;
    }

    public void openMainPage() {
        DriverUtil.getDriver().get(ConfigManager.getTestData().getUrl());
        WaitsUtil.waitForPageToLoad();
        logger.info(formName + " is opened");
    }

    public boolean isVisible() {
        logger.info("Checking if " + formName + " is visible");
        try {
            WaitsUtil.waitForElementToBeVisible(uniqueLocator);
            return true;
        } catch (TimeoutException e) {
            logger.warning(formName + " with locator " + uniqueLocator + " is not visible");
            return false;
        }
    }

    public boolean isOpen() {
        logger.info("Checking if " + formName + " is open");
        try {
            WaitsUtil.waitForElementToBePresented(uniqueLocator);
            return true;
        } catch (TimeoutException e) {
            logger.warning(formName + " can't be open");
            return false;
        }
    }
}


