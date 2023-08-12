package Elements;

import Base.BaseElement;
import Config.ConfigManager;
import Logger.LoggerManager;
import Util.RandomUtil;
import org.openqa.selenium.By;


public class Text extends BaseElement {
    private static final LoggerManager logger = new LoggerManager();

    public Text(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public static String randomText() {
        logger.debug("Getting random text");
        return RandomUtil.getRandomString(ConfigManager.getTestData().getRandomTextLength());
    }

    public String getText() {
        return super.getElement().getText();
    }
}
