package Base;

import Logger.LoggerManager;
import Util.DriverUtil;
import Util.WaitsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class BaseElement {
    protected By uniqueLocator;
    protected String elementName;
    private final LoggerManager logger = new LoggerManager();

    protected BaseElement(By uniqueLocator, String elementName) {
        this.uniqueLocator = uniqueLocator;
        this.elementName = elementName;
    }

    public WebElement getElement() {
        return DriverUtil.getDriver().findElement(uniqueLocator);
    }

    public List<WebElement> getElements() {
        return DriverUtil.getDriver().findElements(uniqueLocator);
    }

    public void scrollToElement() {
        logger.info("Scrolling to " + elementName + " element");
        DriverUtil.scrollToElement(uniqueLocator);
    }

    public void isVisible() {
        logger.info("Checking if " + elementName + " is visible");
        WaitsUtil.waitForElementToBeVisible(uniqueLocator);
    }

    public void isPresented() {
        logger.info("Checking if " + elementName + " is presented on page");
        WaitsUtil.waitForElementToBePresented(uniqueLocator);
    }

    public void click() {
        logger.info("Waiting for " + elementName + " to be clickable");
        WaitsUtil.waitForElementToBeClickable(uniqueLocator);
        DriverUtil.getDriver().findElement(uniqueLocator).click();
        logger.info(elementName + " clicked");
    }

    public void moveToElementAndClick() {
        logger.info("Waiting for " + elementName + " to be clickable");
        WaitsUtil.waitForElementToBeClickable(uniqueLocator);
        Actions act = new Actions(DriverUtil.getDriver());
        act.moveToElement(DriverUtil.getDriver().findElement(uniqueLocator)).click().build().perform();
        logger.info("Moved mouse cursor to " + elementName + " and clicked");
    }
}
