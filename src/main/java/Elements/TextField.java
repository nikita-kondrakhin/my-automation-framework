package Elements;

import Base.BaseElement;
import Logger.LoggerManager;
import User.User;
import Util.DriverUtil;
import org.openqa.selenium.By;

public class TextField extends BaseElement {
    private final LoggerManager logger = new LoggerManager();
    public TextField(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void enterText(String text) {
        logger.debug("Entered user data to " + elementName);
        DriverUtil.getDriver().findElement(uniqueLocator).sendKeys(text);
    }
}
