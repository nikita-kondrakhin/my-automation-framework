package Elements;

import Base.BaseElement;
import Logger.LoggerManager;
import Util.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Iframe extends BaseElement {
    private static final LoggerManager logger = new LoggerManager();

    public Iframe(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void switchToIframe() {
        logger.debug("Switching to iframe");
        WebElement iframe = super.getElement();
        DriverUtil.getDriver().switchTo().frame(iframe);
    }

    public static void switchToDefaultContent() {
        logger.debug("Switching to default content");
        DriverUtil.getDriver().switchTo().defaultContent();
    }
}
