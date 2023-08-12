package Tests;

import Base.BaseTest;
import Config.ConfigManager;
import Logger.LoggerManager;
import Pages.BrowserWindowsPage;
import Pages.LinksPage;
import Pages.MainPage;
import Pages.SamplePage;
import Util.WaitsUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class HandlesTest extends BaseTest {
    private final LoggerManager logger = new LoggerManager();
    MainPage mainPage = new MainPage();
    BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
    SamplePage samplePage = new SamplePage();
    LinksPage linksPage = new LinksPage();

    @Test
    public void handlesTest() {
        logger.info("Running " + this.getClass().toString() + ":");

        mainPage.openMainPage();
        Assert.assertTrue(mainPage.isOpen(), "Wrong page. Main page should be opened");
        mainPage.openAlertsFramesAndWindowsPage();
        mainPage.openBrowserWindowsPage();
        Assert.assertTrue(browserWindowsPage.isOpen(), "Wrong page. Browser Windows page should be opened");
        String browserWindowsPageCurrentHandle = browserWindowsPage.getCurrentWindowHandle();
        browserWindowsPage.clickNewTabButton();
        WaitsUtil.waitForNumberOfWindowsToBe(ConfigManager.getConfigData().getExpectedNumberOfWindows());
        Set<String> browserWindowsPageUpdatedHandles = browserWindowsPage.getCurrentWindowHandles();
        browserWindowsPage.switchToTheNewWindow(browserWindowsPageCurrentHandle, browserWindowsPageUpdatedHandles);
        samplePage.isOpen();
        browserWindowsPage.closeCurrentTab();
        browserWindowsPage.switchToSpecificTab(browserWindowsPageCurrentHandle);
        Assert.assertTrue(browserWindowsPage.isOpen(), "Wrong page. Browser Windows page should be opened");
        mainPage.openLinksPage();
        Assert.assertTrue(linksPage.isOpen(), "Wrong page. Links page should be opened");
        String linksPageCurrentWindowHandle = linksPage.getCurrentWindowHandle();
        linksPage.clickHomeLink();
        WaitsUtil.waitForNumberOfWindowsToBe(ConfigManager.getConfigData().getExpectedNumberOfWindows());
        Set<String> homeLinkUpdatedWindowHandles = linksPage.getCurrentWindowHandles();
        linksPage.switchToTheNewWindow(linksPageCurrentWindowHandle, homeLinkUpdatedWindowHandles);
        Assert.assertTrue(mainPage.isOpen(), "Wrong page. Main page should be opened");
        linksPage.switchToSpecificWindow(linksPageCurrentWindowHandle);
        linksPage.isOpen();
    }
}
