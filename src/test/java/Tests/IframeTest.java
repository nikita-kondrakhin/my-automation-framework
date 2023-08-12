package Tests;

import Base.BaseTest;
import Logger.LoggerManager;
import Pages.FramesPage;
import Pages.NestedFramesPage;
import Pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {
    private final LoggerManager logger = new LoggerManager();
    MainPage mainPage = new MainPage();
    NestedFramesPage nestedFramesPage = new NestedFramesPage();
    FramesPage framesPage = new FramesPage();

    @Test
    public void iframeTest() {
        logger.info("Running " + this.getClass().toString() + ":");

        mainPage.openMainPage();
        Assert.assertTrue(mainPage.isOpen(), "Wrong page. Main page should be opened");
        mainPage.openAlertsFramesAndWindowsPage();
        mainPage.openNestedFramesPage();
        Assert.assertTrue(nestedFramesPage.isOpen(), "Wrong page. Nested frames page should be opened");
        Assert.assertEquals(nestedFramesPage.getNestedParentFrameText(), "Parent frame", "\"Parent frame\" message is not present on page");
        Assert.assertEquals(nestedFramesPage.getNestedChildFrameText(), "Child Iframe", "\"Child Iframe\" message is not present on page");
        nestedFramesPage.switchToDefaultContent();
        mainPage.openFramesPage();
        Assert.assertTrue(framesPage.isOpen(), "Wrong page. Frames page should be opened");
        String messageOne = framesPage.getUpperFrameText();
        framesPage.switchToDefaultContent();
        String messageTwo = framesPage.getLowerFrameText();
        Assert.assertEquals(messageOne, messageTwo, "Upper and lower frames messages are not equal");
    }
}















