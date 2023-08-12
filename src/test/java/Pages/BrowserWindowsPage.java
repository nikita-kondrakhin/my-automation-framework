package Pages;

import Base.BaseForm;
import Elements.Button;
import Logger.LoggerManager;
import Util.BrowserUtil;
import Util.DriverUtil;
import org.openqa.selenium.By;

import java.util.Set;

public class BrowserWindowsPage extends BaseForm {
    private final LoggerManager logger = new LoggerManager();

    public Button newTabButton = new Button(By.id("tabButton"), "New Tab button");

    public BrowserWindowsPage() {
        super(By.xpath("//div[@class='main-header' and text()='Browser Windows']"), "Browser Windows page");
    }

    public void clickNewTabButton() {
        newTabButton.isPresented();
        newTabButton.moveToElementAndClick();
    }

    public String getCurrentWindowHandle() {
        return BrowserUtil.getCurrentWindowHandle();
    }

    public Set<String> getCurrentWindowHandles() {
        return BrowserUtil.getCurrentHandles();
    }

    public void switchToTheNewWindow(String currentWindowHandle, Set<String> windowHandles) {
        BrowserUtil.switchToTheNewWindow(currentWindowHandle, windowHandles);
    }

    public void switchToSpecificTab(String windowHandle) {
        BrowserUtil.switchToSpecificWindow(windowHandle);
    }

    public void closeCurrentTab() {
        logger.debug("Closing current tab");
        DriverUtil.getDriver().close();
    }

    public int getTabCount() {
        return DriverUtil.getDriver().getWindowHandles().size();
    }
}
